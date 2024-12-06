//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.12.06 a las 04:14:21 PM CST 
//


package pokemon.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para abilitie complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="abilitie"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="abilitie" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abilitie", propOrder = {
    "abilitie"
})
public class Abilitie {

    @XmlElement(required = true)
    protected String abilitie;

    /**
     * Obtiene el valor de la propiedad abilitie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbilitie() {
        return abilitie;
    }

    /**
     * Define el valor de la propiedad abilitie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbilitie(String value) {
        this.abilitie = value;
    }

}
