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
 * It is used for addressing within a property in an urban area (country properties are often defined differently). It may refer to a building, a building cluster, or a floor of a multistory building.
 * 
 * <p>Classe Java pour SubAddress complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SubAddress"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subUnitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subUnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="levelType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="levelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="buildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="privateStreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="privateStreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubAddress", propOrder = {
    "id",
    "href",
    "type",
    "name",
    "subUnitType",
    "subUnitNumber",
    "levelType",
    "levelNumber",
    "buildingName",
    "privateStreetNumber",
    "privateStreetName"
})
public class SubAddress {

    protected String id;
    protected String href;
    protected String type;
    protected String name;
    protected String subUnitType;
    protected String subUnitNumber;
    protected String levelType;
    protected String levelNumber;
    protected String buildingName;
    protected String privateStreetNumber;
    protected String privateStreetName;

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
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété subUnitType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubUnitType() {
        return subUnitType;
    }

    /**
     * Définit la valeur de la propriété subUnitType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubUnitType(String value) {
        this.subUnitType = value;
    }

    /**
     * Obtient la valeur de la propriété subUnitNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubUnitNumber() {
        return subUnitNumber;
    }

    /**
     * Définit la valeur de la propriété subUnitNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubUnitNumber(String value) {
        this.subUnitNumber = value;
    }

    /**
     * Obtient la valeur de la propriété levelType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelType() {
        return levelType;
    }

    /**
     * Définit la valeur de la propriété levelType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelType(String value) {
        this.levelType = value;
    }

    /**
     * Obtient la valeur de la propriété levelNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelNumber() {
        return levelNumber;
    }

    /**
     * Définit la valeur de la propriété levelNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelNumber(String value) {
        this.levelNumber = value;
    }

    /**
     * Obtient la valeur de la propriété buildingName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Définit la valeur de la propriété buildingName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildingName(String value) {
        this.buildingName = value;
    }

    /**
     * Obtient la valeur de la propriété privateStreetNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivateStreetNumber() {
        return privateStreetNumber;
    }

    /**
     * Définit la valeur de la propriété privateStreetNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivateStreetNumber(String value) {
        this.privateStreetNumber = value;
    }

    /**
     * Obtient la valeur de la propriété privateStreetName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivateStreetName() {
        return privateStreetName;
    }

    /**
     * Définit la valeur de la propriété privateStreetName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivateStreetName(String value) {
        this.privateStreetName = value;
    }

}
