//Sam Turner
//CS 272 Lab 03
//Purpose: test IntNode 

public class IntNodeTest {

	public static void main(String []args) {
		IntNode L1 = new IntNode();//make new List 
		System.out.println(L1);//print to show it with default constructor
		
		IntNode L2 = new IntNode(23, null);//make new List 
		System.out.println(L2);//print to show it with not constructor
		L2.addNodeAfterThis(12);//test adding more
		L2.addNodeAfterThis(2);
		L2.addNodeAfterThis(3);
		L2.addNodeAfterThis(9);
		System.out.println(L2.getNodeValue());
		System.out.println(L2.getNodeLink());
		L2.addNodeAfterThis(14);
		L2.setNodeLink(null);
		L2.addNodeAfterThis(54);
		System.out.println(L2);//see if they are there
		L2.setNodeValue(9);//try changing it
		System.out.println(L2);//see if they are there
		System.out.println(L2.search(L2, 9));//should return true
		System.out.println(L2.search(L2, 18));//should return false
		
		
		System.out.println(L2);//see if they are there
		L2.removeNodeAfterThis();
		System.out.println(L2);//see if they are there
		
		L2.addNodeAfterThis(2);
		L2.addNodeAfterThis(3);
		L2.addNodeAfterThis(90);
		
		System.out.println(L2);//see if they are there
		System.out.println(L2.listLength(L2.getNodeLink()));
	}
	
}
