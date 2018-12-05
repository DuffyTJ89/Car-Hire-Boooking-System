package ie.gmit.sw.RMIdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.SQLException;

import java.rmi.*;
import java.rmi.server.*;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingService { // connection to database
	private static final long serialVersionUID = 1L;
	DataSource mysqlDS;
	Statement stmt;

	protected BookingServiceImpl() throws RemoteException, SQLException {
		super();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_Hire_Booking_System?useSSL=false", "root", "");

		stmt = conn.createStatement();
	}

	public void createBooking(String query) throws RemoteException { // override implemented methods
		try {
			stmt.executeUpdate(query); // passes query to database
		} catch (SQLException e) {
			System.out.println("query error, please try again");
			e.printStackTrace();
		}
	}

	public List<ReturnedBooking> readBookings() throws RemoteException {
		System.out.println("Bookings : /n");
		String strSelect = "select * from bookings";
		ResultSet rset = null;
		ArrayList<ResultSet> rsSerialized = new ArrayList<ResultSet>();
		ReturnedBooking booking = new ReturnedBooking();
		List<ReturnedBooking> bookings = new ArrayList<ReturnedBooking>();

		try {
			rset = stmt.executeQuery(strSelect); // get the result set
		} catch (SQLException e) {
			System.out.println("error with SQL resultset");
		}

		try {
			while (rset.next()) { // loop while there is another record
				booking.setBookingId(rset.getInt("booking_id"));
				booking.setVehicleId(rset.getInt("vehicle_id"));
				booking.setCustomerId(rset.getInt("customer_id"));
				booking.setStartDate(rset.getString("start_date"));
				booking.setEndDate(rset.getString("end_date"));

				bookings.add(booking);
			}
		} catch (SQLException e) {

			System.out.println("error when adding to rs");
			e.printStackTrace();
		}

		return bookings;
	}

	public void updateBooking(String query) throws RemoteException { // update the bookings
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBooking(String query) throws RemoteException { // delete a booking
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
