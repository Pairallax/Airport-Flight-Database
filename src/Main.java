import java.util.*;

public class Main {

    public static final String SENTINEL = "x";
    public static final String ADD_PLANE_OPTION = "1";
    public static final String ADD_FLIGHT_OPTION = "2";
    public static final String PRINT_PLANES_OPTION = "1";
    public static final String PRINT_FLIGHTS_OPTION = "2";
    public static final String PRINT_PLANE_INFO_OPTION = "3";

    public static HashMap<Airplane, ArrayList<Flight>> Airport = new HashMap<Airplane, ArrayList<Flight>>();

    public static void main(String[] args) {
        /*
        FOR EASIER TESTING, CHANGE "System.in" PARAMETER TO "input"
        String input = "1\n" + "HA-LOL\n" + "42\n" + "1\n" + "G-OWAC\n" + "101\n" + "2\n" +
                            "HA-LOL\n" + "HEL\n" + "BAL\n" + "2\n" + "G-OWAC\n" + "JFK\n"
                                + "BAL\n" + "2\n" + "HA-LOL\n" + "BAL\n" + "HEL\n" + "x\n" +
                                    "1\n" + "2\n" + "3\n" + "x\n";
        */
        Scanner reader = new Scanner(System.in);

        System.out.println("Airport Panel\n---------------\n");
        initiateAirportPanel(reader);

        System.out.println("Flight Service\n---------------\n");
        initiateFlightService(reader);

    }

    public static void initiateAirportPanel(Scanner reader) {

        do {
            String choice = promptPanelOperation(reader);

            if (choice.equals(ADD_PLANE_OPTION)) {
                addPlane(reader);
            } else if (choice.equals(ADD_FLIGHT_OPTION)) {
                addFlight(reader);
            } else if (choice.equals(SENTINEL)) {
                break;
            }

        } while (true);

    }

    public static String promptPanelOperation(Scanner reader) {

        System.out.println("Choose Operation:\n[1] Add airplane\n[2] Add flight\n[x] Exit");
        String choice = reader.nextLine();

        return choice;
    }

    public static void initiateFlightService(Scanner reader) {

        do {
            String choice = promptServiceOperation(reader);

            if (choice.equals(PRINT_PLANES_OPTION)) {
                printPlanes();
            } else if (choice.equals(PRINT_FLIGHTS_OPTION)) {
                printFlights();
            } else if (choice.equals(PRINT_PLANE_INFO_OPTION)) {
                printPlaneInfo(reader);
            } else if (choice.equals(SENTINEL)) {
                break;
            }

        } while (true);

    }

    public static String promptServiceOperation(Scanner reader) {
        System.out.println("Choose Operation:\n[1] Print planes\n[2] Print flights\n[3] Print plane info\n[x] Quit");
        String choice = reader.nextLine();

        return choice;
    }

    public static void addPlane(Scanner reader) {

        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();

        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());

        Airplane airPlane = new Airplane(ID, capacity);
        ArrayList<Flight> flights = new ArrayList<Flight>();

        Airport.put(airPlane, flights);

    }

    public static void addFlight(Scanner reader) {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();

        if (isAirplaneFound(ID)) {
            Airplane airPlane = giveAirplane(ID);

            System.out.print("Give departure airport code: ");
            String departureCode = reader.nextLine();

            System.out.print("Give destination airport code: ");
            String destinationCode = reader.nextLine();

            Flight flight = new Flight(airPlane, departureCode, destinationCode);
            airPlane.addFlight(flight);

            Airport.put(airPlane, airPlane.returnFlights());
        } else {
            System.out.println("Please enter a valid airplane ID");
            addFlight(reader);
        }

    }

    public static boolean isAirplaneFound(String ID) {
        for (Airplane airPlane : Airport.keySet()) {
            if (airPlane.ID().equals(ID)) {
                return true;
            }
        }

        return false;
    }

    public static Airplane giveAirplane(String ID) {
        for (Airplane airPlane : Airport.keySet()) {
            if (airPlane.ID().equals(ID)) {
                return airPlane;
            }
        }

        return null;
    }

    public static void printPlanes() {
        for (Airplane airPlane : Airport.keySet()) {
            System.out.println(airPlane);
        }

    }

    public static void printFlights() {
        for (ArrayList<Flight> flights : Airport.values()) {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public static void printPlaneInfo(Scanner reader) {

        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();

        if (isAirplaneFound(ID)) {
            Airplane airPlane = giveAirplane(ID);
            System.out.println(airPlane);
        } else {
            System.out.println("Please enter a valid airplane ID");
            printPlaneInfo(reader);
        }

    }
}