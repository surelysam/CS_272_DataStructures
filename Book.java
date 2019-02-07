//import java.util.Arrays;

//CS272
//Sam Turner
//28/01/2019
//Create books and change their variables

public class Book {
	
	public static void main(String[] args) {
		Book B1 = new Book();
		B1.setISBN("1234ABCD");
		System.out.println(B1);
      B1.toString();
		
	}
	
//variables
	private String bookTitle; //the books title
	private int numAuth; //number of authors
	private String[] authors;// = new String[3]; name slots for authors leaving this as a note to self how string arrays work
	private String isbn; //books ISBN
	
	//I tend to use constructor calls to set things? I hope that is okay
	//constructors
	public Book ( ) {//default/no argument
		setTitle(null); //sets to null
		setAuthorNumber(0); //sets to zero
		setAuthors(3); //sets string array to three
		setISBN(null); //sets to null
	}//end public book no argue
	
	public Book (String _title) {
		setTitle(_title); //sets to given string
		setAuthorNumber(0); //sets to zero
		setAuthors(3); //sets string array to three
		setISBN(null); //sets to null
	}//end public book title argument
	
	public Book (Object obj) {//I am a copy constructor
		try {
		Book copy = (Book) obj; //we create the copy ability for the class
		bookTitle = copy.bookTitle; //we assign the objects variable to ours
		numAuth = copy.numAuth; 
		authors[0] = copy.authors[0];//you need to do them each individually
		authors[1] = copy.authors[1];
		authors[2] = copy.authors[2];
		isbn = copy.isbn;
		}//end try
		catch(Exception e){//if the try does not work we will move to an error message
			System.out.println(e.getMessage());
			throw new RuntimeException("The object is Null"); //specified message     
		}//end catch
	}//end copy constructor
	
	//mutators set 
	//void returns
	public void setTitle (String _title) {//sets just title with provided string
		bookTitle = _title;
	}//end set title
	
	public void setAuthorNumber (int _nA) {//sets number of authors with provided int
		numAuth = _nA;
	}//end set author num
	
	public void setAuthors (int _sA) {//sets authors string? 
		if (_sA <= 3 || _sA >= 0) { //limited to three
		authors = new String[_sA];//set to given parameter inside range
		}//end if
		else {//if outside of the range it will be set to three
			authors = new String[3];//set to three
		}//end else
	}//end set author
	
	public void setISBN (String _isbn) {//set isbn using given information
		isbn = _isbn;
	}//end set isbn
	
	//accessors get
	//has returns
	public String getTitle ( ) {//we return the title
		return bookTitle;
	}//end get title
	
	public int getAuthorNumber ( ) {//we return the author number
		return numAuth;
	}//end get author num
	
	public String getISBN ( ) {//return isbn
		return isbn;
	}//end get isbn
	
	public static String[] getAllAuthors(Book b1, Book b2) {//to send back all authors from two books, no duplicates
		String[] allAuth = new String [6];
		allAuth[0] = b1.authors[0];//we assign the first array
		allAuth[1] = b1.authors[1];
		allAuth[2] = b1.authors[2];
		
		for (int y = 0; y <= 2; y++) {//we need to check each element in the second array now
			
			//if the element in the second array isn't the same as any that are already there, we add it
			if(b2.authors[y] != allAuth[0] || b2.authors[y] != allAuth[1] ||b2.authors[y] != allAuth[2]) {
				allAuth[y + 3] = b2.authors[y];
			}//exit if
			
		}//exit four

		return allAuth;//return combined statement
	
	}//end get all authors
	
	//other
	public boolean addAuthor (String _author) {
		if (numAuth < 3) {//if it is less than max
			authors[numAuth] = _author;//add author
			numAuth ++;//increment
			return true;//then return true to show it was added
			}	
		return false;//if it is not less than max we return false
	 }
	// 
	
	//equals
	public boolean equals (Object obj) {//to check if two objects are the same
		if (obj instanceof Book) {
			Book temp = (Book) obj;//make it accessible
			return (isbn == temp.isbn);//test for isbn
		}
		return false;
	}
	
	//tostring
	public String toString( ) { //allows us to print everything
	   String result = String.format("%s %s %02d %s", bookTitle, isbn, numAuth, authors);//formatting
	   return result; //sends back fancy new string
	}
	
}//end book class

