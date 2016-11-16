//d oberle - 2003 - a linked list object with no lastNode reference
public class cLinkedList<anyType> implements ListInterface<anyType>
{
   private ListNode<anyType> head;			//refers to the first element

   public cLinkedList()						//constructor
   {
      head = null;
   }

//WRITE THIS METHOD***********************************************
//post: adds x to the front of the list
   public void addFirst(anyType x)				
   {
   
   } 
//****************************************************************

//WRITE THIS METHOD***********************************************
//post:  adds x to the end of the list
   public void addLast(anyType x)
   {
   //if list is empty
   //head will also be the last node who's next points to itself
   //else
   //make current go to the last element
   //make the current's next become a new ending node who's next points back to the first
   }
//****************************************************************

//pre:  the head is not null
//post: returns the head's value
   public anyType getFirst() 
   {
      if (head==null)							//if list is empty
         return null;
      return head.getValue();
   }

//pre:  the lastNode is not null
//post: returns the lastNode's value
   public anyType getLast()
   {
      if (head==null)												//if list is empty
         return null;
   
      ListNode<anyType> current = head;
      while(current.getNext()!= head)								//make current go to the last element
         current = current.getNext();
      return current.getValue();
   }

//WRITE THIS METHOD***********************************************
//pre:  the head is not null
//post: removes the first element from the list and returns its value
   public anyType removeFirst()
   {
   
   
      return null;
   }
//****************************************************************

//WRITE THIS METHOD***********************************************
//pre:  the head is not null
//post: removes the last element from the list and returns its value
   public anyType removeLast()
   {
   
   
      return null;
   }
//****************************************************************

 //WRITE THIS METHOD***********************************************
//post: returns the number of elements
   public int size()
   {
   
      return 0;							//temporary code to keep the file compiling
   }
//****************************************************************

//WRITE THIS METHOD***********************************************
//pre: index >=0 and index < size()
//post: returns the object at a specific index (first element is index 0)
   public anyType get(int index)		
   {
   
      return null;						//temporary code to keep the file compiling
   }	
//****************************************************************	

//WRITE THIS METHOD***********************************************
//pre:  index >=0 and index < size()
//post: changes the element at a specific index to x, returning the element that was originally there
   public anyType set(int index, anyType x)
   {
   
      return null;						//temporary code to keep the file compiling
   }	
//****************************************************************

//post: adds element x to the end of the list, returns true if successful
   public boolean add(anyType x)
   {
      addLast(x);
      return true;			
   }	

//WRITE THIS METHOD***********************************************
//pre:  index >=0 and index < size()
//post: adds element x at index i, returns true if successful
   public boolean add(int index, anyType x)
   {
   
      return true;			
   }	
//****************************************************************

//WRITE THIS METHOD***********************************************
//pre: index >=0 and index < size()
//post: removes and returns the object at a specific index (first element is index 0)
   public anyType remove(int index)		
   {
   
      return null;						//temporary code to keep the file compiling
   }	
//****************************************************************	


//pre:  the head is not null
//post: shows all elements of the list O(n)
   public void showList()
   {
      if (head==null)						//if list is empty
         System.out.println("List is empty");
      else
      {
         ListNode<anyType> current =  head;
         while(current.getNext() != head)
         {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
         }	
         System.out.println(current.getValue());
         System.out.println("And here is the last element's next: " + current.getNext().getValue());
      
      }
   
   }

//pre:
//post:  returns the contents of the list as a String in the form of [a1, a2, a3,...,an] where a1 is the first element and an is the last
   public String toString()
   {
      return null;
   }

   public boolean isEmpty()
   {
      if (head == null)
         return true;
      return false;
   }

}