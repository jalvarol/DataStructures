
/**
 * Queue.java
 * @author Jose Alvaro Leos
 */
import java.util.*;

public class Queue<T> {
	private Stack<T> s1;
	private Stack<T> s2;
	/** Constructors **/

	/**
	 * Default constructor for the Queue class
	 */
	public Queue() 
	{
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
	}

	/**
	 * Copy constructor for the Queue class
	 * 
	 * @param q the original Queue to copy
	 */
	public Queue(Queue<T> q) 
	{						
			this();			
			if(q == null)	
			{				
				this.s1 = new Stack<>();
				this.s2 = new Stack<>();
			}
			if(q.getSize()==0)
			{
				this.s1 = new Stack<>();
				this.s2 = new Stack<>();
			}
			else 
			{
				while(!q.s1.isEmpty())
				{
					q.s2.push(q.s1.peek());
					q.s1.pop();
					
				}
				while(!q.s2.isEmpty())
				{
					enqueue(q.s2.peek());
					q.s1.push(this.s1.peek());
					q.s2.pop();
				}
				
			}
	}

	/** Mutators **/

	/**
	 * Inserts new data to the end of the Queue
	 * @param data the value to insert
	 */
	public void enqueue(T data) {
		s1.push(data);
	}

	/**
	 * Removes data from the front
	 * 
	 * @precondition length != 0
	 */
	public void dequeue() throws NoSuchElementException {
		if (getSize()==0) {
			throw new NoSuchElementException("Dequeue(): Queue is empty, no data to access");
		} else if (getSize() == 1) {
			s1.pop();
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
			s2.pop();
			while (!s2.isEmpty()) {
				enqueue(s2.peek());
				s2.pop();
			}
		}

	}

	/**
	 * Appends the values of a a new Queue onto the end of this Queue
	 * 
	 * @param q the Queue whose values to append
	 */
	public void append(Queue<T> q) {
		while (!q.s1.isEmpty()) {
			q.s2.push(q.s1.peek());
			q.s1.pop();
		}
		while (!q.s2.isEmpty()) {
			enqueue(q.s2.peek());
			q.enqueue(s1.peek());
			q.s2.pop();
		}

	}

	/** Accessors **/

	/**
	 * Returns the data at the front
	 * 
	 * @precondition length != 0
	 * @return the front of the Queue
	 */
	public T getFront() throws NoSuchElementException {
		if (getSize() == 0) {
			throw new NoSuchElementException("getFront(): Queue is empty, no data to access!");
		}
		while (!s1.isEmpty()) {
			s2.push(s1.peek());
			s1.pop();
		}
		T top = s2.peek();
		while (!s2.isEmpty()) {
			enqueue(s2.peek());
			s2.pop();
		}
		return top;

	}

	/**
	 * Returns the current size of this Queue
	 * 
	 * @return the current size
	 */
	public int getSize() {
		return s2.getLength() + s1.getLength();
	}

	/**
	 * Returns whether this Queue is currently empty
	 * 
	 * @return whether the Queue is empty
	 */
	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	/**
	 * Determines whether two Queues have the data stored in the same order
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this)
		{ return true; 
		}
		else if (!(o instanceof Queue)) 
		{ 
			return false; 
		} 
		else 
		{ 
			Queue<T> L = (Queue<T>) o; 
			if (this.getSize() != L.getSize())
		  { 
				return false; 
		  } 
			else 
			{ 
				while (!this.s1.isEmpty()) 
				{ 
					L.s2.push(L.s1.peek());
					L.s1.pop();
					this.s2.push(this.s1.peek());
					this.s1.pop();
					if (!L.s2.peek().equals(this.s2.peek())) 
					{ 
						return false; 
					} 
					
				}
				while(!this.s2.isEmpty()) 
				{
					enqueue(s2.peek());
					this.s2.pop();
				}

				return true; 
			} 
		}

	}

	/** Additional Operations **/

	/**
	 * Creates a String to store the values the Queue,separated with spaces and
	 * ending with a new line character
	 */
	@Override
	public String toString() {
		String result = "";
		while (!s1.isEmpty()) {
			s2.push(s1.peek());
			s1.pop();
		}
		while (!s2.isEmpty()) {
			enqueue(s2.peek());
			result += " " + s2.peek();
			s2.pop();
		}
		return result+"\n";
	}
}