import java.util.Scanner;

class GN{
    void CG(int Num1,int Num2,int Num3){

        if (Num1 < Num2){
            System.out.println("The Minimum Num is :" + Num1);
        }
        else if (Num2 < Num3){
            System.out.println("The Minimum Num is :" + Num2);
        }
        else if (Num3 < Num1){
            System.out.println("The Minimum Num is :" + Num3);
        }
        else{
            System.out.println("All Numbers are equal");
        }
                       
        }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num 1:");
        int Num1 = sc.nextInt();

        System.out.print("Enter the Num 2:");
        int Num2 = sc.nextInt();

        System.out.print("Enter the Num 3:");
        int Num3 = sc.nextInt();



        GN G1 = new GN();

        G1.CG(Num1,Num2,Num3);

        sc.close();

}


    }

