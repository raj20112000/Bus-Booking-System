import java.io.*;
import java.util.Scanner;
import java.util.Date;

class Customer {
    String name;
    String mobileNumber;
    String email;
    String city;
    int age;

    public Customer(String name, String mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Mobile Number: " + mobileNumber +
                ", Email: " + email +
                ", City: " + city +
                ", Age: " + age;
    }
}

class Bus {
    String busNumber;
    String startingPoint;
    String endingPoint;
    String startingTime;
    double fare;
    int totalSeats;
    int availableSeats;

    public Bus(String busNumber, String startingPoint, String endingPoint, String startingTime, double fare, int totalSeats) {
        this.busNumber = busNumber;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Bus Number: " + busNumber +
                ", Starting Point: " + startingPoint +
                ", Ending Point: " + endingPoint +
                ", Starting Time: " + startingTime +
                ", Fare: " + fare +
                ", Total Seats: " + totalSeats +
                ", Available Seats: " + availableSeats;
    }
}

class Queue {
    Bus[] buses;
    Customer[] customers;
    int busCount;
    int customerCount;


    public Queue(int capacity) {
        buses = new Bus[capacity];
        customers = new Customer[capacity];
        busCount = 0;
        customerCount = 0;
    }

    void registerBus(Bus bus) {
        buses[busCount++] = bus;
    }

    void registerCustomer(Customer customer) {
        customers[customerCount++] = customer;
    }

    void searchBusesByStartingPoint(String startingPoint) {
        System.out.println("Buses starting from " + startingPoint + ":");
        boolean found = false;
        for (Bus bus : buses) {
            if (bus != null && bus.startingPoint.equalsIgnoreCase(startingPoint)) {
                System.out.println(bus);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No buses found for starting point " + startingPoint);
        }
    }

    void reserveSeat(String busNumber, String customerName) {
        Bus bus = findBus(busNumber);
        if (bus == null) {
            System.out.println("Bus " + busNumber + " not found.");
            return;
        }

        if (bus.availableSeats == 0) {
            System.out.println("No available seats on bus " + busNumber + ". Adding customer to waiting list.");
            saveToWaitingList(busNumber, customerName); // Save to waiting list if no available seats
            return;
        }
        
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("Customer " + customerName + " not found.");
            return;
        }

        System.out.println("Seat reserved for customer " + customerName + " on bus " + busNumber);
        bus.availableSeats--;

            // Save reservation details to a text file
    saveReservationToFile(customerName, busNumber);
    }

    void cancelReservation(String busNumber, String customerName) {
        Bus bus = findBus(busNumber);
        if (bus == null) {
            System.out.println("Bus " + busNumber + " not found.");
            return;
        }
    
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("Customer " + customerName + " not found.");
            return;
        }
    
        System.out.println("Reservation cancelled for customer " + customerName + " on bus " + busNumber);
        bus.availableSeats++;
    
