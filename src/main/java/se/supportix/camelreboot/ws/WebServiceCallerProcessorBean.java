package se.supportix.camelreboot.ws;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import se.ithuset.fakturering.Fakturering;
import se.ithuset.fakturering.schemas.FaktureraRequest;
import se.ithuset.fakturering.schemas.FaktureraResponse;
import se.supportix.camelreboot.beans.LagerInteractionHandlerBean;


public class WebServiceCallerProcessorBean {

	private static final Logger logger = LoggerFactory.getLogger(WebServiceCallerProcessorBean.class);
	
	@Autowired
	private Fakturering fakturaWS;
	
	/**
	* POJO acting as a custom processor. Note the integration with Spring with Autowired-annotation.
	*
	*/
	public void callFakturaWS(Exchange exchange) {
		
		FaktureraRequest req = new FaktureraRequest();
		req.setKundnummer(234234);
		FaktureraResponse response = fakturaWS.fakturera(req);
		
		logger.info("Response from Fakturering: {}", response.getFakturanummer());
		
	}
	
}
