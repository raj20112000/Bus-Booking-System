public class account_class {
    private String name;
    private String email;
    private double balance;

    public void setname(String name){
        this.name = name;
    }

    public void setemail(String email){
        this.email = email;
    }

    public void setbalance(double balance){
        this.balance = balance;
    }

    public String getname(){
        return name;
    }

    public String getemail(){
        return email;
    }

    public double getbalance(){
        return balance;
    }
    
}
