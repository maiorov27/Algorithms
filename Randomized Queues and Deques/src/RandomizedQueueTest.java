import org.junit.*;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        assertThat(randQueue.dequeue()).isIn(1, 2, 3, 4, 5);
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


    @Test
    public void allowIterateThroughQueue() {
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        Iterator<Integer> it = randQueue.iterator();
        assertThat(it.hasNext()).isEqualTo(true);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.next()).isEqualTo(5);
        assertThat(it.hasNext()).isEqualTo(false);
    }

    @Test(expected =  NoSuchElementException.class)
    public void throwExceptionIfNoMoreElement() {
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        Iterator<Integer> it = randQueue.iterator();
        assertThat(it.hasNext()).isEqualTo(true);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.next()).isEqualTo(5);
        assertThat(it.hasNext()).isEqualTo(false);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionIfReturnedTheLast() {
        randQueue.enqueue(1);
        randQueue.dequeue();
        randQueue.dequeue();
    }

    @Test(expected = NullPointerException.class)
    public void throwIfClientTryToAddNullToQueue() {
        randQueue.enqueue(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void onCallRemove() {
        randQueue.enqueue(1);
        Iterator<Integer> it = randQueue.iterator();
        it.next();
        it.remove();
    }


}
