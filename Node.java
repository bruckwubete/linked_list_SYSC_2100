/*
 * THIS CLASS IS A MODEL FOR THE NODES TO BE INCLUDED IN THE LINKED LIST	
 */

/**
 *
 * @author Bruck
 */
public class Node {
    private Integer item;
    private Node next;
    private static final Integer DEFAULT_ITEM  = null;
    //constructors
    public Node(){
        this(DEFAULT_ITEM);
    }
    public Node(Integer o){
        this(o,null);
    }
    public Node(Integer o, Node n){
        item = o;
        next = n;
    }
     public Node(Integer o,Object n){
        item = o;
        if(n == null)next = null;
    }
    //accessors
    public Integer getItem(){
        return item;
    }
    public Node getNext(){
        return next;
    }
    //mutators
    public void setItem(Integer o){
        item = o;
    }
    public void setNext(Node n){
        next = n;
    }
}
