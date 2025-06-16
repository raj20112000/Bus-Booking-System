import java.util.Scanner;

public class ABCCompany {
String name;
String position;
String Branch;
String section;
 
public ABCCompany(String name, String position) {
    this.name=name;
    this.position=position;

}
public ABCCompany(String name, String position, String Branch) {
    this.name=name;
    this.position=position;
    this.Branch=Branch;
}
public ABCCompany(String name, String position, String Branch,String section ) {
    this.name=name;
    this.position=position;
    this.Branch=Branch;
    this.section=section;
}
public void Disply() {
    System.out.println("Assistent Manager detiles: " +"\n"+ "AM's Name is: "+name+"\n"+"AM's Position is: "+position);
}
    public void Disply2() {
    System.out.println("Branch Manager detiles: " +"\n"+ "BM's Name is: "+name+"\n"+"BM's Position is: "+position+"\n"+"BM's Branch is: "+Branch);
    }
    public void Disply3() {
    System.out.println("General Staff detiles: "  +"\n"+ "GS's Name is:"+name+"\n"+"GS's Position is: "+position+"\n"+ "GS's Branch is:"+Branch+"\n"+ "GS's Section is:"+section);
    }
public static void main(String args[]) {
    String name,position, Branch, section;

    Scanner Sc = new Scanner(System.in);
    System.out.println("-------AM Detils---------");
    System.out.print("Enter AM's Name: ");
    name = Sc.nextLine();
    System.out.print("Enter AM's Position: ");
    position = Sc.nextLine();
    ABCCompany S1=new ABCCompany(name, position);
    S1.Disply();
    System.out.println("--------BM Detils----------");

    System.out.print("Enter BM's Name: ");
    name = Sc.nextLine();
    System.out.print("Enter BM's Position: ");
    position = Sc.nextLine();
    System.out.print("Enter BM's Branch: ");
    Branch = Sc.nextLine();
    ABCCompany S2=new ABCCompany(name, position,Branch);
    S2.Disply2();
    System.out.println("----------GS Detils----------");

    System.out.print("Enter GS's Name: ");
    name = Sc.nextLine();
    System.out.print("Enter GS's Position: ");
    position = Sc.nextLine();
    System.out.print("Enter GS's Branch: ");
    Branch = Sc.nextLine();
    System.out.print("Enter GS's Section: ");
    section = Sc.nextLine();
    ABCCompany S3=new ABCCompany(name, position,Branch,section);
    S3.Disply3();
    Sc.close();
}
}