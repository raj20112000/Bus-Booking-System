import java.io.*;
import java.util.Scanner;

public class BusRegistration {
    static final String FILENAME = "bus_data.txt";

    class Bus {
        String busNumber;
        int totalSeats;
        String startingPoint;
        String endingPoint;
        String startingTime;
        double fare;
        Bus next;

        public Bus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime, double fare) {
            this.busNumber = busNumber;
            this.totalSeats = totalSeats;
            this.startingPoint = startingPoint;
            this.endingPoint = endingPoint;
            this.startingTime = startingTime;
            this.fare = fare;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Bus Number: " + busNumber +
                    ", Total Seats: " + totalSeats +
                    ", Starting Point: " + startingPoint +
                    ", Ending Point: " + endingPoint +
                    ", Starting Time: " + startingTime +
                    ", Fare: " + fare;
        }
    }

    class Queue {
        Bus front, rear;

        public Queue() {
            this.front = this.rear = null;
        }

        void enqueue(Bus bus) {
            if (rear == null) {
                front = rear = bus;
            } else {
                rear.next = bus;
                rear = bus;
            }
            System.out.println("Bus " + bus.busNumber + " registered successfully.");
        }

        void dequeue(String busNumber) {
            if (front == null) {
                System.out.println("No buses registered yet.");
                return;
            }

            Bus current = front;
            Bus previous = null;

            while (current != null) {
                if (current.busNumber.equals(busNumber)) {
                    if (current == front) {
                        front = front.next;
                        if (front == null) {
                            rear = null;
                        }
                    } else {
                        previous.next = current.next;
                        if (current == rear) {
                            rear = previous;
                        }
                    }
                    System.out.println("Bus " + busNumber + " removed from registration.");
                    return;
                }
                previous = current;
                current = current.next;
            }

            System.out.println("Bus " + busNumber + " not found in registration.");
        }

        void saveToFile() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
                Bus current = front;
                while (current != null) {
                    writer.println(current.busNumber);
                    writer.println(current.totalSeats);
                    writer.println(current.startingPoint);
                    writer.println(current.endingPoint);
                    writer.println(current.startingTime);
                    writer.println(current.fare);
                    current = current.next;
                }
                System.out.println("Bus data saved to file: " + FILENAME);
            } catch (IOException e) {
                System.out.println("Error saving bus data to file: " + e.getMessage());
            }
        }

        void loadFromFile() {
            try (Scanner scanner = new Scanner(new FileReader(FILENAME))) {
                while (scanner.hasNextLine()) {
                    String busNumber = scanner.nextLine();
                    int totalSeats = Integer.parseInt(scanner.nextLine());
                    String startingPoint = scanner.nextLine();
                    String endingPoint = scanner.nextLine();
                    String startingTime = scanner.nextLine();
                    double fare = Double.parseDouble(scanner.nextLine());
                    Bus newBus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
                    enqueue(newBus);
                }
                System.out.println("Bus data loaded from file: " + FILENAME);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + FILENAME);
            }
        }

        void searchByBusNumber(String busNumber) {
            Bus current = front;
            boolean found = false;

            while (current != null) {
                if (current.busNumber.equals(busNumber)) {
                    found = true;
                    System.out.println("Bus found: " + current);
                    break;
                }
                current = current.next;
            }

            if (!found) {
                System.out.println("Bus with number " + busNumber + " not found.");
            }
        }

        void viewSavedDetails() {
            Bus current = front;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusRegistration busRegistration = new BusRegistration();
        BusRegistration.Queue busQueue = busRegistration.new Queue();

        busQueue.loadFromFile();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Register a bus");
            System.out.println("2. Remove a registered bus");
            System.out.println("3. Save data to file");
            System.out.println("4. Search the bus by bus number");
            System.out.println("5. View saved details");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter Bus Number:");
                    String busNumber = scanner.nextLine();
                    System.out.println("Enter Total Seats:");
                    int totalSeats = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter Starting Point:");
                    String startingPoint = scanner.nextLine();
                    System.out.println("Enter Ending Point:");
                    String endingPoint = scanner.nextLine();
                    System.out.println("Enter Starting Time:");
                    String startingTime = scanner.nextLine();
                    System.out.println("Enter Fare:");
                    double fare = scanner.nextDouble();
                    scanner.nextLine(); 
                    BusRegistration.Bus newBus = busRegistration.new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
                    busQueue.enqueue(newBus);
                    break;
                case 2:
                    System.out.println("Enter Bus Number to remove:");
                    String busNumToRemove = scanner.nextLine();
                    busQueue.dequeue(busNumToRemove);
                    break;
                case 3:
                    busQueue.saveToFile();
                    break;
                case 4:
                    System.out.println("Enter Bus Number to search:");
                    String busNumToSearch = scanner.nextLine();
                    busQueue.searchByBusNumber(busNumToSearch);
                    break;
                case 5:
                    busQueue.viewSavedDetails();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
