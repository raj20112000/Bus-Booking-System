public class account_driver_class {

    public static void main(String args[]){

        account_class aa = new account_class();
        aa.setname("Raj");
        aa.setemail("prempirana@gmail.com");
        aa.setbalance(20000);



        System.out.println("Name = " + aa.getname());
        System.out.println("Email = " + aa.getemail());
        System.out.println("Balance = " + aa.getbalance());

    }
    
}
