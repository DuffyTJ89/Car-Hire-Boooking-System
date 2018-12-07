package ie.gmit.sw.RMIdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ie.gmit.sw.Model.Booking;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Vehicle;

import java.sql.SQLException;

import java.rmi.*;
import java.rmi.server.*;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingService { // connection to database
	private static final long serialVersionUID = 1L;
	DataSource mysqlDS;
	Statement stmt;

	protected BookingServiceImpl() throws RemoteException, SQLException {
		super();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhireservice?useSSL=false", "root",
				"DisSys18");

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

	@Override
	public List<Booking> readBookings() throws RemoteException {
		System.out.println("Bookings : /n");
		String strSelect = "SELECT * FROM booking";
		ResultSet rset = null;
//		ArrayList<ResultSet> rsSerialized = new ArrayList<ResultSet>();
		Booking booking = new Booking();
		List<Booking> bookings = new ArrayList<>();

		try {
			rset = stmt.executeQuery(strSelect); // get the result set

//		} catch (SQLException e) {
//			System.out.println("error with SQL resultset");
//		}
//
//		try {
			while (rset.next()) { // loop while there is another record
				System.out.println("looping resultset");
				Vehicle tempVehicle = new Vehicle();
				tempVehicle.setId(rset.getInt("vehicle"));
//				
//				make a db query for that vehicle
//				populate the vehicle data 
				
				
				Customer tempCustomer = new Customer();
				tempCustomer.setCustomerId(rset.getInt("customer"));
//				query db for customer
//				populate customer fields
				// select all where = cusID
				
				
				booking.setBookingId(rset.getInt("id"));
				booking.setStartDate(rset.getString("startDate"));
				booking.setEndDate(rset.getString("endDate"));

				booking.setCustomer(tempCustomer);
				booking.setVehicle(tempVehicle);

				bookings.add(booking);
				
//				bookings.forEach(System.out::println);
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
