class ATN {
	//Attributes of student - variables
	int num1;
	int num2;
	
	//Behaviors- Methods
	public static void main(String args[]){
		//creat objects 
		ATN Sum=new ATN();
		//assign value to st01 object's attributes
		Sum.num1=4;
		Sum.num2=5;

		System.out.print(Sum.num2 + Sum.num1);
	}
}