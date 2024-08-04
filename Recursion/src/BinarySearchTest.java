import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		List<Integer> E = new List<>();
		for(int i = 1; i<=200; i++)
		{
			E.addLast(i);	
		}
		assertEquals(1,E.binarySearch(1));
		assertEquals(110,E.binarySearch(110));
		assertEquals(200,E.binarySearch(200));
	}

}
