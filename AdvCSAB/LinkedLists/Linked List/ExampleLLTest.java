//Write the method detailed below.  
//pre:  h points to the first node of an ordered linked list
//        (ordered from least to greatest)
//post: Comparable item x will be inserted into the linked list such that
//        the list remains in order from least to greatest.  Returns the head of the new list.
//ex.    Given h->[“C”, “F”], insertOrder(h, “D”) will yield h->[“C”, “D”, “F”]
//         Given h->null,           insertOrder(h, “B”) will yield h->[“B”]
//         Given h->[“C”, “F”], insertOrder(h, “A”) will yield h->[“A”, “C”, “F”]
//         Given h->[“C”, “F”], insertOrder(h, “Z”) will yield h->[“C”, “F”, “Z”]


public static ListNode insertOrder(ListNode h, Comparable x){
if(h== null ||  h.compareTo(h.getValue())<0){// if there are currently no items in the list.
h = new ListNode(x,h); //puts the value and sets next to the pointer
return h;
}

ListNode curr = h;
while(curr.getNext() != null){//traverses through entire list
if(x.compareTo(curr.getNext().getValue())<0){
curr.setNext(x,curr.getNext());
return h;
}
else{
curr = curr.getNext();
}
curr.setNext(x,null);//if all else fails, curr is set to 
return curr;
}
}

