import java.io.*;

public class TreeDriver2
{
   public static void extraInfo(Tree t)
   {
      System.out.print("There are " + t.size() + " nodes, ");
      System.out.println("the tree is of height " + t.height());
   }

   public static void main(String[] arg) throws IOException
   {
      Tree t = new Tree();
      System.out.println(t);  //should be: [] (GOOD)
      t.add("R");
      t.add("S");
      t.add("W");
      t.add("A");
      t.add("T");
      t.add("Y");
      t.add("B");
      t.add("D");
      System.out.println(t);  //should be: [A, B, D, R, S, T, W, Y] (GOOD)
      t.showPreOrder();       //should be: R A B D S W T Y (GOOD)
      t.showInOrder();        //should be: A B D R S T W Y (GOOD) 
      t.showPostOrder();      //should be: D B A T Y W S R (GOOD)
      extraInfo(t);           //should be: There are 8 nodes, the tree is of height 3 (GOOD)
      System.out.println();
      //WORKING UP TO THIS POINT.
      
      t.remove("Y");
      t.remove("A");
      t.remove("Z"); //yes, we will try to remove what is not there
      t.showPreOrder();       //should be: R B D S W T
      t.showInOrder();        //should be: B D R S T W
      t.showPostOrder();      //should be: D B T W S R
      extraInfo(t);           //should be: There are 6 nodes, the tree is of height 3
      System.out.println(t);  //should be: [B, D, R, S, T, W]
   }

}
