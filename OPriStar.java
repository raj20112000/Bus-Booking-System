import java.util.Scanner;

class OPriStar {

        void Squ(int Num){
            String Str = "";
                for(int x = 1; x<=Num; x++){
                    Str +=  "*" ;
                        System.out.println(Str);

                }

        }

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int Num = sc.nextInt();

        OPriStar P1 = new OPriStar();

        P1.Squ(Num);

        sc.close();

}
    
}
