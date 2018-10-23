//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.09.08 à 11:31:21 AM CEST 
//


package com.orange.onapbss.datamodel.addressValidation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour ZError complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ZError"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="infoURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="details" type="{http://orange.com/POC_ONAP/api/address/v0/model}ZErrorDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZError", propOrder = {
    "code",
    "message",
    "description",
    "infoURL",
    "details"
})
public class ZError {

    protected int code;
    @XmlElement(required = true)
    protected String message;
    protected String description;
    protected String infoURL;
    protected List<ZErrorDetail> details;

    /**
     * Obtient la valeur de la propriété code.
     *
     */
    public int getCode() {
        return code;
    }

    /**
     * Définit la valeur de la propriété code.
     *
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * Obtient la valeur de la propriété message.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * Définit la valeur de la propriété message.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété infoURL.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInfoURL() {
        return infoURL;
    }

    /**
     * Définit la valeur de la propriété infoURL.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInfoURL(String value) {
        this.infoURL = value;
    }

    /**
     * Gets the value of the details property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the details property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetails().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZErrorDetail }
     *
     *
     */
    public List<ZErrorDetail> getDetails() {
        if (details == null) {
            details = new ArrayList<ZErrorDetail>();
        }
        return this.details;
    }

}
