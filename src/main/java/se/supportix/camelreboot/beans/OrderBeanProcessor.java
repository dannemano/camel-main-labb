package se.supportix.camelreboot.beans;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import se.ithuset.fakturering.Fakturering;
import se.supportix.camelreboot.xml.Order;


public class OrderBeanProcessor {

	private static final Logger logger = LoggerFactory.getLogger(OrderBeanProcessor.class);
	
	@Autowired
	Fakturering fakturaWS;
	
	/**
	* A POJO acting as a processor in the route. Sets a couple of required properties and headers needed 
	* further down the route!
	*
	* Why the body is set to null in the last line is a technicality due to the HTTP4-component.
	* See the documentation http://camel.apache.org/http4.html and for extra credits explain why!
	*/
	public void processOrder(Order order, Exchange exchange) {
		//Add this Order object to the exchange header as we will need it later on.
		exchange.setProperty("robusta-order", order);
		
		//Set some additional headers which ease the use of HTTP.
		exchange.getIn().setHeader("robusta-productId", order.getProductId());
		
		//Set body to null for rest call.
		exchange.getIn().setBody(null);
	}
	
}
