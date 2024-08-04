
/**
 * Defines a doubly-linked list class
 * @author Jose Leos
 */

import java.util.*;

public class List<T extends Comparable<T>> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new doubly linked List with default values
	 * 
	 * @postcondition first, last, and 
	 * iterator will contain null and 
	 * length will be set to zero
	 */
	public List() {
		first = last = iterator = null;
		length = 0;
	}

	/**
	 * Instantiates a new List by copying another List
	 * 
	 * @param original the List to make a copy of
	 * @postcondition a new List object, which is identical but a separate copy of
	 *                the original List
	 */
	public List(List<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			this.length = 0;
			this.first = null;
			this.last = null;
			this.iterator = null;
		} else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}

	/**** ACCESSORS ****/
	/**
     * Uses the iterative linear search
     * algorithm to locate a specific
     * element in the list
     * @param element the value to search for
     * @return the location of value in the
     * List or -1 to indicate not found
     * Note that if the List is empty we will
     * consider the element to be not found
     * @postcondition: position of the iterator remains
     * unchanged!
     */
    public int linearSearch(T element) {
    	Node temp = first;
    	for(int i = 1; i<=length;i++)
    	{
    		if(temp.data == element)
    		{
    			return i;
    		}
    		temp = temp.next;
    	}
        return -1;
    }
    /**
     * Returns the index from 1 to length
     * where value is located in the List
     * by calling the private helper method
     * binarySearch
     * @param value the value to search for
     * @return the index where value is
     * stored from 1 to length, or -1 to
     * indicate not found
     * @precondition isSorted()
     * @postcondition the position of the
     * iterator must remain unchanged!
     * @throws IllegalStateException when the
     * precondition is violated.
     */
    public int binarySearch(T value) throws IllegalStateException {
    	if(!inSortedOrder())
    	{
    		throw new IllegalStateException("binarySearch(): List is not sorted!");
    	}
    	else
    		return binarySearch(1,length,value);	
    }
   
    /**
     * Searches for the specified value in
     * the List by implementing the recursive
     * binarySearch algorithm
     * @param low the lowest bounds of the search
     * @param high the highest bounds of the search
     * @param value the value to search for
     * @return the index at which value is located
     * or -1 to indicate not found
     * @postcondition the location of the iterator
     * must remain unchanged
     */
    private int binarySearch(int low, int high, T value) 
    {
    	if(high < low)
    		return -1;    	
    	int mid = low +(high-low)/2;
    	Node temp = first;
    	int i = 1;
    	while(i < mid)
    	{
    		temp = temp.next;
    		i++;
    	}
    	if(value.compareTo(temp.data)==0)
    	{
    		return mid;
    	}
    	else if(value.compareTo(temp.data)<0)
    		return binarySearch(low,mid-1,value);
    	else
    		return binarySearch(mid+1,high,value);
    } 

	/**
     * Returns the index of the iterator
     * from 1 to n. Note that there is
     * no index 0. Does not use recursion.
     * @precondition iterator !offEnd()
     * @return the index of the iterator
     * @throws NullPointerException when
     * the precondition is violated
     */
    public int getIndex() throws NullPointerException{

    	if(offEnd())
        {
        	throw new NullPointerException("getIndex(): Iterator is offEnd!");
        }
        else 
        {	
        		Node temp = this.iterator;	
        		int index=0;
        		while(temp != null)
        		{
        			temp = temp.prev;
        			index++;
        		}
        	return index;
        }
    }
	/**
	 * Determines whether a List is sorted by calling its recursive helper method
	 * isSorted Note: An empty List can be considered to be (trivially) sorted
	 * @return whether this List is sorted
	 */
	public boolean inSortedOrder() {
		Node temp = first;
		return inSortedOrder(temp);
	}
	/**
	 * Helper method to inSortedOrder Determines whether a List is sorted in
	 * ascending order recursively
	 * 
	 * @return whether this List is sorted
	 */
    private boolean inSortedOrder(Node n) 
    {
    	if(n.next == null)
    	{
    		return true;
    	}
    	else if(n.data.compareTo(n.next.data)>0)
    	{
    		return false;
    	} else 
    	{
    		return inSortedOrder(n.next);
    	}
    }
	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition check List if isEmpty
	 * @return the value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (isEmpty())// precondition
		{
			throw new NoSuchElementException("getFirst(): " + "List is empty. No data to access!");
		}
		return first.data;
	}
	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition List !isEmpty
	 * @return the value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException // GET LAST
	{
		if (isEmpty())// precondition
		{
			throw new NoSuchElementException("getLast(): " + "List is empty. No data to access!");
		}
		return last.data;
	}
	/**
	 * Returns the current length of the list
	 * 
	 * @return the length of the list from 0 to n
	 */
	public int getLength() {
		return length;
	}
	/**
	 * Returns the element currently pointed at by the iterator
	 * 
	 * @precondition iterator !offEnd
	 * @return the value pointed at by the iterator
	 * @throws NullPointerException when the precondition is violated
	 */
	public T getIterator() throws NullPointerException {
		if (offEnd()) // precondition
		{
			throw new NullPointerException("getIterator: " + "iterator is off the end of the List.");
		}
		return iterator.data;
	}
	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}
	/**
	 * Returns whether or not the iterator is off the end of the List, i.e. null
	 * 
	 * @return whether the iterator is null
	 */
	public boolean offEnd() {
		return iterator == null;
	}
	/**** MUTATORS ****/
	/**
     * Places the iterator at first
     * and then iteratively advances
     * it to the specified index
     * no recursion
     * @param index the index where
     * the iterator should be placed
     * @precondition 1 <= index <= length
     * @throws IndexOutOfBoundsException
     * when precondition is violated
     */
    public void advanceToIndex(int index) throws IndexOutOfBoundsException{
        if(1 > index || index>this.length)
        {
        	throw new IndexOutOfBoundsException("AdvanceToIndex(): Index out of bounds!");
        }
        else
        	placeIterator();
        	for(int i = 1; i < index; i++)
        	{
        		advanceIterator();
        	}
    }
	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition first node will contain the param
	 */
	public void addFirst(T data) // doubly linked list updated
	{
		if (isEmpty())// edge
		{
			first = last = new Node(data);
		} else // general
		{
			Node n = new Node(data);
			n.next = first;
			first.prev = n;
			first = n;
		}
		length++;
	}
	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the list
	 * @postcondition the last node will contain the param
	 */
	public void addLast(T data)// doubly linked list updated
	{
		if (isEmpty())// edge
		{
			first = last = new Node(data);
		} else // general
		{
			Node n = new Node(data);
			last.next = n;
			n.prev = last;
			last = n;
		}
		length++;
	}
	/**
	 * Inserts new data in the List after the iterator
	 * 
	 * @param data the new data to insert
	 * @precondition iterator !offEnd
	 * @postcondition iterator = data throws NullPointerException when the
	 *                precondition is violated
	 */
	public void addIterator(T data) throws NullPointerException {
		if (offEnd()) // precondition
		{
			throw new NullPointerException("addIterator: " + "Iterator is offend. Cannot add.");
		} else if (iterator == last) // edge case
		{
			addLast(data);
		} else // general case
		{
			Node n = new Node(data);
			n.next = iterator.next;
			n.prev = iterator;
			iterator.next.prev = n;
			iterator.next = n;
			length++;
		}
	}
	/**
	 * Moves the iterator to the start of the List
	 * 
	 * @postcondition iterator = first if List is empty, iterator = first = null;
	 */
	public void placeIterator() {
		if (isEmpty()) {
			first = iterator = null;
		} else
			iterator = first;
	}
	/**
	 * Removes data in the List
	 * 
	 * @param data the new data to insert
	 * @precondition iterator !offEnd
	 * @postcondition iterator = null
	 * @throws NullPointerException when the precondition is violated
	 */
	public void removeIterator() throws NullPointerException {
		if (offEnd())// precondition
		{
			throw new NullPointerException("removeIterator:" + "Iterator is offEnd. Cannot remove.");
		} else if (iterator == first)// edge case
		{
			removeFirst();
		} else if (iterator == last)// edge case
		{
			removeLast();
		} else// general case
		{
			iterator.prev.next = iterator.next;
			iterator.next.prev = iterator.prev;
			length--;
		}
		iterator = null;
	}
	/**
	 * Advances the iterator by one node in the List
	 * 
	 * @precondition iterator !offEnd()
	 * @throws NullPointerException when the precondition is violated
	 */
	public void advanceIterator() throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException("advanceIterator: " + "is null and cannot advance");
		}
		iterator = iterator.next;
	}
	/**
	 * Reverse the iterator by one node
	 * 
	 * @precondition iterator !offEnd()
	 * @throws NullPointerException when the precondition is violated
	 */
	public void reverseIterator() {
		if (offEnd()) {
			throw new NullPointerException("reverseIterator: " + "is null and cannot advance");
		}
		iterator = iterator.prev;
	}
	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition List !isEmpty()
	 * @postcondition will remove the first node from the List
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("removeFirst(): " + "List is empty. No data to access!");
		} else if (length == 1) {
			first = last = null;
		} else {
			first = first.next;
			first.prev = first;
		}
		length--;

	}
	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition !isEmpty()
	 * @postcondition the last node will be removed from the List
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("removeLast(): " + "List is empty. No data to access!");
		} else if (length == 1) {
			last = first = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		length--;
	}
	/**** ADDITIONAL OPERATIONS ****/
	/**
	 * List with each value on its own line At the end of the List a new line
	 * 
	 * @return the List as a String for display
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = first;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		return result;
	}
	/** Additional Operations */
	/**
	 * Prints a linked list to the console in reverse by calling the private
	 * recursive helper method printInReverse
	 */
	public void printInReverse() {
		Node temp = last;
		printInReverse(temp);
	}
	/**
	 * Recursively prints a linked list to the console in reverse order from last to
	 * first (no loops) Each element separated by a space Should print a new line
	 * after all elements have been displayed
	 */
	private void printInReverse(Node node)
	{
		if(node == null)
		{
			System.out.println();
			return;
		}
		else 
			System.out.printf(node.data+" ");
			printInReverse(node.prev);
	}
	/**
	 * Determines whether two Lists have the same data in the same order
	 * 
	 * @param L the List to compare to this List
	 * @return whether the two Lists are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (!(obj instanceof List)) {
			return false;
		} else {
			List<T> L = (List<T>) obj;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.first;
				Node temp2 = L.first;
				while (temp1 != null) {
					if (temp1.data != temp2.data) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}
	}

}
