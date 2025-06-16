class SSA1{

    public double SS(double mark1,double mark2,double mark3){
        double sum = mark1 + mark2 + mark3;
        System.out.println(sum);
        return sum;
    }

    public double SA(double sum){
        double avg = (sum) / 3;
        System.out.println(avg);
        return avg;
    }

    public static void main(String args[]){
        SSA1 S1 = new SSA1();
        SSA1 S2 = new SSA1();

        double sum1 = S1.SS(55,66,85);
        S1.SA(sum1);
        double sum2 = S2.SS(65,87,98);
        S2.SA(sum2);
    }
}