import java.util.Scanner;

class PriStar {

        void Squ(int Num){
                for(int x = 1; x<=Num; x++){
                     String Str =  "*" ;
                        for(int y = 1; y<= Num; y++){
                                System.out.print(Str);
                        }
                        System.out.println();

                }
        }

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        PriStar P1 = new PriStar();

        P1.Squ(Num);

        sc.close();

}
    
}
