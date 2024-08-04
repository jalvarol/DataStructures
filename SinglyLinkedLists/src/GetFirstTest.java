import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetFirstTest {

	@Test
	void test() {
		 List<Integer> N = new List<>();
	        N.addFirst(1);
	        assertEquals(1, N.getFirst());
	        N.addFirst(2);
	        assertEquals(2, N.getFirst());       
	        N.addFirst(3);
	        assertEquals(3, N.getFirst());
	}

}
