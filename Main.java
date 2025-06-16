import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager_1 customerManager = new CustomerManager_1();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Register Customer Details");
            System.out.println("2. View Latest Registered Customer Details");
            System.out.println("3. Display Customers Details (Latest to Oldest)");
            System.out.println("4. Pop Latest Registered Customer Details");
            System.out.println("5. Peek Latest Registered Customer Details");
            System.out.println("6. Check if Stack is Empty");
            System.out.println("7. Check if Stack is Full");
            System.out.println("8. Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (!customerManager.isFull()) {
                        System.out.println("Enter Customer Name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter Mobile Number:");
                        String mobileNumber = scanner.nextLine();
                        System.out.println("Enter Email ID:");
                        String email = scanner.nextLine();
                        System.out.println("Enter City:");
                        String city = scanner.nextLine();
                        System.out.println("Enter Age:");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        customerManager.registerCustomer(name, mobileNumber, email, city, age);
                    }
                    break;
                case 2:
                    customerManager.viewLatestCustomer();
                    break;
                case 3:
                    customerManager.displayCustomers();
                    break;
                case 4:
                    customerManager.popLatestCustomer();
                    break;
                case 5:
                    customerManager.peekLatestCustomer();
                    break;
                case 6:
                    System.out.println("Stack is empty: " + customerManager.isEmpty());
                    break;
                case 7:
                    System.out.println("Stack is full: " + customerManager.isFull());
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
        scanner.close();
    }
}
