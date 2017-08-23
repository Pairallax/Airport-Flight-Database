import java.util.*;

public class Airplane {
    private String ID;
    private int capacity;
    private ArrayList<Flight> flights;

    public Airplane(String ID, int capacity){
        this.ID = ID;
        this.capacity = capacity;
        this.flights = new ArrayList<Flight>();
    }

    public String toString(){
        return this.ID + " (" + this.capacity + ")";
    }

    public String ID(){
        return this.ID;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public ArrayList<Flight> returnFlights(){
        return this.flights;
    }
}