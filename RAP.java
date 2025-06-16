class RAP {
    int length = 10;
    int width  = 5;

      public int RA(){
        int area = length * width;
        System.out.println(area);
        return area;

    }

      public int RP(){
        int perimeter = 2 * (length + width);
        System.out.println(perimeter);
        return perimeter;

    }

    public static void main (String args[]){
      RAP R1 = new RAP();

      R1.RA();
      R1.RP();
    }

}