//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.09.08 à 11:31:21 AM CEST 
//


package com.orange.onapbss.datamodel.addressValidation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.orange.onapbss.converter.JsonDateSerializer;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Resource used to support a request for a validation address : check if an address described by values attributes exists)
 * If exist, id is provided
 * if not, alternate address(es) could be provided
 * 
 * <p>Classe Java pour AddressValidation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AddressValidation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="validationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="validationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provideaAlternative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="validAddress" type="{http://orange.com/POC_ONAP/api/address/v0/model}GeographicAddress" minOccurs="0"/&gt;
 *         &lt;element name="alternateAddress" type="{http://orange.com/POC_ONAP/api/address/v0/model}GeographicAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressValidation", propOrder = {
    "id",
    "href",
    "status",
    "validationDate",
    "validationResult",
    "provideaAlternative",
    "validAddress",
    "alternateAddress"
})
@Document
public class AddressValidation {

    @Id
    protected String id;
    protected String href;
    protected String status;
    //@XmlSchemaType(name = "dateTime")
    protected Date validationDate;
    protected String validationResult;
    protected Boolean provideaAlternative;
    protected GeographicAddress validAddress;
    protected List<GeographicAddress> alternateAddress;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété href.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Définit la valeur de la propriété href.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété validationDate.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getValidationDate() {
        return validationDate;
    }

    /**
     * Définit la valeur de la propriété validationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setValidationDate(Date value) {
        this.validationDate = value;
    }

    /**
     * Obtient la valeur de la propriété validationResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationResult() {
        return validationResult;
    }

    /**
     * Définit la valeur de la propriété validationResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationResult(String value) {
        this.validationResult = value;
    }

    /**
     * Obtient la valeur de la propriété provideaAlternative.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProvideaAlternative() {
        return provideaAlternative;
    }

    /**
     * Définit la valeur de la propriété provideaAlternative.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProvideaAlternative(Boolean value) {
        this.provideaAlternative = value;
    }

    /**
     * Obtient la valeur de la propriété validAddress.
     * 
     * @return
     *     possible object is
     *     {@link GeographicAddress }
     *     
     */
    public GeographicAddress getValidAddress() {
        return validAddress;
    }

    /**
     * Définit la valeur de la propriété validAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicAddress }
     *     
     */
    public void setValidAddress(GeographicAddress value) {
        this.validAddress = value;
    }

    /**
     * Gets the value of the alternateAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternateAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternateAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeographicAddress }
     * 
     * 
     */
    public List<GeographicAddress> getAlternateAddress() {
        if (alternateAddress == null) {
            alternateAddress = new ArrayList<GeographicAddress>();
        }
        return this.alternateAddress;
    }

}
