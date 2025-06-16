import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer3 {
    String name;
    long mobileNumber;
    String email;
    String city;
    int age;

    public Customer3(String name, long mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    public static String generateCustomerId(String name, long mobileNumber) {
        return name.substring(0, 3).toUpperCase() + mobileNumber;
    }
}

class Bus {
    String busNumber;
    int totalSeats;
    String startPoint;
    String endPoint;
    String startTime;
    double fare;

    public Bus(String busNumber, int totalSeats, String startPoint, String endPoint, String startTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.fare = fare;
    }

    public static String generateBusId(String busNumber, String startPoint, String endPoint) {
        return busNumber.substring(0, 2).toUpperCase() + startPoint.substring(0, 2).toUpperCase()
                + endPoint.substring(0, 2).toUpperCase();
    }
}

class ReservationSystem {
    LinkedList<Customer3> customers;
    LinkedList<Bus> buses;
    Queue<Customer3> waitingQueue;
    int nextSeatNumber;

    public ReservationSystem() {
        customers = new LinkedList<>();
        buses = new LinkedList<>();
        waitingQueue = new LinkedList<>();
        nextSeatNumber = 1;
    }

    public void registerCustomer(String name, long mobileNumber, String email, String city, int age) {
        Customer3 customer = new Customer3(name, mobileNumber, email, city, age);
        customers.add(customer);
        writeCustomerToFile(customer);
    }

    private void writeCustomerToFile(Customer3 customer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("customers.txt", true))) {
            writer.println(customer.name + ";" + customer.mobileNumber + ";" + customer.email + ";" + customer.city + ";" + customer.age);
        } catch (IOException e) {
            System.out.println("Error writing customer details to file: " + e.getMessage());
        }
    }
    
    public void registerBus(String busNumber, int totalSeats, String startPoint, String endPoint, String startTime,
    double fare) {
Bus bus = new Bus(busNumber, totalSeats, startPoint, endPoint, startTime, fare); // Create Bus object
buses.add(bus); // Add Bus object to the list of buses
writeBusToFile(bus); // Optionally, you may want to write the bus details to a file
}

    public void searchBuses(String startPoint, String endPoint) {
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            if (bus.startPoint.equalsIgnoreCase(startPoint) && bus.endPoint.equalsIgnoreCase(endPoint)) {
                System.out.println("Bus Number: " + bus.busNumber + ", Starting Time: " + bus.startTime +
                        ", Fare: " + bus.fare + ", Available Seats: " + (bus.totalSeats - getReservedSeats(bus)));
            }
        }
    }

    private int getReservedSeats(Bus bus) {
        int reservedSeats = 0;
        for (Customer3 customer : customers) {
            if (customer.name.equalsIgnoreCase(bus.busNumber)) {
                reservedSeats++;
            }
        }
        return reservedSeats;
    }

    public void reserveSeat(String customerName, String busNumber) {
        Customer3 customer = findCustomerByName(customerName);
        Bus bus = findBusByNumber(busNumber);
        if (customer != null && bus != null) {
            if (bus.totalSeats - getReservedSeats(bus) > 0) {
                customers.add(customer);
                System.out.println("Seat reserved successfully for " + customer.name + " on Bus " + bus.busNumber);
                notifyCustomer(customer, "Your seat has been reserved on Bus " + bus.busNumber);
            } else {
                waitingQueue.add(customer);
                System.out.println("No available seats. Added " + customer.name + " to the waiting queue.");
            }
        } else {
            System.out.println("Customer or Bus not found.");
        }
    }

    public void cancelReservation(String customerName, String busNumber) {
        Customer3 customer = findCustomerByName(customerName);
        Bus bus = findBusByNumber(busNumber);
        if (customer != null && bus != null) {
            customers.remove(customer);
            System.out.println("Reservation cancelled for " + customer.name + " on Bus " + bus.busNumber);
            notifyCustomer(customer, "Your reservation on Bus " + bus.busNumber + " has been cancelled.");
            notifyNextCustomer(bus);
        } else {
            System.out.println("Customer or Bus not found.");
        }
    }

    private Customer3 findCustomerByName(String customerName) {
        for (Customer3 customer : customers) {
            if (customer.name.equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    private Bus findBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.busNumber.equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    private void notifyCustomer(Customer3 customer, String message) {
        System.out.println("Notification sent to " + customer.name + ": " + message);
    }

    private void notifyNextCustomer(Bus bus) {
        if (!waitingQueue.isEmpty()) {
            Customer3 nextCustomer = waitingQueue.poll();
            customers.add(nextCustomer);
            System.out.println("Next customer " + nextCustomer.name + " notified for Bus " + bus.busNumber);
            notifyCustomer(nextCustomer, "You are next in line for Bus " + bus.busNumber);
        }
    }

    public void updateCustomer(String name, long mobileNumber, String email, String city, int age) {
        for (Customer3 customer : customers) {
            if (customer.name.equalsIgnoreCase(name)) {
                customer.mobileNumber = mobileNumber;
                customer.email = email;
                customer.city = city;
                customer.age = age;
                System.out.println("Customer information updated successfully!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    public void updateBus(String busNumber, int totalSeats, String startPoint, String endPoint, String startTime,
            double fare) {
        for (Bus bus : buses) {
            if (bus.busNumber.equalsIgnoreCase(busNumber)) {
                bus.totalSeats = totalSeats;
                bus.startPoint = startPoint;
                bus.endPoint = endPoint;
                bus.startTime = startTime;
                bus.fare = fare;
                System.out.println("Bus information updated successfully!");
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    public void displayAllReservations() {
        System.out.println("All Reservations:");
        for (Customer3 customer : customers) {
            System.out.println("Customer Details");
            System.out.println("Customer: " + customer.name);
            System.out.println("Mobile Number: " + customer.mobileNumber);
            System.out.println("Email: " + customer.email);
            System.out.println("City: " + customer.city);
            System.out.println("Age: " + customer.age);
            System.out.println("------------------");
        }
        for (Bus bus : buses) {
            System.out.println("Bus Reserved details");
            System.out.println("Bus number " + bus.busNumber);
            System.out.println("Total Seats: " + bus.totalSeats);
            System.out.println("Starting point: " + bus.startPoint);
            System.out.println("Ending point: " + bus.endPoint);
            System.out.println("Starting time: " + bus.startTime);
            System.out.println("Fare: " + bus.fare);
            System.out.println("------------------");
        }
    }

    private void writeBusToFile(Bus bus) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("buses.txt", true))) {
            writer.println(bus.busNumber + ";" + bus.totalSeats + ";" + bus.startPoint + ";" + bus.endPoint + ";" + bus.startTime + ";" + bus.fare);
        } catch (IOException e) {
            System.out.println("Error writing bus details to file: " + e.getMessage());
        }
    }
    

    public void loadTicketsFromFile() {
        try (Scanner scanner = new Scanner(new File("tickets.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // Here you can process each line as per your requirement
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void saveTicketsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("tickets.txt"))) {
            for (Customer3 customer : customers) {
                writer.println(customer.name + ";" + customer.mobileNumber + ";" + customer.email + ";" + customer.city
                        + ";" + customer.age);
            }
            for (Bus bus : buses) {
                writer.println(bus.busNumber + ";" + bus.totalSeats + ";" + bus.startPoint + ";" + bus.endPoint + ";"
                        + bus.startTime + ";" + bus.fare);
            }
        } catch (IOException e) {
            System.out.println("Error saving tickets to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(
                    "\n1. Register Customer\n2. Register Bus\n3. Search Buses\n4. Reserve Seat\n5. Cancel Reservation\n6. Display All Reservations\n7. Exit\n8. Update Customer\n9. Update Bus");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter mobile number: ");
                    long mobileNumber = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    reservationSystem.registerCustomer(name, mobileNumber, email, city, age);
                    break;
                case 2:
                    System.out.print("Enter bus number: ");
                    String busNumber = scanner.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter starting point: ");
                    String startPoint = scanner.nextLine();
                    System.out.print("Enter ending point: ");
                    String endPoint = scanner.nextLine();
                    System.out.print("Enter starting time: ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter fare: ");
                    double fare = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    reservationSystem.registerBus(busNumber, totalSeats, startPoint, endPoint, startTime, fare);
                    break;
                case 3:
                    System.out.print("Enter starting point to search: ");
                    startPoint = scanner.nextLine();
                    System.out.print("Enter ending point to search: ");
                    endPoint = scanner.nextLine();
                    reservationSystem.searchBuses(startPoint, endPoint);
                    break;
                case 4:
                    System.out.print("Enter customer name to reserve seat: ");
                    name = scanner.nextLine();
                    System.out.print("Enter bus number to reserve seat: ");
                    busNumber = scanner.nextLine();
                    reservationSystem.reserveSeat(name, busNumber);
                    break;
                case 5:
                    System.out.print("Enter customer name to cancel reservation: ");
                    name = scanner.nextLine();
                    System.out.print("Enter bus number to cancel reservation: ");
                    busNumber = scanner.nextLine();
                    reservationSystem.cancelReservation(name, busNumber);
                    break;
                case 6:
                    reservationSystem.displayAllReservations();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                case 8:
                    System.out.print("Enter customer name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter mobile number: ");
                    long mobileNumberToUpdate = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter email: ");
                    String emailToUpdate = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String cityToUpdate = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int ageToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    reservationSystem.updateCustomer(nameToUpdate, mobileNumberToUpdate, emailToUpdate, cityToUpdate,
                            ageToUpdate);
                    break;
                case 9:
                    System.out.print("Enter bus number to update: ");
                    String busNumberToUpdate = scanner.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeatsToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter starting point: ");
                    String startPointUpdate = scanner.nextLine();
                    System.out.print("Enter ending point: ");
                    String endPointUpdate = scanner.nextLine();
                    System.out.print("Enter starting time: ");
                    String startTimeUpdate = scanner.nextLine();
                    System.out.print("Enter fare: ");
                    double fareToUpdate = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    reservationSystem.updateBus(busNumberToUpdate, totalSeatsToUpdate, startPointUpdate,
                            endPointUpdate,
                            startTimeUpdate, fareToUpdate);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
        scanner.close();
    }
}

class BusTicket {
    private int ticketId;
    private String passengerName;
    private String busNumber;
    private String departureTime;

    public BusTicket(String passengerName, String busNumber, String departureTime, int ticketId) {
        this.passengerName = passengerName;
        this.busNumber = busNumber;
        this.departureTime = departureTime;
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getTicketId() {
        return ticketId;
    }
}