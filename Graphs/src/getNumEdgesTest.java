import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getNumEdgesTest {

	@Test
	void test() {
		Graph test = new Graph(10);
		assertEquals(0, test.getNumEdges());
		test.addDirectedEdge(1, 2);
		assertEquals(1, test.getNumEdges());
		test.addDirectedEdge(10, 1);
		assertEquals(2, test.getNumEdges());
	}

}
