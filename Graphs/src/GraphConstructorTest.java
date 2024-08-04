import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphConstructorTest {

	@Test
	void test() {
		Graph test = new Graph(9);
		assertFalse(test.isEmpty());
		assertEquals(0, test.getNumEdges());
		assertEquals(9, test.getNumVertices());
		test.addDirectedEdge(1, 5);
		assertEquals(1, test.getNumEdges());

	}

}
