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

    @Test
    public void expandTheArrayIfNotEnoughtSpaceForElement() {
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
    }

    @Test
    public void countsDigitsNumberInQueue() {
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.size()).isEqualTo(3);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.size()).isEqualTo(1);
        assertThat(randQueue.isEmpty()).isEqualTo(false);
        assertThat(randQueue.dequeue()).isIn(1,2,3,4,5);
        assertThat(randQueue.size()).isEqualTo(0);
        assertThat(randQueue.isEmpty()).isEqualTo(true);
    }


}
