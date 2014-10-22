import org.junit.Before;
import org.junit.Test;

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


}
