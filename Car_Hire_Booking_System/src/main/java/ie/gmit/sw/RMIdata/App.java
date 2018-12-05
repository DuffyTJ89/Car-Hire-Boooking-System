package ie.gmit.sw.RMIdata;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class App 
{
	public static void main(String[] args) throws Exception 
	{
		
		BookingService bookingService = new BookingServiceImpl();

		LocateRegistry.createRegistry(1099); // Start the RMI registry on port 1099

		Naming.rebind("bookingService", bookingService); // Bind the remote object to registry and give name bookingService

		System.out.println("Server Ready!!"); 
												 
												 
	}
}
