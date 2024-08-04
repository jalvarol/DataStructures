import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetIndexTest {

	@Test
	void test() {
		List<Integer> B = new List<>();
	for(int i = 0; i<= 5; i++)
		{
			B.addLast(i);
		}
		B.placeIterator();
		assertEquals(1,B.getIndex());
		B.advanceIterator();
		assertEquals(2,B.getIndex());
		B.reverseIterator();
		assertEquals(1,B.getIndex());
	}

}
