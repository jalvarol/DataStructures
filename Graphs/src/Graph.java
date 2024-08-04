
/**
 * Graph.java
 * @author Jose Alvaro Leos
 */

import java.util.ArrayList;

public class Graph {
	private int vertices;
	private int edges;
	private ArrayList<List<Integer>> adj;
	private ArrayList<Character> color;
	private ArrayList<Integer> distance;
	private ArrayList<Integer> parent;

	/** Constructor */

	/**
	 * initializes an empty graph, with n vertices and 0 edges, and intitializes all
	 * arraylists to contain default values from indices 1 to n
	 * 
	 * @param n the number of vertices in the graph
	 */
	public Graph(int n) {
		vertices = n;
		edges = 0;
		adj = new ArrayList<List<Integer>>(n);
		color = new ArrayList<Character>(n);
		distance = new ArrayList<Integer>(n);
		parent = new ArrayList<Integer>(n);

		for (int i = 0; i <= n; i++) {
			adj.add(i, new List<Integer>());
			color.add(i, 'W');
			distance.add(i, -1);
			parent.add(i, 0);
		}

	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return vertices;
	}

	/**
	 * returns whether the graph is empty (no vertices)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return vertices == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getDistance(): Index out of bounds!");
		}
		return distance.get(v);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getParent(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getParent(): Index out of bounds! ");
		}
		return parent.get(v);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getColor(): Index out of bounds!");
		}
		return color.get(v);
	}

	/**
	 * Returns the List stored at index v
	 * 
	 * @param v a vertex in the graph
	 * @return the adjacency List a v
	 * @precondition 0 < v <= vertices
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getAdjacenyList(): Index out of bounds!");
		}
		return adj.get(v);
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u)
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 * @postcondition a sorted adjacency list
	 */
	public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices || u <= 0 || u > vertices) {
			throw new IndexOutOfBoundsException("addDirectedEdge(): Index out of bounds!");
		} else if (adj.get(u).isEmpty()) {
			adj.get(u).addFirst(v);
			edges++;
			return;
		} else if (adj.get(u).getFirst() > v) {
			adj.get(u).addFirst(v);
			edges++;
			return;
		} else if (adj.get(u).getLast() < v) {
			adj.get(u).addLast(v);
			edges++;
			return;
		}
		adj.get(u).placeIterator();
		while (!adj.get(u).offEnd()) {
			if (adj.get(u).getIterator() > v) {
				adj.get(u).advanceIterator();
			} else {
				adj.get(u).addIterator(v);
				edges++;
				return;
			}

		}
	}

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u) and inserts u into the adjacent vertex list of v
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 * @postcondition a sorted adjacency list
	 */
	public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (u <= 0 || u > vertices || v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("addUndirectedEdge(): Index out of bounds!");
		} else {
			adj.get(u).addLast(v);
			adj.get(v).addLast(u);
			edges++;
		}
	}

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space separated list of adjacent vertices>
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i <= vertices; i++) {
			result += i + ": " + adj.get(i) + "\n";
		}
		return result;
	}

	/**
	 * Prints the current values in the parallel ArrayLists after executing BFS.
	 * First prints the heading: v <tab> c <tab> p <tab> d Then, prints out this
	 * information for each vertex in the graph Note that this method is intended
	 * purely to help you debug your code
	 */
	public void printBFS() {
		System.out.println("v\tc\tp\td");
		for (int i = 1; i <= vertices; i++) {
			System.out.println(i + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + distance.get(i));
		}

	}

	/**
	 * Performs breath first search on this Graph give a source vertex
	 * 
	 * @param source the source vertex
	 * @precondition graph must not be empty
	 * @precondition source is a vertex in the graph
	 * @throws IllegalStateException     if the graph is empty
	 * @throws IndexOutOfBoundsException when vertex is outside the bounds of the
	 *                                   graph
	 */
	public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {
		if (getNumEdges() == 0) {
			throw new IllegalStateException("BFS(): Graph has 0 edges");
		} else if (source <= 0 || source > vertices) {
			throw new IndexOutOfBoundsException("BFS(): Index out of bounds!");
		} else {
			for (int i = 1; i <= vertices; i++) {
				color.set(i, 'W');
				distance.set(i, -1);
				parent.set(i, 0);
			}
			color.set(source, 'G');
			distance.set(source, 0);
			parent.set(source, 0);
			List<Integer> s1 = new List<>();
			s1.addFirst(source);
			while (!s1.isEmpty()) {
				int x = s1.getFirst();
				s1.removeFirst();
				List<Integer> s2 = new List<>(getAdjacencyList(x));
				s2.placeIterator();
				while (!s2.offEnd()) {
					if (color.get(s2.getIterator()).compareTo('W') == 0) {
						color.set(s2.getIterator(), 'G');
						parent.set(s2.getIterator(), x);
						distance.set(s2.getIterator(), getDistance(x) + 1);
						s1.addLast(s2.getIterator());
						s2.advanceIterator();
					} else {
						s2.advanceIterator();
					}
				}
				color.set(x, 'B');
			}

		}
	}
}
