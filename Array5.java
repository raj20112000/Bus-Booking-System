class Array5 {
    public static void main(String args[]){
        int num [][] = {{10,20,30,40},{50,60,70,80},{90,100,110,120},{130,140,150,160}};
        int num1 [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int sum [][] = new int[4][4];

        for(int i=0; i<=3; i++){
            for(int x=0; x<=3; x++){
                sum [i][x] = (num[i][x] + num1[i][x]);
                System.out.print(sum [i][x] + " ");
            }
            System.out.println();
        }
    }

}
