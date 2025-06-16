class Rectangle{

    int length;
    int width;
    int area;

    Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }
    public int RA(){
       area = length * width;
        //System.out.println(area);
        return area;

    }

    public static void main(String args[]){
        Rectangle E1 = new Rectangle(15,5);

        int Area = E1.RA();
        System.out .println(Area);

    }
}