package ie.gmit.sw.Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.RMIdata.BookingService;
import ie.gmit.sw.RMIdata.ReturnedBooking;
import ie.gmit.sw.Model.Booking;

public class BookingController {
	BookingService bookingService;

	public BookingController() { //get a handle on the remote object
		
		try {
			this.bookingService = (BookingService) Naming.lookup("rmi://127.0.0.1:1099/bookingService");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	public String getAllBookings() {
		ResultSet rs = null;
		List<ReturnedBooking> bookings = new ArrayList<ReturnedBooking>();
		ReturnedBooking resultBooking;
		String startDate = null;
		String resultObject = null;

		try {
			bookings = bookingService.readBookings();
			System.out.println("--- /n");
		} catch (RemoteException e) {

			System.out.println("error with getAllBookings BookingController");
			e.printStackTrace();
		}

		System.out.println(bookings.size());
		resultBooking = bookings.get(0);

		System.out.println("resultBooking : " + resultBooking.getBookingId());
		return resultBooking.toString();
	}

	public ReturnedBooking getBookingById(int id) {
		List<ReturnedBooking> bookings = new ArrayList<ReturnedBooking>();
		ReturnedBooking resultBooking = null;

		try {
			bookings = bookingService.readBookings();
		} catch (RemoteException e) {
			System.out.println("error  with getBookingById");
			e.printStackTrace();
		}

		for (ReturnedBooking b : bookings) {
			if (b.getBookingId() == id) {
				resultBooking = b;
			}

		}

		if (resultBooking != null) {
			return resultBooking;
		} else {
			return null;
		}

	}

	public void createBooking(ReturnedBooking booking) { // create a new booking
		String query = "Insert INTO bookings VALUES(" + booking.getBookingId() + "," + booking.getVehicleId() + ","
				+ booking.getCustomerId() + ",\"" + booking.getStartDate() + "\",\"" + booking.getEndDate() + "\");";

		try {
			bookingService.createBooking(query);
		} catch (RemoteException e) {
			System.out.println("error on sql query in booking controller");
			e.printStackTrace();
		}
	}

	public void updateBooking(ReturnedBooking booking) { //update the booking details

		String query = "UPDATE bookings SET vehicle_id =" + booking.getVehicleId() + ", " + "customer_id ="
				+ booking.getCustomerId() + ", " + "start_date =\"" + booking.getStartDate() + "\", " + "end_date =\""
				+ booking.getEndDate() + "\" WHERE booking_id=" + booking.getBookingId() + ";";

		try {
			bookingService.updateBooking(query);
		} catch (RemoteException e) {
			System.out.println("error while updating booking in BookingController");
			e.printStackTrace();
		}

	}

	public void deleteBooking(int id) {// delete the booking
		String query = "DELETE FROM bookings WHERE booking_id =" + id + ";";

		try {
			bookingService.deleteBooking(query);
		} catch (RemoteException e) {
			System.out.println("error while deleting booking in BookingController");
			e.printStackTrace();
		}

	}

}
