import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;


public class DequeTest {

    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<Integer>();
    }

    @Test
    public void addElementToTheBeginningOfTheDeque() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertThat(deque.removeFirst()).isEqualTo(3);
        assertThat(deque.removeFirst()).isEqualTo(2);
        assertThat(deque.removeFirst()).isEqualTo(1);
    }

    @Test
    public void addElementToTheEndOfTheDeque() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertThat(deque.removeLast()).isEqualTo(3);
        assertThat(deque.removeLast()).isEqualTo(2);
        assertThat(deque.removeLast()).isEqualTo(1);
    }

    @Test
    public void addElementAsFirstAndThenReturnItOnGetLastRequest() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(4);
        assertThat(deque.removeLast()).isEqualTo(3);
        assertThat(deque.removeFirst()).isEqualTo(4);
        assertThat(deque.removeLast()).isEqualTo(1);
    }

    @Test
    public void addElementAsLastAndThenReturnItOnGetFirstRequest() {
        deque.addLast(1);
        assertThat(deque.removeFirst()).isEqualTo(1);
    }

    @Test
    public void increaseDequeSizeOnEveryAddOperation() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        assertThat(deque.size()).isEqualTo(4);
    }

    @Test
    public void decreaseDequeSizeOnEveryRemoveOperation() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.removeFirst();
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.isEmpty()).isEqualTo(false);
        deque.removeFirst();
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isEqualTo(true);
    }

    @Test
    public void canIterateThrougElements() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);
        Iterator<Integer> it = deque.iterator();
        assertThat(it.hasNext()).isEqualTo(true);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.hasNext()).isEqualTo(false);
    }

    @Test(expected = NullPointerException.class)
    public void throwNullPointerExceptionOnAtemptToAddNullItem() {
        deque.addFirst(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwNoSuchElementException() {
        deque.removeFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void dontRemoveElementThroughIterator() {
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void throwNoSuchElementExceptionWhenNextCalledOnEmptyDeque() {
        deque.iterator().next();
    }


}
