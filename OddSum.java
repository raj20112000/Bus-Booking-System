import java.util.Scanner;

class OddSum {
    int Sum;

    void OS(int Num){
        for(int x=1; x<=Num; x++) {
            if (x%2!=0)   
            {  
            System.out.println(x + " "); 
            Sum = Num + x; 
            } 
          }
          System.out.println("The Sum is : " + Sum);

        }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        OddSum G1 = new OddSum();

        G1.OS(Num);

        sc.close();

}

    
}
