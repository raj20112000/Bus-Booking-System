class Employee{

    String Name;
    int Age;
    double AvgSal;

    Employee(String Name,int Age,double AvgSal){
        this.Name = Name;
        this.Age = Age;
        this.AvgSal = AvgSal;
    }

    public static void main(String args[]){
        Employee E1 = new Employee("Aryan",32,75.5);

        System.out.println(E1.Name + "\n" + E1.Age + "\n" +  E1.AvgSal);
        /*System.out.println(E1.Age);*/
        /*System.out.println(E1.AvgSal);*/


    }

}