
package se.ithuset.fakturering;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import se.ithuset.fakturering.schemas.FaktureraRequest;
import se.ithuset.fakturering.schemas.FaktureraResponse;
import se.ithuset.fakturering.schemas.PingRequest;
import se.ithuset.fakturering.schemas.PingResponse;
import se.ithuset.fakturering.schemas.SaldoRequest;
import se.ithuset.fakturering.schemas.SaldoResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.0
 * 
 */
@WebService(name = "Fakturering", targetNamespace = "http://www.ithuset.se/fakturering")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Fakturering {


    /**
     * 
     * @param pingRequest
     * @return
     *     returns se.ithuset.fakturering.schemas.PingResponse
     */
    @WebMethod(operationName = "Ping")
    @WebResult(name = "PingResponse", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "PingResponse")
    public PingResponse ping(
        @WebParam(name = "PingRequest", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "PingRequest")
        PingRequest pingRequest);

    /**
     * 
     * @param faktureraRequest
     * @return
     *     returns se.ithuset.fakturering.schemas.FaktureraResponse
     */
    @WebMethod(operationName = "Fakturera")
    @WebResult(name = "FaktureraResponse", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "FaktureraResponse")
    public FaktureraResponse fakturera(
        @WebParam(name = "FaktureraRequest", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "FaktureraRequest")
        FaktureraRequest faktureraRequest);

    /**
     * 
     * @param saldoRequest
     * @return
     *     returns se.ithuset.fakturering.schemas.SaldoResponse
     */
    @WebMethod(operationName = "Saldo")
    @WebResult(name = "SaldoResponse", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "SaldoResponse")
    public SaldoResponse saldo(
        @WebParam(name = "SaldoRequest", targetNamespace = "http://ithuset.se/fakturering/schemas", partName = "SaldoRequest")
        SaldoRequest saldoRequest);

}
