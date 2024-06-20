//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.06.18 a las 05:57:35 PM CST
//


package soappokemonschemas;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para heldItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="heldItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="item" type="{http://apipokemon.io/challenges/technical-challenge}apiResource"/&gt;
 *         &lt;element name="versionDetails" type="{http://apipokemon.io/challenges/technical-challenge}heldItemVersion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ability" type="{http://apipokemon.io/challenges/technical-challenge}apiResource"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "heldItem", propOrder = {
    "item",
    "versionDetails",
    "ability"
})
public class HeldItem {

    @XmlElement(required = true)
    protected ApiResource item;
    protected List<HeldItemVersion> versionDetails;
    @XmlElement(required = true)
    protected ApiResource ability;

    /**
     * Obtiene el valor de la propiedad item.
     * 
     * @return
     *     possible object is
     *     {@link ApiResource }
     *     
     */
    public ApiResource getItem() {
        return item;
    }

    /**
     * Define el valor de la propiedad item.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiResource }
     *     
     */
    public void setItem(ApiResource value) {
        this.item = value;
    }

    /**
     * Gets the value of the versionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the versionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HeldItemVersion }
     * 
     * 
     */
    public List<HeldItemVersion> getVersionDetails() {
        if (versionDetails == null) {
            versionDetails = new ArrayList<HeldItemVersion>();
        }
        return this.versionDetails;
    }

    /**
     * Obtiene el valor de la propiedad ability.
     * 
     * @return
     *     possible object is
     *     {@link ApiResource }
     *     
     */
    public ApiResource getAbility() {
        return ability;
    }

    /**
     * Define el valor de la propiedad ability.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiResource }
     *     
     */
    public void setAbility(ApiResource value) {
        this.ability = value;
    }

}
