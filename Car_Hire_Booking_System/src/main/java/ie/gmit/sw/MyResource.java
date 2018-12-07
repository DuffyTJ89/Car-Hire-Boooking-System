package ie.gmit.sw;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Controller.BookingController;
import ie.gmit.sw.Marshalling.BookingMarshal;
import ie.gmit.sw.Model.Booking;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("bookings")
public class MyResource extends BookingMarshal {
	BookingController controller = new BookingController();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getAll() {
		System.out.println("in get all");
		List<Booking> list = controller.getAllBookings();
		
		System.out.println(list);

		return list;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response getById(@PathParam("value") String value) {
//		Booking booking = new Booking();
//		Customer customer = new Customer();
//		Vehicle vehicle = new Vehicle();
		int id = Integer.parseInt(value);
		Booking returnedBooking = controller.getBookingById(id);
		if (returnedBooking != null) {
//			System.out.println(returnedBooking.toString());
//			
//			booking.setBookingId(returnedBooking.getBookingId());
//			customer.setCustomerId(returnedBooking.getCustomer().getCustomerId());
//			vehicle.setId(returnedBooking.getVehicle().getId());
//			booking.setCustomer(customer);
//			booking.setVehicle(vehicle);
//			booking.setStartDate(returnedBooking.getStartDate());
//			booking.setEndDate(returnedBooking.getEndDate());
//			booking.setBookingNumber(null);
//
//			String msg = getBookingAsXML(booking);

//			System.out.println(msg);

			return Response.status(200).entity(returnedBooking).build();
		} else {
			return Response.status(404).entity("Resource does not exist").build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
//	public Response create(String input) {
	public Response create(Booking input) {
		System.out.println(input);

//		Booking booking = getBookingFromXML(input);
//		ReturnedBooking returnedBooking = new ReturnedBooking();
//		Customer customer = booking.getCustomer();
//		Vehicle vehicle = booking.getVehicle();
//
//		returnedBooking.setBookingId(booking.getBookingId());
//		returnedBooking.setCustomerId(customer.getCustomerId());
//		returnedBooking.setVehicleId(vehicle.getId());
//		returnedBooking.setEndDate(booking.getEndDate());
//		returnedBooking.setStartDate(booking.getStartDate());

		controller.createBooking(input);

		return Response.ok().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
//	@Path("{id}")
//	public Response update(@PathParam("id") final String id, String input) {
	public Response update(Booking input) {
//		Booking booking = getBookingFromXML(input);
//		Customer customer = booking.getCustomer();
//		Vehicle vehicle = booking.getVehicle();
//		int value = Integer.parseInt(id);
//		ReturnedBooking returnedBooking = controller.getBookingById(value); 
//																			
//		returnedBooking.setBookingId(booking.getBookingId());
//		returnedBooking.setCustomerId(customer.getCustomerId());
//		returnedBooking.setVehicleId(vehicle.getId());
//		returnedBooking.setStartDate(booking.getStartDate());
//		returnedBooking.setEndDate(booking.getEndDate());

//		controller.updateBooking(returnedBooking);
		controller.updateBooking(input);

		return Response.ok().build();

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Path("{id}")
	public Response delete(@PathParam("id") final String id) {

		int value = Integer.parseInt(id);

//		ReturnedBooking returnedBooking = controller.getBookingById(value);

//		if (returnedBooking != null) {
			controller.deleteBooking(value);
//		}

		return Response.ok().build();
	}
}
