import java.util.Scanner;

class Calculator_1 {

    void CG(int Num1,int Num2,char AC){

        switch(AC){
            case '+':
            System.out.println(Num1 + Num2);
            break;
            case '-':
            System.out.println(Num1 - Num2);
            break;
            case '*':
            System.out.println(Num1 * Num2);
            break;
            case '/':
            System.out.println(Num1 / Num2);
            break;
            case '%':
            System.out.println(Num1 % Num2);
            break;
            default:
            System.out.println("Invlaid Arithmetic Operator..");

        }

        }

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter the Num1:");
            int Num1 = sc.nextInt();

            System.out.print("Enter the Num2:");
            int Num2 = sc.nextInt();

            System.out.println("Enter the Arithmatic Calculator:");
            char AC = sc.next().charAt(0);

            Calculator_1 G1 = new Calculator_1();

            G1.CG(Num1,Num2,AC);
    
            sc.close();

    }
    
}
