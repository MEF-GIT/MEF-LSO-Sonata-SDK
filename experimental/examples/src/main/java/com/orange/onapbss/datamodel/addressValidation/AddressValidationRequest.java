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


/**
 * Structure used to describe an address validation request
 * 
 * <p>Classe Java pour AddressValidationRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AddressValidationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="provideaAlternative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="validAddress" type="{http://orange.com/POC_ONAP/api/address/v0/model}AddressRequestValidation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressValidationRequest", propOrder = {
    "provideaAlternative",
    "validAddress"
})
public class AddressValidationRequest {

    protected Boolean provideaAlternative;
    protected AddressRequestValidation validAddress;

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
     *     {@link AddressRequestValidation }
     *     
     */
    public AddressRequestValidation getValidAddress() {
        return validAddress;
    }

    /**
     * Définit la valeur de la propriété validAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressRequestValidation }
     *     
     */
    public void setValidAddress(AddressRequestValidation value) {
        this.validAddress = value;
    }

}
