import java.util.Scanner;

class SquNum {

        void Squ(int Num){
                for(int x = 1; x<=Num; x++){
                        int Squ = x * x;
                        System.out.println("The Squareroot of " + x + " is : " + Squ);

                }

        }

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        SquNum G1 = new SquNum();

        G1.Squ(Num);

        sc.close();

}
    
}
