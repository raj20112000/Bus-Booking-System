class SSA{

    public double SS(double mark1,double mark2,double mark3){
        double sum = mark1 + mark2 + mark3;
        System.out.println(sum);
        return sum;
    }

    public double SA(double mark1,double mark2,double mark3){
        double avg = (mark1 + mark2 + mark3) / 3;
        System.out.println(avg);
        return avg;
    }

    public static void main(String args[]){
        SSA S1 = new SSA();
        SSA S2 = new SSA();

        S1.SS(55,66,85);
        S1.SA(55,66,85);
        S2.SS(65,87,98);
        S2.SA(65,87,98);
    }
}