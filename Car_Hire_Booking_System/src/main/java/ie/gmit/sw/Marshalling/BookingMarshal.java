package ie.gmit.sw.Marshalling;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import ie.gmit.sw.Model.Booking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BookingMarshal {

	public BookingMarshal() {//constructor
	} 

	protected String getBookingAsXML(Booking booking) {// Marshal booking to XML
		StringWriter sw = new StringWriter();
		Marshaller marsh;

		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.Model");
			marsh = jc.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marsh.marshal(booking, sw);
		} catch (JAXBException e) {
			System.out.println("error marshalling booking");
			e.printStackTrace();
		}

		return sw.toString();
	}

	protected Booking getBookingFromXML(String input) { //Unmarshal the Booking from XML
		
		StringReader stringReader = new StringReader(input);
		Unmarshaller unmarshaler;
		Booking bookingFromXml = null;

		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.dsModels");
			unmarshaler = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(stringReader);
			JAXBElement<Booking> bookingElement1 = unmarshaler.unmarshal(source1, Booking.class);
			bookingFromXml = (Booking) bookingElement1.getValue();
		} catch (JAXBException e) {
			System.out.println("Problem unmarshalling booking object");
			e.printStackTrace();
		}

		return bookingFromXml;
	}

}
