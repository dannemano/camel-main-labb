package se.supportix.camelreboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.ithuset.fakturering.Fakturering;
import se.ithuset.fakturering.schemas.PingRequest;
import se.ithuset.fakturering.schemas.PingResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ConfigurationTests {

	Logger logger = LoggerFactory.getLogger(ConfigurationTests.class);
	
	@Autowired
	Fakturering fakturaWS;
	
	@Test
	public void testFakturaWebServiceUpAndRunning() {
		PingResponse ping = fakturaWS.ping(new PingRequest());
		org.junit.Assert.assertEquals("The Fakturera webservice is not available.", "pong!",ping.getResponse());
	}
	
}
