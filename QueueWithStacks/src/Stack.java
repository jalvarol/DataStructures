
/**
 * Stack.java
 * @author
 */

import java.util.NoSuchElementException;

public class Stack<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node top;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Stack class
	 * 
	 * @postcondition a new Stack object with all fields assigned default values
	 */
	public Stack() {
		top = null;
		length = 0;
	}

	/**
	 * Copy constructor for the Stack class
	 * 
	 * @param original the Stack to copy
	 * @postcondition a new Stack object which is an identical, but distinct, copy
	 *                of original
	 */
	public Stack(Stack<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			this.length = 0;
			this.top = null;
		} else {
			Stack<T> copy = new Stack<>();
			Node temp = original.top;
			while (temp != null) {
				copy.push(temp.data);
				temp = temp.next;
			}
			while (!copy.isEmpty()) {
				push(copy.peek());
				copy.pop();
			}
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored at the top of the Stack
	 * 
	 * @return the value at the top of the Stack
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("peek(): Stack is empty. No data to access!");
		}
		return top.data;

	}

	/**
	 * Returns the length of the Stack
	 * 
	 * @return the length from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Determines whether a Stack is empty
	 * 
	 * @return whether the Stack is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Determines whether two Stacks contain the same values in the same order
	 * 
	 * @param Q the Stack to compare to this
	 * @return whether Q and this are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Stack)) {
			return false;
		} else {
			Stack<T> L = (Stack<T>) o;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.top;
				Node temp2 = L.top;
				while (temp1 != null) {
					if (!temp1.data.equals(temp2.data)) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}

	}

	/**** MUTATORS ****/

	/**
	 * Inserts a new value at the top of the Stack
	 * 
	 * @param data the new data to insert
	 * @postcondition a new node at the end of the Stack
	 */
	public void push(T data) {
		Node n = new Node(data);
		n.next = top;
		top = n;
		length++;
	}

	/**
	 * Removes the top element of the Stack
	 * 
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 * @postcondition the top element has been removed
	 */
	public void pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("pop(): " + "Stack is empty. No data to access!");
		} else if (length == 1) {
			top = null;
		} else {
			top = top.next;
		}
		length--;
	}

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Stack as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Stack values
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = top;
		while (temp != null) {
			result += "\n" + temp.data;
			temp = temp.next;
		}
		return result;
	}

}