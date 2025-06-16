import java.util.Scanner;

public class Array7 {
    int Nums [] = {10,20,30,40,50,60,70,80};

    void Search(int N1){
        for (int i = 0; i <= (Nums.length-1); i++){
        if(Nums[i] == N1){
            System.out.println("The Number " + N1 + " is Available in the Array in the index of " + i);
            break;
        }
        else {
            System.out.println("The Number isn't Available in the index " + i);
        }
    }


}


        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int N1 = sc.nextInt();

        Array7 G1 = new Array7();

        G1.Search(N1);

        sc.close();

}

    
}
