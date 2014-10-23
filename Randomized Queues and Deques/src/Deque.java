import java.util.Iterator;

public class Deque<Item> {

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

    public Item removeFirst() {
        Item temp = first.value;
        first = first.next;
        size--;
        return temp;
    }

    public Item removeLast() {
        Item temp = last.value;
        last = last.prev;
        size--;
        return temp;
    }

    public Iterator<Item> iterator() {
        return new IterableDeque();
    }

    private class IterableDeque implements Iterator<Item> {
        private int itSize = size;
        private Node<Item> nextNode = first;

        @Override
        public boolean hasNext() {
            itSize--;
            return itSize > 0;
        }

        @Override
        public Item next() {
            Item temp = nextNode.value;
            nextNode = nextNode.next;
            return temp;
        }
    }

}
