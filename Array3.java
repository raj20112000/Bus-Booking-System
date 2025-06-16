class Array3 {
    public static void main(String args[]){
        double flo [] = {1.5,4.9,2.4,7.8};
        
        double max = flo[0];
        for(int i = 1; i<= (flo.length-1); i++){
            if (flo[i] > max)
                max = flo[i];
            
        }
        System.out.println("Maximum is : " + max);

    }
}
