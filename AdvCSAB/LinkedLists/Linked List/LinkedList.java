//d oberle - 2014 - a linked list object

public class LinkedList<anyType> implements ListInterface<anyType>
{
   private ListNode<anyType> head;		//refers to the first element

   public LinkedList()						//constructor
   {
      head = null;
   }

//WRITE THIS METHOD***********************************************
//post:  returns true of the list is empty
   public boolean isEmpty()
   {
      if(head == null)   
         return true;
      return false;							//temporary code to keep the file compiling
   }
//****************************************************************


//WRITE THIS METHOD***********************************************
//post: adds x to the front of the list
   public void addFirst(anyType x)				
   {
      head = new ListNode<anyType>(x,head);
   }
//****************************************************************

//post:  adds x to the end of the list, O(n)
   public void addLast(anyType x)
   {
      if (head==null)										//if list is empty
         head = new ListNode(x,null);					//head refers to the only node
      else
      {
         ListNode current = head;
         while(current.getNext()!= null)				//make current go to the last element
            current = current.getNext();
         current.setNext(new ListNode(x, null));	//make the last element's next become a new ending node
      }
   }

//pre:  the head is not null
//post: returns the head's value - returns null if the pre-condition fails, O(1)
   public anyType getFirst()
   {
      if (head==null)							//if list is empty
         return null;							//this is our flag for an unsuccessful add
      return head.getValue();
   }

//WRITE THIS METHOD***********************************************
//pre:  the list is not empty
//post: returns the lastNode's value - returns null if the pre-conditon fails
   public anyType getLast()
   {
   
      if(head==null){
         return null;
      }   
      if (head.getNext() == null)							//only one element in the list
         head = null;
      ListNode<anyType> curr = head;
      while(curr.getNext() != null){
         curr = curr.getNext();
      }
      return curr.getValue();						//temporary code to keep the file compiling
   }
//****************************************************************


//WRITE THIS METHOD***********************************************
//pre:  the head is not null
//post: removes the first element from the list and returns its value
//      returns null if the pre-condition fails
   public anyType removeFirst() 
   {
      if(head==null)
         return null;
      ListNode<anyType> temp = head;
      head = head.getNext();
      return temp.getValue(); //returns previous value of first	//temporary code to keep the file compiling
   }
//****************************************************************

//pre:  the head is not null
//post: removes the last element from the list and returns its value, O(n) 
//      returns null if the pre-condition fails
   public anyType removeLast()
   {
      if (head==null)											//if list is empty
         return null;
      anyType temp = getLast();
      if (head.getNext() == null)							//only one element in the list
         head = null;
      else
      {
         ListNode current = head;							//current will traverse the list
         while(current.getNext().getNext() != null)	//move current to the second to last node
            current=current.getNext();
         current.setNext(null);								//then cap off the end of the new, smaller list with null
      }	
      return temp;
   }

//WRITE THIS METHOD***********************************************
//post: returns the number of elements
   public int size()
   {
      ListNode<anyType> tmp = head;
      int count = 0;
      while(tmp != null){ tmp = tmp.getNext(); count++;};
      return count;							//temporary code to keep the file compiling
   }
//****************************************************************

//WRITE THIS METHOD***********************************************
//pre: index >=0 and index < size()
//post: returns the object at a specific index (first element is index 0)
   public anyType get(int index)		
   {
      if(index<=0 && index>size()){
         return null;
      }
      int count = 0;
      ListNode<anyType> curr = head;
      while(curr != null){
      
         if(count==index){
            return curr.getValue();
         }
         count++;
         curr = curr.getNext();
      }
   
      return null;						//temporary code to keep the file compiling
   }	
//****************************************************************	

//WRITE THIS METHOD***********************************************
//pre:  index >=0 and index < size()
//post: changes the element at a specific index to x, returning the element that was originally there
   public anyType set(int index, anyType x)
   {
      if(index<=0 && index>size()){
         return null;
      }
      int count = 0;
      ListNode<anyType> curr = head;
      while(curr.getNext() != null){
      
         if(count==index){
            anyType temp = curr.getValue();
            curr.setValue(x);
            return temp;
         }
         count++;
         curr = curr.getNext();
      }
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
      if(index<=0 && index>size()){
         return false;
      }
      int count = 0;
      ListNode<anyType> curr = head;
      while(curr.getNext() != null){
      
         if(count==index){
            curr.setNext(new ListNode<anyType>(x,curr.getNext()));
            return true;
         }
         count++;
         curr = curr.getNext();
      }
      return true;			
   }	
//****************************************************************

//WRITE THIS METHOD***********************************************
//pre: index >=0 and index < size()
//post: removes and returns the object at a specific index (first element is index 0)
   public anyType remove(int index)		
   {
      if(head==null)//first check
         return null;
      int count = 0;
      ListNode<anyType> curr = head;
      anyType temp = null;
      while(curr.getNext() != null){
         if(count == index)
         temp = curr.getValue();
            curr = curr.getNext();
         break;   
      }
      ListNode<anyType> temp = head;
      head = head.getNext();
      return temp;
   }	
//****************************************************************	

//post: returns all elements of the list as a String 
//in the form [a0, a1, a2, . . . , an-1],  O(n)
   public String toString()
   {
      String ans = "[";									//start with left bookend						
      ListNode current =  head;
      while(current != null)
      {
         ans += current.getValue().toString();
         current = current.getNext();
         if (current != null)							//don't add comma after the last element
            ans += ",";
      }
      ans += "]";											//end with right bookend
      return ans;
   }
}