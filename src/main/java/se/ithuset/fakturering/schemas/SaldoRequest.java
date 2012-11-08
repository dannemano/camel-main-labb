
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
 *         &lt;element name="Kundnummer" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "kundnummer"
})
@XmlRootElement(name = "SaldoRequest")
public class SaldoRequest {

    @XmlElement(name = "Kundnummer")
    protected long kundnummer;

    /**
     * Gets the value of the kundnummer property.
     * 
     */
    public long getKundnummer() {
        return kundnummer;
    }

    /**
     * Sets the value of the kundnummer property.
     * 
     */
    public void setKundnummer(long value) {
        this.kundnummer = value;
    }

}
