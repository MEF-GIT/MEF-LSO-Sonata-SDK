//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.09.08 à 11:31:21 AM CEST 
//


package com.orange.onapbss.datamodel.addressValidation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * StreetSegment corresponds to a part of a given street referenced by a number (22) or a set of number (22-24). Sometimes a suffix is added
 * 
 * <p>Classe Java pour StreetSegment complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="StreetSegment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberLast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberLastSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://orange.com/POC_ONAP/api/address/v0/model}AddressRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreetSegment", propOrder = {
    "id",
    "number",
    "numberSuffix",
    "numberLast",
    "numberLastSuffix",
    "address"
})
public class StreetSegment {

    protected String id;
    protected String number;
    protected String numberSuffix;
    protected String numberLast;
    protected String numberLastSuffix;
    protected List<AddressRef> address;

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
     * Obtient la valeur de la propriété number.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumber() {
        return number;
    }

    /**
     * Définit la valeur de la propriété number.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Obtient la valeur de la propriété numberSuffix.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumberSuffix() {
        return numberSuffix;
    }

    /**
     * Définit la valeur de la propriété numberSuffix.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumberSuffix(String value) {
        this.numberSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété numberLast.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumberLast() {
        return numberLast;
    }

    /**
     * Définit la valeur de la propriété numberLast.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumberLast(String value) {
        this.numberLast = value;
    }

    /**
     * Obtient la valeur de la propriété numberLastSuffix.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumberLastSuffix() {
        return numberLastSuffix;
    }

    /**
     * Définit la valeur de la propriété numberLastSuffix.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumberLastSuffix(String value) {
        this.numberLastSuffix = value;
    }

    /**
     * Gets the value of the address property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressRef }
     *
     *
     */
    public List<AddressRef> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressRef>();
        }
        return this.address;
    }

}
