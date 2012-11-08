
package se.ithuset.fakturering.schemas;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Orderrader" type="{http://ithuset.se/fakturering/schemas}Orderrad" maxOccurs="unbounded"/>
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
    "kundnummer",
    "orderrader"
})
@XmlRootElement(name = "FaktureraRequest")
public class FaktureraRequest {

    @XmlElement(name = "Kundnummer")
    protected long kundnummer;
    @XmlElement(name = "Orderrader", required = true)
    protected List<Orderrad> orderrader;

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

    /**
     * Gets the value of the orderrader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderrader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderrader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Orderrad }
     * 
     * 
     */
    public List<Orderrad> getOrderrader() {
        if (orderrader == null) {
            orderrader = new ArrayList<Orderrad>();
        }
        return this.orderrader;
    }

}
