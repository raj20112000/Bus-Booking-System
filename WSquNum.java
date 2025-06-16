import java.util.Scanner;

class WSquNum {

        void Squ(int Num){
            int x = 1;

            while(x<=Num){
                int Squ = x * x;
                System.out.println("The Square of " + x + " is : " + Squ);
                x++;

            }
        }

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        WSquNum G1 = new WSquNum();

        G1.Squ(Num);

        sc.close();

}
    
}
