import java.util.Arrays;

public class StringSet {

	public static void main(String[] args) {
		
		StringSet s1 = new StringSet();
		StringSet s2 = new StringSet(13);
		
		System.out.println(s2.capacity());
		System.out.println(s2.size());

		s2.add("Ana");
		s2.add("Lisa");
		s2.add("Racheal");
		s2.add("Alex");
		s2.add("Monty");
		
		System.out.println(s2.size());
		
		s2.printA(1);
		
		StringSet s3 = new StringSet(s2);
		s3.printA(1);
		
		System.out.println(s2.contains("Lisa"));
		s2.remove("Lisa");
		System.out.println(s2.contains("Lisa"));
		s2.printA(1);
		
		System.out.println(s2.capacity());
		System.out.println(s2.size());
		
		//s2.addOrdered("Jack"); //I can't get this to work, sorry!
		// If you have time could you please let me know what is wrong with the addOrdered?
		
		
	}//end main
	
	//variable
	private String[] StringSet;
	private int capacity;
	private int manyItems;
	
	//constructors 
	//no argument
	public StringSet() {//default
		capacity = 2;//what can be held
		StringSet = new String[capacity];//sets the array to 2
		manyItems = 0;//what start with 0 authors
	}//end no argument constructor
	
	/** 
	@precondition
	*   initialCapacity is non-negative.
	* 
	@postcondition
	*   This bag is empty and has the given initial capacity.
	* 
	@author 
	*   Sam Turner
	* 
	*/
	
	//constructor with given capacity
	public StringSet (int _capacity) {//sets to given capacity
		if(_capacity > 1) {//we can only assign if it is a positive
			StringSet = new String[_capacity];//set string size to capacity
		}//end if
		else if(_capacity == 0) {//if we are given zero we set to the default of two
			StringSet = new String[2];//sets array to two
			System.out.println("Zero was given, and replaced witht he default of two.");//inform user
		}//end else if
		else {//if we are given a negative
			_capacity = _capacity * -1;//turns negative into a positive
			System.out.println("The given capacity was a negative number, "
					+ "and was set to the positive of: " + _capacity);//inform user
			StringSet = new String[_capacity];//sets the string to the new positive capacity
		}//end else
	}//end capacity given constructor
	
	/** 
	@precondition
	*   object is not null
	* 
	@postcondition
	*   the object is cloned
	* 
	@author 
	*   Sam Turner
	* 
	*/
	
	//copy, cannot be clone
	public StringSet(Object obj) {
		if(obj != null) {
		StringSet toCopy = (StringSet)obj;
		manyItems = toCopy.manyItems;
		StringSet = new String[manyItems];
			for (int i = 0; i < manyItems; i++) {
				StringSet[i] = toCopy.StringSet[i];
			}//end for
		}//end if
	}//end copy
	
	/** 
	@precondition
	*   n/a
	* 
	@postcondition
	*   size is returned
	* 
	@author 
	*   Sam Turner
	* 
	@return 
	*	returns int that is the size
	*/
	
	public int size() {//returns
		return manyItems;
	}//end size
	
	/** 
	@precondition
	*   n/a
	* 
	@postcondition
	*   capacity is returned
	* 
	@author 
	*   Sam Turner
	* 
	@return 
	*	returns int that is the capacity
	*/
	
	public int capacity() {//returns 
		return StringSet.length;//we can send back the length to know how much space we have
	}//end size
	
	/** 
	@precondition
	*   not null
	* 
	@postcondition
	*   given item is added to array
	* 
	@author 
	*   Sam Turner
	* 
	*/
	
	public void add(String a) {
		if(a == null) {
		System.out.println("Given String is null :(");
		}//end if
		else {
			if(manyItems < capacity) {//if it is less than max and we have room to add
				StringSet[manyItems] = a;//add author
				manyItems ++;//increment
			}//end if
			else {//we increase capacity and then add		
				ensureCapacity((manyItems+1)*2);
				StringSet[manyItems] = a;//add author
				manyItems ++;
//				 String[] StringSetnew	= new String[(manyItems+1)*2];	
//				 System.arraycopy(this, 0, StringSetnew, 0, manyItems);	
//				 StringSet = StringSetnew; //do I need this?
//				 StringSetnew[manyItems] = a;//then we can add it
//				 manyItems ++;//increment so we will know if more are added later
			}//end else
		}//end else
	}//end add
	
	/** 
	@precondition
	*   not null
	* 
	@postcondition
	*   the item is added with the same size or larger array
	* 
	@author 
	*   Sam Turner
	* 
	@return 
	*	returns boolean that is true or false
	*/
	
	public boolean contains(String a) {
		if (a == null) {
			return false;
		}//end if
		else if (a != null) {
			for(int i = 0; i < StringSet.length; i++) {
				if(StringSet[i] == a) {
					return true;
				}//end if
			}//end for
		}//end else if
	return false;
	}//end boolean for contains
	
	/** 
	@precondition
	*   not null
	* 
	@postcondition
	*   boolean is returned that tells if item was added, true if added
	* 
	@author 
	*   Sam Turner
	* 
	@return 
	*	returns boolean
	*/
	
	public boolean remove(String a) {
		if(a == null) {
			return false;
		}//end if
		else if (a != null) {
			for(int i = 0; i < StringSet.length; i++) {
				if(StringSet[i] == a) {
					StringSet[i] = StringSet[manyItems-i];
					manyItems--;
					return true;
				}//end if
			}//end for
		}//end else if
	return false;
	}//end remove boolean
	
	/** 
	@precondition
	*   not null and must be positive above zero
	* 
	@postcondition
	*   array is expanded if needed
	* 
	@author 
	*   Sam Turner
	* 
	*/
	
	private void ensureCapacity(int minimumCapacity) {
		String[] StringSetBigger;
		if (minimumCapacity <= 0) {
			System.out.println("Given int is negative or zero");
		}//end if		
		else if (StringSet.length < minimumCapacity) {
			StringSetBigger = new String[minimumCapacity];
			System.arraycopy(StringSet, 0, StringSetBigger, 0, manyItems);
			StringSet = StringSetBigger;
		}//end else
	}//end ensureCapacity
	
	/** 
	@precondition
	*   not null, values already ordered ascendingly/lowest-highest
	* 
	@postcondition
	*   given item is added, either with larger array or same sized
	* 
	@author 
	*   Sam Turner
	* 
	*/
	
	public void addOrdered(String a) {
		if (a == null) {
			System.out.println("Given string is a null");
		}//end if
		else {
			if(manyItems < capacity) {//if it is less than max and we have room to add
				StringSet[manyItems] = a;//add author
				Arrays.sort(StringSet);//sorts array
				manyItems++;
			}//end if
			else {//we increase capacity and then add				
					ensureCapacity(capacity);
				 	StringSet[manyItems] = a;//add author
					Arrays.sort(StringSet);//i know this is not the way we are supposed to do it, sorry :(!
					manyItems++;
			}//end else
		}//end else
	}//end addOrdered
	
	public void printA(int y) {//for testing
		System.out.println(StringSet[y]);	//just prints whatever position i send it
	}//end printA
	
	
	
}//end class
