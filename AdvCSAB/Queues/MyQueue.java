  //d oberle 2005
  
    public class MyQueue<E> implements Queueable<E>
   {
      private java.util.LinkedList<E> list;
   
       public MyQueue()
      {
         list = new java.util.LinkedList<E>();
      }
   
       public void add(E x)
      {

      }
   
       public E remove()
      {
         return null;
          //Return the old value that is removed from the queue.
      }
   
       public boolean isEmpty()
      {
         return false;
      }
   
       public E peek()
      {
          return null;//rerurns the top value of the queue without removing or modifying the value.
      }
   
       public int size()
      {
         return -1;
      }
   
       public String toString()
      {
         return list.toString();
      }
   
   }