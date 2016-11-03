package ReverseAutoHangman;

import java.util.ArrayList;

/**
 * Created by taylanu on 11/3/2016.
 */
public class MyStack<T> implements Stackable {
    private ArrayList<Object> list = new ArrayList<>();

    @Override
    public void push(Object x) {
        list.add(x);
    }

    @Override
    public Object pop() {
        return list.remove(size() - 1);// returns the last value.
    }

    @Override
    public Object peek() {
        return list.get(size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}
