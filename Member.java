class Member {
    String Name;
    int Age;
    int PhoneNumber;
    String Address;
    Double Salary;
    
    Member(String Name, int Age,int PhoneNumber,String Address,Double Salary){
        this.Name = Name;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Salary = Salary;
    }

    void printdetails(){
        System.out.println("The Name is : " + Name + "\n" + "The Age is : " + Age + "\n" +"The Phone Number is : " + PhoneNumber +  "\n" + "The Address is : " + Address +  "\n" + "The Salary is : " + Salary + "\n");
    }

    public static void main(String args[]){

    }
}

