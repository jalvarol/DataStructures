import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinearSearchTest {

	@Test
	void test() {
		List<Integer> D = new List<>();
		for(int i = 1; i<= 20; i++)
		{
			if(i%2==0)
			{
			D.addLast(i);
			}
		}
		assertEquals(5,D.linearSearch(10));
		assertEquals(10,D.linearSearch(20));
		assertEquals(7,D.linearSearch(14));
	}

}
