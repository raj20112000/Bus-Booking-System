import java.util.Scanner;
// Use Logical Operators instead of 
class MN{
    void CG(float Num1,float Num2,float Num3){

        if (Num1 < Num2){
        }
        if (Num1 <Num3){
            System.out.println("The Minimum Num is :" + Num1);
        }
        else if (Num2 < Num3){
            System.out.println("The Minimum Num is :" + Num2);
        }
        else{
            System.out.println("The Minimum Num is :" + Num3);
        }
                       
        }
//
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num 1:");
        float Num1 = sc.nextFloat();

        System.out.print("Enter the Num 2:");
        float Num2 = sc.nextFloat();

        System.out.print("Enter the Num 3:");
        float Num3 = sc.nextFloat();



        MN G1 = new MN();

        G1.CG(Num1,Num2,Num3);

        sc.close();

}


    }

