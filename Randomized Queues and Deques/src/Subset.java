
public class Subset {

    public static void main(String[] args) {
        RandomizedQueue randQueue = new RandomizedQueue();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            randQueue.enqueue(s);
        }

        Integer amount =  Integer.parseInt(args[0]);
        for(int i = 0; i < amount; i++) {
            StdOut.println(randQueue.dequeue());
        }
    }

}
