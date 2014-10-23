import java.util.Iterator;

public class RandomizedQueue<Item> {

    private  final int INITIAL_SIZE = 2;
    private int availableDigits;
    private int currentPosPointer = 0;
    private Item[] itemsHolder;


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
        if (availableDigits == itemsHolder.length) {
            expandArray(itemsHolder.length*2);
        }
        availableDigits++;
        itemsHolder[currentPosPointer++] = item;
    }

    private int getRandomNumber() {
        int position = 0;
        while ( itemsHolder[position] == null ) {
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
        if (availableDigits == itemsHolder.length / 4) {
               squeezeArray(itemsHolder.length / 4);
        }
        availableDigits--;
        int position = getRandomNumber();
        Item temp = itemsHolder[position];
        itemsHolder[position] = null;
        return temp;
    }

    public Item sample() {
        int position = getRandomNumber();
        return itemsHolder[position];
    }

    public Iterator<Item> iterator() {
        return null;
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
            while (itemsHolder[position] == null) {
                position++;
            }
            availableDigitsToIterate--;
            return itemsHolder[position];
        }
    }

}