        // Notify the next customer waiting for the canceled seat
        notifyNextCustomer(busNumber);
    }
    
    private void notifyNextCustomer(String busNumber) {
        // Load waiting list from file and notify the next customer
        String waitingListFileName = "waiting_list.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(waitingListFileName))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String customerName = line.trim();
                System.out.println("Next customer in waiting list notified: " + customerName);
                // Remove the notified customer from the waiting list
                removeFirstThreeLinesFromFile(waitingListFileName);
                // Reserve the canceled seat for the notified customer
                reserveSeat(busNumber, customerName);
            }
        } catch (IOException e) {
            System.out.println("Error reading waiting list from file: " + e.getMessage());
        }
    }

    private void removeFirstThreeLinesFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder content = new StringBuilder();
    
            // Skip the first three lines
            for (int i = 0; i < 3; i++) {
                reader.readLine();
            }
    
            // Read and append the remaining lines
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
    
            // Write back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error removing lines from file: " + e.getMessage());
        }
    }
        
        
    private void saveReservationToFile(String customerName, String busNumber) {
        String reservationFileName = "reservations.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservationFileName, true))) {
            Date date = new Date();
            writer.write("Reservation Date: " + date.toString() + "\n");
            writer.write("Customer Name: " + customerName + "\n");
            writer.write("Bus Number: " + busNumber + "\n");
            writer.write("\n"); // Add a separator between reservations
            System.out.println("Reservation saved to file: " + reservationFileName);
        } catch (IOException e) {
            System.out.println("Error saving reservation to file: " + e.getMessage());
        }
    }

    private void saveToWaitingList(String busNumber, String customerName) {
        String waitingListFileName = "waiting_list.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(waitingListFileName, true))) {
            writer.write("Customer Name: " + customerName + "\n");
            writer.write("Bus Number:" + busNumber + "\n");
            writer.write("\n"); // Add a separator between reservations
            System.out.println("Customer added to waiting list for bus " + busNumber);
        } catch (IOException e) {
            System.out.println("Error saving to waiting list file: " + e.getMessage());
        }
    }

    private Bus findBus(String busNumber) {
        for (Bus bus : buses) {
            if (bus != null && bus.busNumber.equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer != null && customer.name.equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    void displayReservations() {
        String fileName = "reservations.txt";
        System.out.println("Reservations:");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading reservations from file: " + e.getMessage());
        }
    }
}

public class BusReservationSystem {
    public static void main(String[] args) {
        Queue queue = new Queue(10); // Initialize with capacity 10

        // Load customers from file
        loadCustomersFromFile(queue, "customer_data.txt");

        // Load buses from file
        loadBusesFromFile(queue, "bus_data.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Search Buses by Starting Point");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Display Reservations");
            System.out.println("5. Access Bus Registration System");
            System.out.println("6. Access Customer Manager System");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter starting point:");
                    String startingPoint = scanner.nextLine();
                    queue.searchBusesByStartingPoint(startingPoint);
                    break;
                case 2:
                    System.out.println("Enter bus number:");
                    String busNumber = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    queue.reserveSeat(busNumber, customerName);
                    break;
                case 3:
                    System.out.println("Enter bus number:");
                    busNumber = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    customerName = scanner.nextLine();
                    queue.cancelReservation(busNumber, customerName);
                    break;
                case 4:
                    queue.displayReservations();
                    break;
                case 5:
                    executeExternalFile("BusRegistration.java");
                    break;
                case 6:
                    executeExternalFile("CustomerManager.java");
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:                    
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void executeExternalFile(String filename) {
        ProcessBuilder processBuilder = new ProcessBuilder("java", filename);
        try {
            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void loadCustomersFromFile(Queue queue, String filename) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                String mobileNumber = scanner.nextLine().trim();
                String email = scanner.nextLine().trim();
                String city = scanner.nextLine().trim();
                int age = Integer.parseInt(scanner.nextLine().trim());
                queue.registerCustomer(new Customer(name, mobileNumber, email, city, age));
            }
            System.out.println("Customers loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format in file: " + filename);
        }
    }
        
private static void loadBusesFromFile(Queue queue, String filename) {
    try (Scanner scanner = new Scanner(new FileReader(filename))) {
        while (scanner.hasNextLine()) {
            String busNumber = scanner.nextLine().trim();
            int totalSeats = Integer.parseInt(scanner.nextLine().trim());
            String startingPoint = scanner.nextLine().trim();
            String endingPoint = scanner.nextLine().trim();
            String startingTime = scanner.nextLine().trim();
            double fare = Double.parseDouble(scanner.nextLine().trim());

            Bus bus = new Bus(busNumber, startingPoint, endingPoint, startingTime, fare, totalSeats);
            queue.registerBus(bus);
                }
        System.out.println("Buses loaded from file: " + filename);
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
    } catch (NumberFormatException e) {
        System.out.println("Invalid fare or total seats format in file: " + filename);
    }
}
        }
