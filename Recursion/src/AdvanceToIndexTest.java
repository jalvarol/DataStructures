import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdvanceToIndexTest {
    
        @Test
        void test() {
            List<Integer> E = new List<>();
            for(int i = 1; i<=200; i++)
            {
                if(i % 3 == 0)
                {
                    E.addLast(i);
                }	
            }
            E.advanceToIndex(13);
            assertEquals(39,E.getIterator());
            E.advanceToIndex(24);
            assertEquals(72, E.getIterator());
            E.advanceToIndex(31);
            assertEquals(93,E.getIterator());
         
            
        }
    
    }