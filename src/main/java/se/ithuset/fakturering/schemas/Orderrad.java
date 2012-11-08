
package se.ithuset.fakturering.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Orderrad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Orderrad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vara" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Antal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Orderrad", propOrder = {
    "vara",
    "antal"
})
public class Orderrad {

    @XmlElement(name = "Vara", required = true)
    protected String vara;
    @XmlElement(name = "Antal")
    protected int antal;

    /**
     * Gets the value of the vara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVara() {
        return vara;
    }

    /**
     * Sets the value of the vara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVara(String value) {
        this.vara = value;
    }

    /**
     * Gets the value of the antal property.
     * 
     */
    public int getAntal() {
        return antal;
    }

    /**
     * Sets the value of the antal property.
     * 
     */
    public void setAntal(int value) {
        this.antal = value;
    }

}
