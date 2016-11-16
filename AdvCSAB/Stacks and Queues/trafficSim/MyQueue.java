package trafficSim;//d oberle 2005

public class MyQueue<E> implements Queueable<E> {
    private java.util.LinkedList<E> list;

    public MyQueue() {
        list = new java.util.LinkedList<E>();
    }

    public void add(E x) {// adds a value given to the linkedList within the queue.
        list.add(list.size(), x);

    }

    public E remove()//pop?
    {
        return list.remove(0);
        //Return the old value that is removed from the queue.
    }

    public boolean isEmpty() {
//          for (E x: list)
//              if(x.e)
        return list.isEmpty();
    }

    public E peek() {
        return list.peek();
        //return list.get(0);//returns the top value of the queue without removing or modifying the value.
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count = i;
        }
        return count;
    }

    public String toString() {
        return list.toString();
    }

}