import java.util.Scanner;

class Grade {

    void CG(int testscore){
        if (testscore >= 90){
            System.out.println("Grade is A");
        }
        else if (testscore >= 80){
            System.out.println("Grade is B");
        }
        else if (testscore >= 70){
            System.out.println("Grade is C");
        }
        else if (testscore >= 60){
            System.out.println("Grade is D");
        }
        else{
            System.out.println("Grade is F");
        }
                       
        }

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
    
            System.out.println("Enter Your Testscore:");
            int testscore = sc.nextInt();

            Grade G1 = new Grade();

            G1.CG(testscore);
    
            sc.close();

    }
    
}
