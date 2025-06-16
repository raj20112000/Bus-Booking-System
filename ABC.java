import java.util.Scanner;

public class ABC {

    String Name;
    int DOB;
    int ConNo;
    String Position;
    String BranchName;
    int WorHr;
    int YOE;

    public ABC(String Name,int DOB,int ConNo,String Position,int WorHr,int YOE){
        this.Name = Name;
        this.DOB = DOB;
        this.ConNo = ConNo;
        this.Position = Position;
        this.WorHr = WorHr;
        this.YOE = YOE;
    }

    public ABC(String Name,int DOB,int ConNo,String Position,String BranchName,int WorHr,int YOE){
        this.Name = Name;
        this.DOB = DOB;
        this.ConNo = ConNo;
        this.Position = Position;
        this.BranchName =BranchName;
        this.WorHr = WorHr;
        this.YOE = YOE;
    }

    void findgrade(int YOE){
        if(YOE >= 5){
            System.out.println("The grade is 1");
            }
            else if(YOE == 2 && YOE < 5){
                System.out .println("The grade is 2");
            }
            else{
                System.out.println("The grade is 3");
            }
    }

    void calsalary(int WorHr){
        int Salary = WorHr * 500;
        System.out.println("The salary is : " + Salary);

     }
    

    void display1(){
        System.out.println("The name is : " + Name);
        System.out.println("The name is : " + DOB);
        System.out.println("The name is : " + ConNo);
        System.out.println("The name is : " + Position);
        System.out.println("The name is : " + WorHr);
        System.out.println("The name is : " + YOE);

    }

    void display2(){
        System.out.println("The name is : " + Name);
        System.out.println("The name is : " + DOB);
        System.out.println("The name is : " + ConNo);
        System.out.println("The name is : " + Position);
        System.out.println("The name is : " + BranchName);
        System.out.println("The name is : " + WorHr);
        System.out.println("The name is : " + YOE);

    }



    public static void main(String args[]){
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter the Name :");
        String Name = SC.nextLine();

        System.out.print("Enter the DOB :");
        int DOB = SC.nextInt();

        System.out.print("Enter the Contact No :");
        int ConNo = SC.nextInt();
        SC.nextLine();

        System.out.print("Enter the Position :");
        String Position = SC.nextLine();

        System.out.print("Enter the Worked Hours :");
        int WorHr = SC.nextInt();

        System.out.print("Enter the Years of Experience :");
        int YOE= SC.nextInt();

        ABC E1 = new ABC(Name,DOB,ConNo,Position,WorHr,YOE);
        E1.display1();

        System.out.print("Enter the Name :");
        String Name = SC.nextLine();

        System.out.print("Enter the DOB :");
        int DOB = SC.nextInt();

        System.out.print("Enter the Contact No :");
        int ConNo = SC.nextInt();
        SC.nextLine();

        System.out.print("Enter the Position :");
        String Position = SC.nextLine();

        System.out.print("Enter the Branch Name :");
        String BranchName = SC.nextLine();

        System.out.print("Enter the Worked Hours :");
        int WorHr = SC.nextInt();

        System.out.print("Enter the Years of Experience :");
        int YOE= SC.nextInt();

        ABC E2 = new ABC(Name,DOB,ConNo,Position,BranchName,WorHr,YOE);
        E2.display2();
        SC.close();


    }
}
