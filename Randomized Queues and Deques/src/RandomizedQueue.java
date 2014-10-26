import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private final int INITIAL_SIZE = 2;
    private int availableDigits;
    private Item[] itemsHolder;
    private int position;

    public RandomizedQueue() {
        itemsHolder = (Item[]) new Object[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return availableDigits == 0;
    }

    public int size() {
        return availableDigits;
    }

    public void enqueue(Item item) {
        throwExceptionIfNull(item);
        if (availableDigits == itemsHolder.length) {
            expandArray(itemsHolder.length * 2);
        }
        availableDigits++;
        int position = findPositionToInsertNewValue();
        itemsHolder[position] = item;
    }

    private Integer findPositionToInsertNewValue() {
        if (position < itemsHolder.length -1){
            position++;
            return position;
        }
        int position = -1;
        for (int i = 0; i < itemsHolder.length; i++) {
            if (itemsHolder[i] == null) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            expandArray(itemsHolder.length * 2);
        }
        return position;
    }

    private void throwExceptionIfNull(Item item) {
        if (item == null)
            throw new NullPointerException();
    }

    private int getRandomNumber() {
        int position = 0;
        position = StdRandom.uniform(itemsHolder.length);
        while (itemsHolder[position] == null) {
            position = StdRandom.uniform(itemsHolder.length);
        }
        return position;
    }

    private void expandArray(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < itemsHolder.length; i++) {
            temp[i] = itemsHolder[i];
        }
        itemsHolder = temp;
    }

    private void squeezeArray(int capacity) {
        int pointer = 0;
        Item[] temp = (Item[]) new Object[availableDigits];
        for (int i = 0; i < itemsHolder.length; i++) {
            if (itemsHolder[i] != null) {
                temp[pointer++] = itemsHolder[i];
            }
        }
        itemsHolder = temp;
    }

    public Item dequeue() {
        throwExceptionIfQueueIsEmpty();
        if (availableDigits == itemsHolder.length / 4) {
            squeezeArray(itemsHolder.length / 4);
        }
        availableDigits--;
        int position = getRandomNumber();
        Item temp = itemsHolder[position];
        itemsHolder[position] = null;
        return temp;
    }

    private void throwExceptionIfQueueIsEmpty() {
        if (isEmpty())
            throw new NoSuchElementException();
    }

    public Item sample() {
        throwExceptionIfQueueIsEmpty();
        int position = getRandomNumber();
        return itemsHolder[position];
    }

    public Iterator<Item> iterator() {
        return new RandQueueIterator();
    }

    private class RandQueueIterator implements Iterator<Item> {

        int availableDigitsToIterate = availableDigits;
        int position = 0;

        @Override
        public boolean hasNext() {
            return availableDigitsToIterate > 0;
        }

        @Override
        public Item next() {
            throwExceptionIfItWasLastElement();
            int position = getRandomNumber();
            availableDigitsToIterate--;
            return itemsHolder[position];
        }

        private void throwExceptionIfItWasLastElement() {
            if (hasNext() == false)
                throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
