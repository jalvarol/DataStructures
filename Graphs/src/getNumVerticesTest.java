import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getNumVerticesTest {

	@Test
	void test() {
		Graph test = new Graph(0);
		assertEquals(0, test.getNumVertices());
		test = new Graph(10);
		assertEquals(10, test.getNumVertices());
		test = new Graph(5);
		assertEquals(5, test.getNumVertices());
	}

}
