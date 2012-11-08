
package se.ithuset.fakturering.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fakturanummer" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fakturanummer"
})
@XmlRootElement(name = "FaktureraResponse")
public class FaktureraResponse {

    @XmlElement(name = "Fakturanummer")
    protected long fakturanummer;

    /**
     * Gets the value of the fakturanummer property.
     * 
     */
    public long getFakturanummer() {
        return fakturanummer;
    }

    /**
     * Sets the value of the fakturanummer property.
     * 
     */
    public void setFakturanummer(long value) {
        this.fakturanummer = value;
    }

}
