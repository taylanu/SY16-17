package ReverseAutoHangman;

public interface Stackable<anyType> {
    void push(anyType x);       //add x to the top of the stack

    anyType pop();              //remove and return the element on the top
    //return null if empty

    anyType peek();              //return the element on the top
    //return null if empty

    boolean isEmpty();          //true if empty, false otherwise

    int size();               //returns the number of elements stored in the stack
}