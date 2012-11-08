package se.supportix.camelreboot;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.supportix.camelreboot.xml.Order;

public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args) throws Exception {
        
        //Initializes the Spring context. All beans in the Spring context will be
        //added to the Camel registry which are created automatically. The beans in the registry
        //can be used in the Java DSL in bean() and beanRef() methods.
    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    	
    	CamelContext camelContext = new SpringCamelContext(context);
        
        //The dataformats used in the route.
        final DataFormat jaxbXmlOrder = new JaxbDataFormat(JAXBContext.newInstance(Order.class));
        final DataFormat gsonProduct = new GsonDataFormat(se.ithuset.greenbean.lager.Product.class);
        
        
        RouteBuilder route1 = new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				//Line below read a file. Unmarshals the XML to a file and calls a bean that acts as a processor.
				from("file:") //TODO Add correct parameters for the file-consumer.
				.unmarshal(jaxbXmlOrder)
				.beanRef("orderBeanProcessor")
				.to("log:se.supportix?level=INFO&showAll=true") //Tip, use logging endpoints a lot to see whats in the exchange!
				.recipientList(simple("http4:localhost:8081/lager/product/${header.robusta-productId}")) //The REST call using recipientList.
				 //TODO On this line. Add a DSL method to unmarshal the JSON response to a Product and set as the message body.
				.beanRef("LagerInteractionHandlerBean", "handleLagerSaldoRequests") //Some logic acting as a processor which sets a couple of required headers.
				.choice(). //Content based router.
				when(simple("${header.robusta-lager-status} == 'OK'")).
				to("direct:inLager")
				.otherwise().to("direct:noLager");
				
				//What to do when no Lager? For extra credits!
				// Send mail? Raise exception?
				//To this last. Answer what happens when come here, and why.
				from("direct:noLager").to("log:se.supportix?level=INFO&showAll=true"); 
				
				//What to do when when need to call our supplier? For extra credits!
				//Tip, take a look at FTP-component.
				from("direct:resupply").to("log:se.supportix?level=INFO&showAll=true");
				
				
				//Handle situation when lager saldo is ok..
				//0. Start reading from the direct endpoint used above "direct:inLager"
				//1. Create Lager order using REST call. Do this using configured Spring REST Template
				//2. Call Faktura WS. Use the WS proxy already configured.
				//3. Mail customer informing them of the success of the order. Use the Mail component.
				from("") //TODO 0. Add where to consume from
				.beanRef("", "") //TODO 1. Use existing bean in the registry to make REST call.
				.beanRef("", "")  //TODO 2. Use existing bean to make JAX-WS call.
				.setBody(simple("Thanks for your order of product ID ${header.robusta-productId}"))
				.setHeader("Content-Type",simple("text/plain"))
				//TODO. Some additional mail headers are required here. Look up the Mail component docs.
				.to("");  //TODO 3. Call a mail server of choice
				
			}
		};
        
		camelContext.addRoutes(route1);
		
		//TODO, dont forget call to start Camel!
		
		System.in.read(); //Wait for a key press to stop.
		
		//TODO, dont forget to stop Camel!
    }
    
    
}
