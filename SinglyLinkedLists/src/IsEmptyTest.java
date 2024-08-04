import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	void test() {
		List<Integer> R = new List<>();
        	R.addFirst(1);
        	assertFalse(R.isEmpty());
        	R.removeFirst();
        	assertTrue(R.isEmpty());       
        	R.addFirst(3);
        	assertFalse(R.isEmpty());
	}

}
