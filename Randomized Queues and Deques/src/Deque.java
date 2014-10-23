import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> prev;
        private Item value;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkThatItemNotNull(item);
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        size++;

        if (size == 1) {
            last = first;
        } else {
            oldFirst.prev = first;
        }

    }

    public void addLast(Item item) {
        checkThatItemNotNull(item);
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.prev = oldLast;
        size++;

        if (size == 1) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    private void checkThatItemNotNull(Item item) {
        if (item == null)
            throw new NullPointerException();
    }

    public Item removeFirst() {
        checkIfTheDequeIsEmpty();
        Item temp = first.value;
        first = first.next;
        size--;
        return temp;
    }

    public Item removeLast() {
        checkIfTheDequeIsEmpty();
        Item temp = last.value;
        last = last.prev;
        size--;
        return temp;
    }

    private void checkIfTheDequeIsEmpty(){
        if (size == 0)
            throw new NoSuchElementException();
    }

    public Iterator<Item> iterator() {
        return new IterableDeque();
    }

    private class IterableDeque implements Iterator<Item> {
        private int itSize = size;
        private Node<Item> nextNode = first;

        @Override
        public boolean hasNext() {
            return itSize > 0;
        }

        @Override
        public Item next() {

            if (hasNext()) {
                itSize--;
                Item temp = nextNode.value;
                nextNode = nextNode.next;
                return temp;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
