import org.junit.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomizedQueueTest {

    private RandomizedQueue<Integer> randQueue;

    @Before
    public void setUp() {
        randQueue = new RandomizedQueue<Integer>();
    }

    @Test
    public void addItemToTheQueue() {
        randQueue.enqueue(3);
        assertThat(randQueue.sample()).isEqualTo(3);
    }
}
