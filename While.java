class While {

    public static void main(String args[]){
        int x =1;
        int Num = 100;
        int Sum = 0;

        while (x <=Num && Num>=90) {
            System.out.println(Num);
            Num-=1;
            Sum = Sum +Num;
        }
        System.out.println("The Sum is :"  + Sum);
    }
    
}
