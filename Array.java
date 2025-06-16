class Array {

    public static void main(String args[]){ 
    int arr[] = {10,20,30,40};
    int sum = 0;

    for(int x = 0; x<=(arr.length-1);x++){
        System.out.println(arr[x]);
        sum = sum + arr[x];
    }
    System.out.println("The Sum is : " + sum);
    }
}
