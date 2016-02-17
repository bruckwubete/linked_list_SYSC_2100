/*
 * THIS IS THE CLIENT PROGRAM THAT CREATES A LINKED_LIST AND ADDS PARAMETERS TO IT
 */

/**
 *
 * @author Bruck
 */

public class TestListReferenceBased {
    public static void main(String[] args){
        linked_lists L = new Linked_List();
		//do all the requirements of the assignment 
        L.add(18,0);
        L.add(25,0);
        L.add(3,0);
        L.add(12,0);
        L.display(L);
        L.add(13,0);
        L.add(17,2);
        L.remove(4);  
		//L.removeAll(L); TO REMOVE ALL ITEMS UNCOMMENT THIS LINE, ALL OTHER FUNCTIONS WORK TOO
    }
   
}
