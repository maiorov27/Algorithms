import java.util.Iterator;

public class Deque<Item> {

    public Deque() {

    }                       // construct an empty deque

    public boolean isEmpty() {
        return false;
    }                 // is the deque empty?

    public int size() {
        return 0;
    }              // return the number of items on the deque

    public void addFirst(Item item) {

    }          // insert the item at the front

    public void addLast(Item item) {

    }           // insert the item at the end

    public Item removeFirst() {
        return null;
    }                // delete and return the item at the front

    public Item removeLast() {
        return null;
    }                 // delete and return the item at the end

    public Iterator<Item> iterator() {
        return new IterableDeque();
    }         // return an iterator over items in order from front to end

    public static void main(String[] args) {

    }  // unit testing


    private class IterableDeque implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

}
