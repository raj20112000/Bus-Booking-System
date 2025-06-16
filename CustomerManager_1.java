import java.util.Stack;

class Customer_1 {
    private String name;
    private String mobileNumber;
    private String email;
    private String city;
    private int age;

    public Customer_1(String name, String mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Mobile Number: " + mobileNumber + ", Email: " + email + ", City: " + city
                + ", Age: " + age;
    }
}

class CustomerManager_1 {
    private static final int MAX_SIZE = 100;
    private Stack<Customer_1> customerStack = new Stack<>();

    public void registerCustomer(String name, String mobileNumber, String email, String city, int age) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot add more customers.");
            return;
        }

        Customer_1 customer = new Customer_1(name, mobileNumber, email, city, age);
        customerStack.push(customer);
        System.out.println("Customer_1 registered successfully!");
    }

    public void viewLatestCustomer() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No customer to view.");
        } else {
            System.out.println("Latest Registered Customer Details:");
            System.out.println(customerStack.peek());
        }
    }


    public Customer_1 popLatestCustomer() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No customer to pop.");
            return null;
        } else {
            System.out.println("Popped Customer Details:");
            return customerStack.pop();
        }
    }

    public Customer_1 peekLatestCustomer() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No customer to peek.");
            return null;
        } else {
            System.out.println("Latest Registered Customer Details:");
            return customerStack.peek();
        }
    }

    public boolean isFull() {
        return customerStack.size() == MAX_SIZE;
    }

    public boolean isEmpty() {
        return customerStack.isEmpty();
    }

    public void displayCustomers() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No customers to display.");
        } else {
            System.out.println("Customer_1s Details (Latest to Oldest):");
            for (Customer_1 customer : customerStack) {
                System.out.println(customer);
            }
        }
    }

}

