
public class GraphTest {

	public static void main(String[] args) {
		Graph test = new Graph(8);
		System.out.println("*****Testing Print BFS()*****");
		test.printBFS();

		System.out.println("*****Testing BFS()*****");
		System.out.println("Should print an error: ");
		try {
			test.BFS(8);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		test.addDirectedEdge(1, 2);
		test.addDirectedEdge(1, 3);
		test.addDirectedEdge(2, 1);
		test.addDirectedEdge(2, 3);
		test.addDirectedEdge(2, 4);
		test.addDirectedEdge(2, 8);
		test.addDirectedEdge(3, 1);
		test.addDirectedEdge(3, 2);
		test.addDirectedEdge(3, 4);
		test.addDirectedEdge(4, 2);
		test.addDirectedEdge(4, 3);
		test.addDirectedEdge(5, 6);
		test.addDirectedEdge(5, 7);
		test.addDirectedEdge(6, 5);
		test.addDirectedEdge(6, 7);
		test.addDirectedEdge(7, 5);
		test.addDirectedEdge(7, 6);
		test.addDirectedEdge(8, 2);

		System.out.println("Should print an error: ");
		try {
			test.BFS(9);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		test.BFS(8);
		test.printBFS();

		System.out.println("\n*****Testing addDirectedEdge()*****\n");
		System.out.println("Should print an error: ");
		try {
			test.addDirectedEdge(9, 8);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("\n*****Testing addUndirectedEdge()*****\n");
		System.out.println("Should print an error: ");
		try {
			test.addUndirectedEdge(9, 8);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		test.addUndirectedEdge(8, 5);
		test.BFS(8);

		System.out.println("\n*****Testing getNumEdges()*****\n");
		System.out.println("Should print 19: " + test.getNumEdges());

		System.out.println("\n*****Testing getNumVertices()*****\n");
		System.out.println("Should print 8: " + test.getNumVertices());

		System.out.println("\n*****Testing getAdjacencyList()*****");
		System.out.println("\nShould print an error: ");
		try {
			test.getAdjacencyList(9);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print 2 3: " + test.getAdjacencyList(1));
		System.out.println("Should print 1 3 4 8: " + test.getAdjacencyList(2));

		System.out.println("\n*****Testing isEmpty()*****\n");
		System.out.println("Should print false: " + test.isEmpty());

		System.out.println("\n*****Testing getDistance()*****");
		System.out.println("\nShould print an error: ");
		try {
			test.getDistance(9);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print 2: " + test.getDistance(1));
		System.out.println("Should print -1: " + test.getDistance(5));
		System.out.println("\n*****Testing getParent()*****");
		System.out.println("\nShould print an error: ");
		try {
			test.getParent(9);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print 8: " + test.getParent(5));
		System.out.println("Should print 2: " + test.getParent(1));
		System.out.println("Should print 8: " + test.getParent(2));
		System.out.println("\n*****Testing getColor()*****");
		System.out.println("\nShould print an error: ");
		try {
			test.getColor(9);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print B: " + test.getColor(1));
		System.out.println("Should print B: " + test.getColor(2));
		System.out.println("Should print W: " + test.getColor(5));

		System.out.println("\n*****Testing toString()*****\n");
		System.out.println(test.toString());

	}

}
