import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customerbooking {
    String name;
    long mobileNumber;
    String email;
    String city;
    int age;

    public Customerbooking(String name, long mobileNumber, String email, String city, int age) {
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

    public String getBusNumber() {
        return busNumber;
    }

    public static String generateBusId(String busNumber, String startPoint, String endPoint) {
        return busNumber.substring(0, 2).toUpperCase() + startPoint.substring(0, 2).toUpperCase()
                + endPoint.substring(0, 2).toUpperCase();
    }
}

class TravelCenter {
    LinkedList<Customerbooking> customers;
    LinkedList<Bus> buses;
    Queue<Customerbooking> waitingQueue;
    int nextSeatNumber;

    public TravelCenter() {
        customers = new LinkedList<>();
        buses = new LinkedList<>();
        waitingQueue = new LinkedList<>();
        nextSeatNumber = 1;
    }

    public void registerCustomer(String name, long mobileNumber, String email, String city, int age) {
        Customerbooking customer = new Customerbooking(name, mobileNumber, email, city, age);
        customers.add(customer);
        writeCustomerToFile(customer);
    }

    private void writeCustomerToFile(Customerbooking customer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("customer.txt", true))) {
            writer.println("<=====Customer Details:-=====>\n" +
                    "Full Name: " + customer.name + ";\n" + "Mobile Number: " + customer.mobileNumber + ";\n"
                    + "Customer Email ID: " + customer.email + ";\n" + "Customer Address: " + customer.city
                    + ";\n" + "Customer Age: " + customer.age + "\n____________________________________________");
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
    private void writeBusToFile(Bus bus) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("bus.txt", true))) {
            writer.println("<----------Bus Details---------->\n BusNumber: " + bus.getBusNumber() +
                    "\n Total Seat:" + bus.totalSeats + "\n Start Point:" + bus.startPoint +
                    "\nEnd Point:" + bus.endPoint + "\nStart Time:" + bus.startTime +
                    "\nFare:" + bus.fare + "\n__________________________________________");
        } catch (IOException e) {
            System.out.println("Error writing bus details to file: " + e.getMessage());
        }
    }

    private int getReservedSeats(Bus bus) {
        int reservedSeats = 0;
        for (Customerbooking customer : customers) {
            if (customer.name.equalsIgnoreCase(bus.busNumber)) {
                reservedSeats++;
            }
        }
        return reservedSeats;
    }

    public void reserveSeat(String customerName, String busNumber) {
        Customerbooking customer = findCustomerByName(customerName);
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
        Customerbooking customer = findCustomerByName(customerName);
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

    public void deleteCustomer(String customerName) {
        Customerbooking customer = findCustomerByName(customerName);
        if (customer != null) {
            customers.remove(customer);
            System.out.println("Customer " + customer.name + " deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteBus(String busNumber) {
        Bus bus = findBusByNumber(busNumber);
        if (bus != null) {
            buses.remove(bus);
            System.out.println("Bus " + bus.busNumber + " deleted successfully.");
        } else {
            System.out.println("Bus not found.");
        }
    }

    public void searchReservedSeat(String option, String value) {
        System.out.println("Reserved Seats:");
        switch (option.toLowerCase()) {
            case "date/time":
                // Implement searching by date/time if needed
                break;
            case "customer id":
                for (Customerbooking customer : customers) {
                    if (customer.name.equalsIgnoreCase(value)) {
                        System.out.println("Customer: " + customer.name);
                    }
                }
                break;
            case "customer bus":
                for (Customerbooking customer : customers) {
                    if (customer.name.equalsIgnoreCase(value)) {
                        System.out.println("Customer: " + customer.name);
                    }
                }
                break;
            default:
                System.out.println("Invalid search option.");
        }
    }

    private Customerbooking findCustomerByName(String customerName) {
        for (Customerbooking customer : customers) {
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

    private void notifyCustomer(Customerbooking customer, String message) {
        System.out.println("Notification sent to " + customer.name + ": " + message);
    }

    private void notifyNextCustomer(Bus bus) {
        if (!waitingQueue.isEmpty()) {
            Customerbooking nextCustomer = waitingQueue.poll();
            customers.add(nextCustomer);
            System.out.println("Next customer " + nextCustomer.name + " notified for Bus " + bus.busNumber);
            notifyCustomer(nextCustomer, "You are next in line for Bus " + bus.busNumber);
        }
    }

    public void updateCustomer(String name, long mobileNumber, String email, String city, int age) {
        for (Customerbooking customer : customers) {
            if (customer.name.equalsIgnoreCase(name)) {
                customer.mobileNumber = mobileNumber;
                customer.email = email;
                customer.city = city;
                customer.age = age;
                System.out.println("Customer information updated successfully!");

                // Update the customer record in the file
                updateCustomerInFile(customer);
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    private void updateCustomerInFile(Customerbooking updatedCustomer) {
        try {
            File inputFile = new File("customer.txt");
            File tempFile = new File("tempCustomers.txt");

            try (Scanner scanner = new Scanner(inputFile);
                    PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(updatedCustomer.name)) {
                        writer.println("<=====Customer Details:-=====>\n" +
                                "Full Name: " + updatedCustomer.name + ";\n" + "Mobile Number: "
                                + updatedCustomer.mobileNumber + ";\n"
                                + "Customer Email ID: " + updatedCustomer.email + ";\n" + "Customer Address: "
                                + updatedCustomer.city
                                + ";\n" + "Customer Age: " + updatedCustomer.age
                                + "\n____________________________________________");
                    } else {
                        writer.println(line);
                    }
                }
            }

            // Rename the temporary file to the original file name
            if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
                System.out.println("Error updating customer details in file.");
            }
        } catch (IOException e) {
            System.out.println("Error updating customer details in file: " + e.getMessage());
        }
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

                // Update the bus record in the file
                updateBusInFile(bus);
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    private void updateBusInFile(Bus updatedBus) {
        try {
            File inputFile = new File("bus.txt");
            File tempFile = new File("tempBuses.txt");

            try (Scanner scanner = new Scanner(inputFile);
                    PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(updatedBus.busNumber)) {
                        writer.println(
                                updatedBus.busNumber + ";" + updatedBus.totalSeats + ";" + updatedBus.startPoint + ";" +
                                        updatedBus.endPoint + ";" + updatedBus.startTime + ";" + updatedBus.fare);
                    } else {
                        writer.println(line);
                    }
                }
            }

            // Rename the temporary file to the original file name
            if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
                System.out.println("Error updating bus details in file.");
            }
        } catch (IOException e) {
            System.out.println("Error updating bus details in file: " + e.getMessage());
        }
    }

    public void displayAllReservations() {
        System.out.println("All Reservations:");

        // Display Customer Reservations
        System.out.println("Customer Reservations:");
        try (Scanner customerScanner = new Scanner(new File("customer.txt"))) {
            while (customerScanner.hasNextLine()) {
                String line = customerScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading customer reservations: " + e.getMessage());
        }

        // Display Bus Reservations
        System.out.println("\nBus Reservations:");
        try (Scanner busScanner = new Scanner(new File("bus.txt"))) {
            while (busScanner.hasNextLine()) {
                String line = busScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading bus reservations: " + e.getMessage());
        }
    }

   

    // Method to write customer reservations to Reserveseat.txt
    public void writeReservationsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Reserveseat.txt"))) {
            for (Customerbooking customer : customers) {
                writer.println("<=====Customer Details:-=====>\n" +
                        "Full Name: " + customer.name + ";\n" + "Mobile Number: " + customer.mobileNumber + ";\n"
                        + "Customer Email ID: " + customer.email + ";\n" + "Customer Address: " + customer.city
                        + ";\n" + "Customer Age: " + customer.age + "\n____________________________________________");
            }
        } catch (IOException e) {
            System.out.println("Error writing reservations to file: " + e.getMessage());
        }
    }

    public void loadTicketsFromFile() {
        try (Scanner scanner = new Scanner(new File("bus.txt"))) {
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
            for (Customerbooking customer : customers) {
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
        TravelCenter travelCenter = new TravelCenter();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("");
            System.out.println("***** Bus reservation system *****\n \n1. Register Customer\n2. Register Bus\n3. Update Customer\n4. Update Bus\n5. Search Buses\n6. Reserve Seat\n7. Cancel Reservation\n8. Delete Customer\n9. Delete Bus\n10. Display All Reservations\n11. Search Reserved Seat\n12. Exit");
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
                    travelCenter.registerCustomer(name, mobileNumber, email, city, age);
                    System.out.println("Customer registered successfully!");
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
                    travelCenter.registerBus(busNumber, totalSeats, startPoint, endPoint, startTime, fare);
                    System.out.println("Bus registered successfully!");
                    break;
                case 3:
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
                    travelCenter.updateCustomer(nameToUpdate, mobileNumberToUpdate, emailToUpdate, cityToUpdate,
                            ageToUpdate);
                            System.out.println("Customer information updated successfully!");
                    break;
                case 4:
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
                    travelCenter.updateBus(busNumberToUpdate, totalSeatsToUpdate, startPointUpdate,
                            endPointUpdate,
                            startTimeUpdate, fareToUpdate);
                            System.out.println("Bus information updated successfully!");

                
                    break;
                case 5:
                    System.out.print("Enter starting point to search: ");
                    startPoint = scanner.nextLine();
                    System.out.print("Enter ending point to search: ");
                    endPoint = scanner.nextLine();
                    travelCenter.searchBuses(startPoint, endPoint);
                    System.out.println("Bus search successful!");
                    break;
                   
                case 6:
                    System.out.print("Enter customer name to reserve seat: ");
                    name = scanner.nextLine();
                    System.out.print("Enter bus number to reserve seat: ");
                    busNumber = scanner.nextLine();
                    travelCenter.reserveSeat(name, busNumber);
                    System.out.println("Seat reserved successfully!");
                    break;
                case 7:
                    System.out.print("Enter customer name to cancel reservation: ");
                    name = scanner.nextLine();
                    System.out.print("Enter bus number to cancel reservation: ");
                    busNumber = scanner.nextLine();
                    travelCenter.cancelReservation(name, busNumber);
                    System.out.println("Reservation cancelled successfully!");
                    break;
                case 8:
                    System.out.print("Enter customer name to delete: ");
                    name = scanner.nextLine();
                    travelCenter.deleteCustomer(name);
                    System.out.println("Customer deleted successfully!");
                    break;
                case 9:
                    System.out.print("Enter bus number to delete: ");
                    busNumber = scanner.nextLine();
                    travelCenter.deleteBus(busNumber);
                    System.out.println("Bus deleted successfully!");
                    break;
                case 10:
                    travelCenter.displayAllReservations();
                    break;
                case 11:
                    System.out.print("Enter search option (Date/Time, Customer ID, Customer Bus): ");
                    String option = scanner.nextLine();
                    System.out.print("Enter search value: ");
                    String value = scanner.nextLine();
                    travelCenter.searchReservedSeat(option, value);
                    System.out.println("Search for reserved seat successful!");
                    break;
                case 12:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 12);
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
