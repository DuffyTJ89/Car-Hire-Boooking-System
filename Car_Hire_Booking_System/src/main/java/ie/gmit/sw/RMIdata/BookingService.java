package ie.gmit.sw.RMIdata;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Booking;



public interface BookingService  extends Remote{
	
	public void createBooking(String query) throws RemoteException; // to create a booking
	
	public List<Booking> readBookings() throws RemoteException; // to list all the bookings
	
	public void updateBooking(String query) throws RemoteException; // to update an existing booking
	
	public void deleteBooking(String query) throws RemoteException; // to delete an existing booking
	
}
