import java.util.Scanner;

class Details {

    void Questions(String name, int age, String school, String date, double weight) {
        System.out.println("Enter Your Name: " + name);
        System.out.println("Enter Your Age: " + age);
        System.out.println("Enter Your School: " + school);
        System.out.println("Enter D.O.B: " + date);
        System.out.println("Enter Your Weight: " + weight);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name:");
        String name = sc.nextLine();

        System.out.println("Enter Your Age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Your School:");
        String school = sc.nextLine();

        System.out.println("Enter D.O.B:");
        String date = sc.nextLine();

        System.out.println("Enter Your Weight:");
        double weight = sc.nextDouble();

        Details D1 = new Details();

        D1.Questions(name, age, school, date, weight);

        sc.close();
    }
}
