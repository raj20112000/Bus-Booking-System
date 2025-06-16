public class Array4 {
    public static void main(String args[]){
        int num [][] = {{10,20,30,40},{50,60,70,80},{90,100,110,120},{130,140,150,160}};
        for(int i=0; i<=3; i++){
            for(int x=0; x<=3; x++){
                System.out.print(num[i][x]+" ");
            }
            System.out.println();
        }
    }

}
