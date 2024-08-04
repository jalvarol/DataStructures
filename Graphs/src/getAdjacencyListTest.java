import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getAdjacencyListTest {

	@Test
	void test() {
		Graph test = new Graph(8);
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
		test.BFS(8);
		assertEquals(2, test.getAdjacencyList(8).getFirst());
		assertEquals(4, test.getAdjacencyList(3).getLast());
		assertEquals(1, test.getAdjacencyList(3).getFirst());
	}

}
