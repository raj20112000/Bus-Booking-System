class Square{
    public void SQ(int num){
        int square = num *num;
        System.out .println(square);
        //return square;
    }

    public static void main (String args[]){
        Square N1 = new Square(); 
        Square N2 = new Square();
        
        N1.SQ(25);
        N2.SQ(4);
    }
}