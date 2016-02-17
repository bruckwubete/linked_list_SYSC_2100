/*
 THI IS AN INTERFACE INCLUDING ALL THE PROTOTYPE FUNCTIONS FOR THE LINKED LIST
 */

/**
 *
 * @author Bruck
 */
interface linked_lists{
    public boolean isEmpty(linked_lists L);
    public int size(linked_lists L);
    public void add(int i,int index);
    public void remove(int index);
    public Integer get(int index);
    public void removeAll(linked_lists L);
    public void display(linked_lists L);
}