import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getColorTest {

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
		assertEquals('B', test.getColor(8));
		assertEquals('W', test.getColor(5));
		assertEquals('B', test.getColor(4));

	}

}
