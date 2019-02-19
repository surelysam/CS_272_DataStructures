import java.util.Arrays;

//Sam Turner
//CS 272 Lab 03
//Purpose: Create a list and add things to a list, count the list, shift the list, other list based functions

public class IntNode {

	//variables
	private int data;
	private IntNode link;
	
	
	//constructors
	public IntNode() {//default constructor no info provided
		setNodeValue(0);//sets to zero
		setNodeLink(null);//points nowhere
	}//end default constructor
	
	public IntNode(int _data, IntNode _node) {//non default constructor
		setNodeValue(_data);//just using mutators
		setNodeLink(_node);
	}//end non default constructor
	
	//Accessors/get
	//will have returns, no input
	
	public int getNodeValue() {//will return current data
		return data;//calls private variable
	}//end getNodeValue
	
	public IntNode getNodeLink() {//will return nodelink
		return link;//calls private variable
	}//end getNodeLink
	
	
	/** 
	@precondition
	*   object is not null
	* 
	@postcondition
	*   the object is set
	* 
	*/
	
	//Mutators/set
	//void returns
	public void setNodeValue(int _nodeV) {
		data = _nodeV;//sets data
	}//end set node value

	public void setNodeLink(IntNode _link) {
		link = _link;//sets where it's pointing
	}//end set node link
	
	public static int listLength(IntNode head) {//we will return the length of the list
		int answer = 1; //need a way to count
			for(IntNode cursor = head; cursor != null; cursor = cursor.link) {//we start at beginning and continue as long as it is not null, moving to the next one each time
				answer++;//add each time
			}//end for
		return answer;//return once all items have been cycled through
	}//end list length 
	
	public String toString( ) { //allows us to print list of everything in list
		String result = "List: ";//so our string doesn't start empty

		//Code from the very nice TA who helped me
//		for(IntNode cursor=this; cursor!=null; cursor = cursor.getNodeLink()) {
//		 int d = cursor.getNodeValue();
//		 System.out.println(d);
//		 result = result + d;
//		}//end for
		
		//same code with while loop
		IntNode cursor = this;//idk i need somewhere to start
			while(cursor != null) {//as long as it's not null keep adding
				result = result + cursor.getNodeValue() + " ";//add what we are at
				cursor = cursor.link;//go to next data
			}//end while
			
	    return result; //sends back fancy new string of list items
		}//end toString
	
	public void addNodeAfterThis(int newdata) {//we add anew item
		IntNode temp = new IntNode(newdata, null);//take the new item and set it to null
		temp.setNodeLink(getNodeLink());//we have it point at a thing
		this.setNodeLink(temp);//idk know i'm just following my class notes
	}//end addNodeAfterThis
	
	public static boolean search (IntNode head, int data) {
		//IntNode = null;
		IntNode cursor = head;
		while(cursor != null) {
			if(cursor.data == data) {
				return true;//if they do equal return true
			}//end if
			cursor = cursor.link;//if they do not equal we go to the next link
		}//end while
		return false;//if none equal we return false to exit method
	}//end search
	
	/** 
	@precondition
	*   object is not null
	* 
	@postcondition
	*   the object is removed
	* 
	*/
	
	public void removeNodeAfterThis() {
		link = this.link.link;
	}//end removeNodeAfterThis
	

}//end IntNode class