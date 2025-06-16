import java.util.Scanner;

interface rectangle {
    void r_area(int r_length, int r_height);
}

interface Triangle {
    void t_area(int t_length, int t_height);
}

class Area implements rectangle, Triangle {
    int area;

    public void r_area(int r_length, int r_height) {
        area = r_length * r_height;
        System.out.println("Area of Rectangle: " + area);
    }

    public void t_area(int t_length, int t_height) {
        area = (t_length * t_height) / 2;
        System.out.println("Area of Triangle: " + area);
    }
}

public class InterfaceDriver {
    public static void main(String[] args) {
        Area areaCalculator = new Area();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Find Area for Rectangle");
            System.out.println("2. Find Area for Triangle");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the length of Rectangle:");
                    int r_length = scanner.nextInt();
                    System.out.println("Enter the height of Rectangle:");
                    int r_height = scanner.nextInt();
                    areaCalculator.r_area(r_length, r_height);
                    break;
                case 2:
                    System.out.println("Enter the length of Triangle:");
                    int t_length = scanner.nextInt();
                    System.out.println("Enter the height of Triangle:");
                    int t_height = scanner.nextInt();
                    areaCalculator.t_area(t_length, t_height);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
