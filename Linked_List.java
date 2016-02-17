/*
 * This class contains the implementations of all the methods 
 * that are required in this assignment
 */

/**
 *
 * @author Bruck
 */
public class Linked_List extends Node implements linked_lists{
    private int numItems;
    Node head;
    public Linked_List(){
       numItems = 0;
       head = null;
    }
	/**
 *
 * function to check if the linked list is empty or not
 *@return boolean
 *@param a linked_list
 */
    public boolean isEmpty(linked_lists L){
        return(numItems == 0);
	}
	
	/**
 *
 * function to return the size of the linked_list
 *@return int 
 *@param a linked_list
 */
    public int size(linked_lists L){
        return numItems;
    }
	
		/**
 *
 * function to add an item at a specific index 
 *@return void
 *@param the item 
 *@param the index to insert the item at
 */
    public void add(int i, int index){
        Integer I = new Integer(i);
        Node newNode = new Node(I);     //create a new node with the Integer object with the passed int 
		//method to insert on front of the list if it is empty 
        if (index == 0||numItems==0){
            newNode.setNext(head);
            head = newNode;
            numItems++;
        }else if (index<numItems){   //check if its legal to insert 
          int j = 0;
          Node prev = null;
          Node curr;
        for ( curr = head; curr != null && j<index; curr = curr.getNext()) {  //iterate curr to index 
           j++;
           prev = curr;
	}
        newNode.setNext(curr);   
        prev.setNext(newNode);   //insert the new node 
        numItems++;
        }else{ //ERROR CASE 
            System.out.println("!!!!ERROR Index_out_of_bound!!!!");
        }
        display(this);
    }
	
			/**
 *
 * function to remove an item at a specific index 
 *@return void
 *@param the index to remove an item at
 */
    public void remove(int index){
        if( head == null){  //error case 
            System.out.println("!!Error Trying to remove from an empty list!!");
        }
        else if(index==0){
            head = head.getNext();
            numItems--;
        }else if(index<numItems){
            int i = 0;
          Node prev = null;
          Node curr;
        for ( curr = head; curr != null && i<index; curr = curr.getNext()) { //itterate curr to the index 
           i++;
           prev = curr;
	}
        prev.setNext(curr.getNext());  //remove the index 
		curr.setNext(curr.getNext());  //move curr to the next then the node is marked for garbage collection 
        numItems--;
        }
        display(this);
    }
	
			/**
 *
 * function to get an item at a specific index 
 *@return Integer object
 *@param the index required 
 */
    public Integer get(int index){
        int i = 0;
        Node prev = null;
        Node curr;
        for ( curr = head; curr != null && i<index; curr = curr.getNext()) { //itterate to the index 
	
           i++;
           prev = curr;
	}
        return curr.getItem();  //return the object 
    }
			/**
 *
 * function to remove all items in a list
 *@return void
 *@param the linked list
 */
    
    public void removeAll(linked_lists L){
        Node prev = head;
       int i = 0;
		for ( Node curr = head; curr != null; curr = curr.getNext()) {
				if(i != 0){
					prev.setNext(null);   //for the first iteration dont set next null this will be done in the end
				}
				prev = curr;
				numItems--;
				i++;
			}
		if(isEmpty(this)){
			head =null;   //set head to null as list is empty 
		}
			display(this);
			
    }
	
				/**
 *
 * function to display the linked list
 *@return void
 *@param the linked list
 */
    public void display(linked_lists L){
        System.out.print(numItems +" Item(s)"
                        + " in the linked list: ");
    for ( Node curr = head; curr != null; curr = curr.getNext()) { //itterate though the list 
			
           if(curr.getNext()==null){
			   System.out.println(curr.getItem());   //for the last case to print without comma 
		   }else{     
				System.out.print(curr.getItem() + ",");
		   }
          
	}
    }
}