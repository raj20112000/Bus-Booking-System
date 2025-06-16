import java.util.Scanner;

class Array6 {
    int num [][] = {{10,20,30,40},{50,60,70,80},{90,100,110,120},{130,140,150,160}};

    void Search(int N1,int N2){
            for(int x=0; x<=3; x++){
            }
            System.out.print(num[N1][N2]+" ");

            System.out.println();
        }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Row :");
        int N1 = sc.nextInt();

        System.out.print("Enter the Column :");
        int N2 = sc.nextInt();


        Array6 G1 = new Array6();

        G1.Search(N1,N2);

        sc.close();

}
}
