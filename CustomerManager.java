import java.io.*;
import java.util.Scanner;

public class CustomerManager {
    static final String FILENAME = "customer_data.txt";

    class Customer {
        String name;
        String mobileNumber;
        String email;
        String city;
        int age;
        Customer next;

        public Customer(String name, String mobileNumber, String email, String city, int age) {
            this.name = name;
            this.mobileNumber = mobileNumber;
            this.email = email;
            this.city = city;
            this.age = age;
            this.next = null;
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

    class Queue {
        Customer front, rear;

        public Queue() {
            this.front = this.rear = null;
        }

        void enqueue(Customer customer) {
            if (rear == null) {
                front = rear = customer;
            } else {
                rear.next = customer;
                rear = customer;
            }
            System.out.println("Customer " + customer.name + " registered successfully.");
        }

        void saveToFile() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
                Customer current = front;
                while (current != null) {
                    writer.println(current.name);
                    writer.println(current.mobileNumber);
                    writer.println(current.email);
                    writer.println(current.city);
                    writer.println(current.age);
                    current = current.next;
                }
                System.out.println("Customer data saved to file: " + FILENAME);
            } catch (IOException e) {
                System.out.println("Error saving customer data to file: " + e.getMessage());
            }
        }

        void loadFromFile() {
            try (Scanner scanner = new Scanner(new FileReader(FILENAME))) {
                while (scanner.hasNextLine()) {
                    String name = scanner.nextLine();
                    String mobileNumber = scanner.nextLine();
                    String email = scanner.nextLine();
                    String city = scanner.nextLine();
                    int age = Integer.parseInt(scanner.nextLine());
                    Customer newCustomer = new Customer(name, mobileNumber, email, city, age);
                    enqueue(newCustomer);
                }
                System.out.println("Customer data loaded from file: " + FILENAME);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + FILENAME);
            }
        }

        void viewRegisteredCustomers() {
            Customer current = front;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }

        void quicksort() {
            if (front == null || front == rear)
                return;

            rear = quicksort(front, rear);
        }

        private Customer quicksort(Customer front, Customer rear) {
            if (front == null || front == rear)
                return front;

            Customer pivotPrev = partition(front, rear);
            if (pivotPrev != front) {
                Customer temp = front;
                while (temp.next != pivotPrev)
                    temp = temp.next;
                temp.next = null;

                front = quicksort(front, temp);

                temp = getTail(front);
                temp.next = pivotPrev;
            }

            pivotPrev.next = quicksort(pivotPrev.next, rear);

            return rear;
        }

        private Customer partition(Customer front, Customer rear) {
            Customer pivot = rear;
            Customer current = front;
            Customer pivotPrev = null;
            while (front != pivot) {
                if (front.age < pivot.age) {
                    if (pivotPrev == null)
                        pivotPrev = current;
                    else
                        pivotPrev = pivotPrev.next;

                    int temp = current.age;
                    current.age = pivotPrev.age;
                    pivotPrev.age = temp;
                }
                current = current.next;
                front = front.next;
            }

            if (pivotPrev == null)
                pivotPrev = current;
            else
                pivotPrev = pivotPrev.next;

            int temp = pivot.age;
            pivot.age = pivotPrev.age;
            pivotPrev.age = temp;

            return pivotPrev;
        }

        private Customer getTail(Customer front) {
            if (front == null || front.next == null)
                return front;

            Customer temp = front;
            while (temp.next != null)
                temp = temp.next;
            return temp;
        }

        void mergesort() {
            if (front == null || front == rear)
                return;

            front = mergesort(front);
            Customer current = front;
            while (current.next != null)
                current = current.next;
            rear = current;
        }

        private Customer mergesort(Customer head) {
            if (head == null || head.next == null)
                return head;

            Customer middle = getMiddle(head);
            Customer nextOfMiddle = middle.next;
            middle.next = null;

            Customer left = mergesort(head);
            Customer right = mergesort(nextOfMiddle);

            return merge(left, right);
        }

        private Customer merge(Customer left, Customer right) {
            Customer result = null;

            if (left == null)
                return right;
            if (right == null)
                return left;

            if (left.age <= right.age) {
                result = left;
                result.next = merge(left.next, right);
            } else {
                result = right;
                result.next = merge(left, right.next);
            }

            return result;
        }

        private Customer getMiddle(Customer head) {
            if (head == null)
                return head;

            Customer slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();
        CustomerManager.Queue customerQueue = customerManager.new Queue();

        customerQueue.loadFromFile();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Register a customer");
            System.out.println("2. Save data to file");
            System.out.println("3. View registered customers");
            System.out.println("4. Sort customers by age (Quicksort)");
            System.out.println("5. Sort customers by age (Mergesort)");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mobileNumber = scanner.nextLine();
                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter City:");
                    String city = scanner.nextLine();
                    System.out.println("Enter Age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    CustomerManager.Customer newCustomer = customerManager.new Customer(name, mobileNumber, email, city, age);
                    customerQueue.enqueue(newCustomer);
                    break;
                case 2:
                    customerQueue.saveToFile();
                    break;
                case 3:
                    customerQueue.viewRegisteredCustomers();
                    break;
                case 4:
                    customerQueue.quicksort();
                    System.out.println("Customers sorted by age using Quicksort:");
                    customerQueue.viewRegisteredCustomers();
                    break;
                case 5:
                    customerQueue.mergesort();
                    System.out.println("Customers sorted by age using Mergesort:");
                    customerQueue.viewRegisteredCustomers();
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
