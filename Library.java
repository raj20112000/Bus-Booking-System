class Book
{
	String book_id;
	String name;
	String author;
	int no_of_pages;
	char category;

	Book(String book_id,String name,String author,int no_of_pages)
	{
		this.book_id=book_id;
		this.name=name;
		this.author=author;
		this.no_of_pages=no_of_pages;
		
		
	}

	void assignCategory(char category)
	{
		this.category=category;
	}
	
	void display()
	{
		System.out.println("\nBook ID : "+this.book_id+
				   "\nBook Name : "+ this.name+
				   "\nAuthor : "+this.author+	
				   "\nNumber of pages : "+this.no_of_pages+
				   "\nCategory : "+this.category);
	}

	
	void check_Group()
	{
		if(this.category=='B')
		{
			System.out.println("Biology");
		}

		else if(this.category=='M')
		{
			System.out.println("Mathematics");
		}

		else if(this.category=='C')
		{
			System.out.println("Commerce");
		}

		else if(this.category=='A')
		{
			System.out.println("Arts");
		}

		else 
		{
			System.out.println("Other");
		}
	}
	
	
	void calRent(double price)
	{
		double rent;
		if(price>=2000)
			rent=price*25/100;
		
		else
			rent=price*15/100;
		
		System.out.println("Rent price is "+rent);
		
	}
}


class Library
{
	public static void main(String[] a)

	{

	Book book1=new Book("M12534","The principles Mathematics","Bertand Russel",576);
	
	book1.assignCategory('M');
	book1.display();
	book1.check_Group();
	book1.calRent(2000);
	

	/*book1.book_id="M12534";
	book1.name="The principles Mathematics";
	book1.author="Bertand Russel";
	book1.price=2500;
	book1.no_of_pages=576;
	book1.category='M';
	
	book1.check_Group();
	book1.display();
	

//..................................................................................

	Book book2=new Book();

	book2.book_id="O8934";
	book2.name="Many mansions";
	book2.author="Gina cerminana";
	book2.price=2000;
	book2.no_of_pages=304;
	book2.category='O';
	
	book2.check_Group();
	book2.display();*/
	

	}
}





















