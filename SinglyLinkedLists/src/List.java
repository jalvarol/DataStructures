/**
 * Defines a singly-linked list class
 * @author Jose Leos
 */

import java.util.NoSuchElementException;

public class List<T> {
    private class Node {
        private T data;
        private Node next;
       
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
   
    private int length;
    private Node first;
    private Node last;
   
    /****CONSTRUCTOR****/
   
    /**
     * Instantiates a new List with default values
     * @postcondition first and last will contain null and length 
     * will be set to zero
     */
    public List(){
    	first = last = null;
    	length = 0;
    }

   
    /****ACCESSORS****/
   
    /**
     * Returns the value stored in the first node
     * @precondition Check if first != NULL
     * @return the value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
    	if(isEmpty())
    	{
    		throw new NoSuchElementException
    		("getFirst(): "+ "List is empty. No data to access!");
    	}
         return first.data;
    }
   
    /**
     * Returns the value stored in the last node
     * @precondition
     * @return the value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException
    		("getLast(): "+ "List is empty. No data to access!");
    	}
        return last.data;
    }
   
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }
   
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() 
    {  	
    	return length==0;
    }
   
    /****MUTATORS****/
   
    /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition first node will contain the param 
     */
    public void addFirst(T data) 
    {	  
        	if(isEmpty())
        	{
        		first = last = new Node(data);
        	} 	
    		else 
    		{
    			Node n = new Node(data);
    			n.next = first;
    			first = n;
    		}
    	length++;
    }
   
    /**
     * Creates a new last element
     * @param data the data to insert at the
     * end of the list
     * @postcondition the last node will contain the param
     */
    public void addLast(T data)
    {
    	if(isEmpty())
    	{
    		first = last = new Node(data);
    	} 	
    		else 
    		{
    			Node n = new Node(data);
    			last.next = n;
    			last = n;
    		}
    	length++;
    }
   
    /**
    * removes the element at the front of the list
    * @precondition check if List !isEmpty() or if length ==1
    * @postcondition will remove the first node from the List
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException
    {
      	if(isEmpty())
      	{
    		throw new NoSuchElementException("removeFirst(): "+ "List is empty. No data to access!");
    	}
      	else if(length == 1)
      	{
      		first = last = null;
      	}
      	else 
      	{
      		first = first.next;
      	}
      	length--;
        
    }
   
    /**
     * removes the element at the end of the list
     * @precondition check if list isEmpty() or if length == 1
     * @postcondition the last node will be removed from the List
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException
    {
      	if(isEmpty())
    	{
    		throw new NoSuchElementException
    		("removeLast(): "+ "List is empty. No data to access!");
    	}
      	else if (length == 1)
      	{
      		last = first = null;
      	}
      	else
      	{
      		Node temp = first;
      		while(temp.next != last)
      		{
      			temp = temp.next;
      		}
      		last = temp;
      		last.next = null;
      	}
        length--;
    }
   
    /****ADDITIONAL OPERATIONS****/
   
    /**
     * List with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() 
    {
    	String result = "";
        Node temp = first;
        while(temp != null) 
        {
            result += temp.data+" ";
            temp = temp.next;
        }
        return result;
    }
   

}