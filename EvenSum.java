import java.util.Scanner;

public class EvenSum {

    int Sum;
    
    void ES(int Num){
        int x = 0;
        do{
            if (x%2 == 0)   
            {
                System.out.println(x);
                Sum += x ; 
            } 
            x++;

        }while(x <= Num);
        System.out.println("The Sum is : " + Sum);


    }


        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        EvenSum G1 = new EvenSum();

        G1.ES(Num);

        sc.close();

}
    
}
