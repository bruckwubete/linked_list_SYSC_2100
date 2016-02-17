/*
 * THIS CLASS COUNTS THE NUMBER OF MATHES WITH A STRING IN A SUPPLIED DOCUMENT 
 */

/**
 *
 * @author Bruck
 */
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.net.*;
import java.io.*;
public class CountSubstrings {
    
   
public static void main(String[] args){
    Scanner S;
    S = new Scanner(System.in);
    System.out.print("Please enter the path for the input file: ");  //prompt the useer for input file 
    String file = S.nextLine();
    try{
    URL url = CountSubstrings.class.getResource(file);

    File files = new File(url.toURI());           //Load the file
    
    Scanner R = new Scanner(files);
    ArrayList<String> list = new ArrayList<String>();  //load all the words in the document to an ArrayList
    
    while (R.hasNext()){
        list.add(R.next());
   
    }       
 
    R = new Scanner(files);
    
    LinkedList<String> list2 = new LinkedList<String>();       //Load all teh words in teh document to a Linked list 
    while (R.hasNext()){
        
        list2.add(R.next());
    }       
    R.close();//close the scanner of the file 
    System.out.print("Please enter the pattern to look for: ");  //prompt the user for string to match with 
    String pattern = S.nextLine();
    long start_time = System.currentTimeMillis();  //start timer for ArrayList 
    int count = CountSubstrings_Array(list,pattern);//call count with an arraylist implementation 
    long end_time = System.currentTimeMillis(); //end timer for arrylist 
    System.out.println("Using ArrayLists: "+ count +" matches, derived in "+ (end_time - start_time)+" milli" //display output
            + "seconds");
    start_time = System.currentTimeMillis();  //start timer for Linked list 
    count = CountSubstrings_Linked(list2,pattern); //call count with linked list implementation 
    end_time = System.currentTimeMillis(); //end timer for linked list 
    System.out.println("Using LinkedLists: "+ count +" matches, derived in "+ (end_time - start_time)+" milli"   //display output 
            + "seconds");
    }catch(Exception e){
        
        System.out.println(e);  //if there is an error loading the file  or any other exceptoin, display here 
    }
    
    
}
	/**
 *
 * function to count the number of matches with an ArrayList implementation given a list of stirngs in an arrraylist and a pattern to look for 
 *@return int, the number of matches 
 *@param an arraylist including all the words in the document and a patteern to look for 
 */

 public static int CountSubstrings_Array(ArrayList<String> list, String Pattern){
     List<Character> Chars = new ArrayList<Character>(); 
     List<Character> patt = convertStringToArraylist(Pattern);//convert the param  to an array list of cahrs 
     int count = 0;
     for(String S:list){ //go throuugh each string  
         Chars = convertStringToArraylist(S); // //convert the string to an array list of cahrs  
         int i = findBrute(Chars,patt); //see if they match
         if(i!=-1)count++; //increment count if they match
     }
     return count;
     
 }
 	/**
 *
 * function to count the number of matches with an linkedlist implementation given a list of stirngs in a LinkedList and a pattern to look for 
 *@return int, the number of matches 
 *@param an linkedlist  including all the words in the document and a patteern to look for 
 */
 public static int CountSubstrings_Linked(LinkedList<String> list2, String Pattern){
     List<Character> Chars = new LinkedList<Character>(); 
     List<Character> patt = convertStringToLinkedList(Pattern); //convert pattern to an LinkedList of cahrs 
     int count = 0;
     for(String S:list2){
         Chars = convertStringToLinkedList(S);//convert the string to an LinkedList of cahrs 
         int i = findBrute(Chars,patt);  //see if they match 
         if(i!=-1)count++;  //if match inceremetn count 
     }
     return count;
     
 }
 
 	/**
 *
 * function conver a stirng into an array list of characters 
 *@return arraylist of characters
 *@param a string to convert to an arraylist of chars 
 */
 
 
 public static ArrayList<Character> convertStringToArraylist(String str) {
    ArrayList<Character> charList = new ArrayList<Character>();      
    for(int i = 0; i<str.length();i++){
        charList.add(str.charAt(i)); //iterate though the string and save the chars in an array list
    }
    return charList;
}
	/**
 *
 * function conver a stirng into an LinkedList list of characters 
 *@return arraylist of characters
 *@param a string to convert to an LinkedList of chars 
 */

 public static LinkedList<Character> convertStringToLinkedList(String str) {
    LinkedList<Character> charList = new LinkedList<Character>();      
    for(int i = 0; i<str.length();i++){
        charList.add(str.charAt(i)); //iterate though the string and save the chars in an array list
    }
    return charList;
}

 /*
  Supplied code 
* Returns the lowest index at which substring pattern begins in text (or
* else -1).
*/
private static int findBrute(List<Character> text, List<Character> pattern) {
			int n = text.size();
			int m = pattern.size();
			for (int i = 0; i <= n - m; i++) { // try every starting index// within text
				int k = 0; // k is index into pattern
				while (k < m && text.get(i + k) == pattern.get(k))// kth character of pattern matches
					k++;
					if (k == m) // if we reach the end of the pattern,
					return i; // substring text[i..i+m-1] is a match
				}
			return -1; // search failed
			}
	}
