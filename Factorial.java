import java.util.Scanner;

class Factorial {
    
        void Fac(int Num){
            int Fac =1;
            for(int x = 1; x <= Num; x++) {
                //Fac = x * Fac; 
                Fac *= x;
                System.out.println("The Factorial is : " + Fac);
              }
            }

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        Factorial G1 = new Factorial();

        G1.Fac(Num);

        sc.close();

}
}
