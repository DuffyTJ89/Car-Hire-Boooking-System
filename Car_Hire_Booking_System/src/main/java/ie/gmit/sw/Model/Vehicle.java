//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.13 at 05:00:27 PM GMT 
//

package ie.gmit.sw.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle", namespace = "http://sw.gmit.ie/Model/", propOrder = { "id", "type", "year", "colour",
		"engine" })
public class Vehicle {

	@XmlElement(namespace = "http://sw.gmit.ie/Model/")
	protected int id;
	@XmlElement(namespace = "http://sw.gmit.ie/Model/", required = true)
	protected String type;
	@XmlElement(namespace = "http://sw.gmit.ie/Model/", required = true)
	protected String year;
	@XmlElement(namespace = "http://sw.gmit.ie/Model/", required = true)
	protected String colour;
	@XmlElement(namespace = "http://sw.gmit.ie/Model/")
	protected float engine;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		this.id = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String value) {
		this.year = value;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String value) {
		this.colour = value;
	}

	public float getEngine() {
		return engine;
	}

	public void setEngine(float value) {
		this.engine = value;
	}

}
