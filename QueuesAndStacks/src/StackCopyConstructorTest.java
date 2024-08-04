import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackCopyConstructorTest {

	@Test
	void test() {
		Stack<Integer> I = new Stack<>();

		I.push(5);
		I.push(10);
		I.push(15);
		assertEquals(3, I.getLength());
		Stack<Integer> Icopy = new Stack<>(I);
		assertEquals(3, Icopy.getLength());
		assertEquals(15, Icopy.peek());
		Icopy.push(20);
		Stack<Integer> I2copy = new Stack<>(Icopy);
		assertEquals(20, I2copy.peek());
		I2copy.push(30);
		Stack<Integer> I3copy = new Stack<>(I2copy);
		assertEquals(30, I3copy.peek());
		I3copy.pop();
		assertEquals(4, I3copy.getLength());

	}

}
