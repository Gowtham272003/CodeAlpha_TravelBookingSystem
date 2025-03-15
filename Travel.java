import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Flight {
    String airline, departure, destination;
    double price;

    Flight(String airline, String departure, String destination, double price) {
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }

    void display() {
        System.out.println("Flight: " + airline + " | From: " + departure + " | To: " + destination + " | Price: $" + price);
    }
}


class Hotel {
    String name, location;
    double pricePerNight;

    Hotel(String name, String location, double pricePerNight) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    void display() {
        System.out.println("Hotel: " + name + " | Location: " + location + " | Price per night: $" + pricePerNight);
    }
}


class Transport {
    String type, location;
    double pricePerHour;

    Transport(String type, String location, double pricePerHour) {
        this.type = type;
        this.location = location;
        this.pricePerHour = pricePerHour;
    }

    void display() {
        System.out.println("Transport: " + type + " | Location: " + location + " | Price per hour: $" + pricePerHour);
    }
}


class TravelService {
    List<Flight> flights = new ArrayList<>();
    List<Hotel> hotels = new ArrayList<>();
    List<Transport> transports = new ArrayList<>();

    void addFlight(String airline, String departure, String destination, double price) {
        flights.add(new Flight(airline, departure, destination, price));
    }

    void addHotel(String name, String location, double pricePerNight) {
        hotels.add(new Hotel(name, location, pricePerNight));
    }

    void addTransport(String type, String location, double pricePerHour) {
        transports.add(new Transport(type, location, pricePerHour));
    }

    void displayFlights() {
        System.out.println("\nAvailable Flights:");
        for (Flight flight : flights) {
            flight.display();
        }
    }

    void displayHotels() {
        System.out.println("\nAvailable Hotels:");
        for (Hotel hotel : hotels) {
            hotel.display();
        }
    }

    void displayTransports() {
        System.out.println("\nAvailable Transport Services:");
        for (Transport transport : transports) {
            transport.display();
        }
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelService service = new TravelService();


        service.addFlight("Air India", "India", "London", 500);
        service.addFlight("Emirates", "Dallas", "Paris", 650);

        service.addHotel("Taj", "Tirupati", 120);
        service.addHotel("Minerava grand", "Nellore", 180);

        service.addTransport("Car Rental", "London", 30);
        service.addTransport("Taxi", "Dubai", 15);

        while (true) {
            System.out.println("\n1. View Flights\n2. View Hotels\n3. View Transport\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.displayFlights();
                    break;
                case 2:
                    service.displayHotels();
                    break;
                case 3:
                    service.displayTransports();
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Booking System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
