
package se.ithuset.fakturering.schemas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the se.ithuset.fakturering.schemas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: se.ithuset.fakturering.schemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Orderrad }
     * 
     */
    public Orderrad createOrderrad() {
        return new Orderrad();
    }

    /**
     * Create an instance of {@link FaktureraRequest }
     * 
     */
    public FaktureraRequest createFaktureraRequest() {
        return new FaktureraRequest();
    }

    /**
     * Create an instance of {@link FaktureraResponse }
     * 
     */
    public FaktureraResponse createFaktureraResponse() {
        return new FaktureraResponse();
    }

    /**
     * Create an instance of {@link PingRequest }
     * 
     */
    public PingRequest createPingRequest() {
        return new PingRequest();
    }

    /**
     * Create an instance of {@link SaldoResponse }
     * 
     */
    public SaldoResponse createSaldoResponse() {
        return new SaldoResponse();
    }

    /**
     * Create an instance of {@link SaldoRequest }
     * 
     */
    public SaldoRequest createSaldoRequest() {
        return new SaldoRequest();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

}
