import java.util.Scanner;

class Checkage {

    void CAP(int age){
        if (age <=18){
            System.out.println("User is 18 or Younger");
        }
        else
            System.out.println("User is Older than 18");
               
        }

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
    
            System.out.println("Enter Your Age:");
            int age = sc.nextInt();

            Checkage A1 = new Checkage();

            A1.CAP(age);
    
            sc.close();

    }
    
}
