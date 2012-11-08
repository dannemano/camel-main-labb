package se.supportix.camelreboot.beans;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import se.ithuset.greenbean.lager.Order;
import se.ithuset.greenbean.lager.Product;

public class LagerInteractionHandlerBean {

	private static final Logger logger = LoggerFactory.getLogger(LagerInteractionHandlerBean.class);
	
	@Autowired
	RestTemplate template;
	
	/**
	 * Handles the saldo request response.
	 * @param lagerProduct The JSON from the HTTP REST service GreenBean Lager
	 * @param exchange The currently routed request.
	 */
	public void handleLagerSaldoRequests(Product lagerProduct, Exchange exchange) {
		//Get the current order. Note the difference in packages.
		se.supportix.camelreboot.xml.Order order = (se.supportix.camelreboot.xml.Order) exchange.getProperty("robusta-order");
		
		
		
		if (order.getQty() > lagerProduct.getItemsInStock()) {
			exchange.getIn().setHeader("robusta-lager-status", "NOK");
		} else {
			exchange.getIn().setHeader("robusta-lager-status", "OK");
		}
		
		logger.info("Items in stock: {}, reorderpoint: {}", lagerProduct.getItemsInStock(),lagerProduct.getReOrderPoint());
		
		if (lagerProduct.getItemsInStock() < lagerProduct.getReOrderPoint()) {
			logger.info("Lager is below reorder point. Order more! A file should be created on the FTP server.");
			CamelContext context = exchange.getContext();
			ProducerTemplate producerTemplate = context.createProducerTemplate();
			producerTemplate.sendBody("direct:resupply", "Please get me more products of type: " + order.getProductId() + "\n");
		}
		
	}
	
	/**
	 * This method acts as an enricher. We need som custom Java code as the DSL code 
	 * would become a bit complex.
	 * 
	 * Note that we dont modify the Exchange in this step. We already have Order and Product info.
	 * 
	 * @param exchange
	 */
	public void handleLagerOrderRequest(Exchange exchange) {
		//Get the current order. Note the difference in packages.
		se.supportix.camelreboot.xml.Order order = (se.supportix.camelreboot.xml.Order) exchange.getProperty("robusta-order");
		int orderId = order.getId();
		Order productOrder = new Order();
		productOrder.setProductId(String.valueOf(order.getProductId()));
		productOrder.setQty(order.getQty());
		productOrder.setCustomerName(order.getCustomerName());
		productOrder.setAddressCity("Hemma");
		productOrder.setAddressZip("123 45");
		
		Integer result = template.postForObject("http://localhost:8081/lager/order/{orderId}", productOrder, Integer.class, orderId);
		logger.info("Got result back {}", result);		
	}
	
	
}
