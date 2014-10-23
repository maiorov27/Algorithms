import java.util.Iterator;

public class RandomizedQueue<Item> {

    private  final int INITIAL_SIZE = 10;
    private int size;
    private int currentPosPointer = 0;
    private Item[] itemsHolder;


    public RandomizedQueue() {
        itemsHolder = (Item[]) new Object[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (size == itemsHolder.length) {
            expandArray(itemsHolder);
        }
        size++;
        itemsHolder[currentPosPointer++] = item;
    }

    private int getRandomNumber() {
        int position = 0;
        while ( itemsHolder[position] == null ) {
            position = StdRandom.uniform(size);
        }
        return position;
    }

    private void expandArray(Item[] itemsHolder) {
        int size = itemsHolder.length*2;
        copyArray(itemsHolder, size);
    }

    private void copyArray(Item[] itemsHolder, int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < itemsHolder.length; i++){
            if (itemsHolder[i] != null) {
                temp[i] = itemsHolder[i];
            }
        }
        itemsHolder = temp;
    }

    private void squeezeArray(Item[] itemsHolder) {
        int size = itemsHolder.length / 4;
        copyArray(itemsHolder, size);
    }


    public Item dequeue() {
        if (size == itemsHolder.length / 4) {
               squeezeArray(itemsHolder);
        }
        size--;
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

}
