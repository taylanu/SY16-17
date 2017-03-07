import java.io.*;

public class Tree
{
   private TreeNode myRoot;
   private static int size=0;
   public Tree()
   {
      myRoot = null;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:adds x to the tree such that the tree is still an in-order Binary Search Tree
   public void add(Comparable x)
   {
      myRoot = addHelper(myRoot, x);
   }
   
   private TreeNode addHelper(TreeNode root, Comparable x)
   {
   //************COMPLETE THIS METHOD*****************************
		if (root == null)
			root = new TreeNode(x);
		else{
			if(x.compareTo(root.getValue()) < 0)
				root.setLeft(addHelper(root.getLeft(),x));
			else
				root.setRight(addHelper(root.getRight(),x));
			}
		return root;
      }
   
   //pre: root points to an in-order Binary Search Tree
   //post:removes x from the tree such that the tree is still an in-order Binary Search Tree
   public void remove(Comparable x)
   {
      myRoot = removeHelper(myRoot, x);
   }

   private TreeNode removeHelper(TreeNode root, Comparable x)
   {
   //************COMPLETE THIS METHOD*****************************
if(root==null)
         return null;
      TreeNode d = searchHelper(root,x);
      if(d==null)
         return root;
      size--;
      TreeNode p = searchParent(root,x);
      
      if(isLeaf(d))
      {
         
         if(p==null)
         {
            root=null;
            return null;
         }
         
         if(d==p.getLeft())
            p.setLeft(null);
         else
            p.setRight(null);
         return root;
      }
      else if(oneKid(d))
      {
         if(p==null)
         {
            if(root.getLeft()!=null)
               root=root.getLeft();
            else
               root=root.getRight();
            return root;
         }
         if(p.getLeft()==d)
         {
            if(d.getLeft()!=null)
               p.setLeft(d.getLeft());
            else
               p.setLeft(d.getRight());
            return root;
         }
         if(d.getLeft()!=null)
            p.setRight(d.getLeft());
         else
            p.setRight(d.getRight());
         return root;
      }
      TreeNode m=d.getLeft();
      while(m.getRight()!=null)
      {
         m=m.getRight();
      }
      Comparable temp= m.getValue();
      removeHelper(m,temp);
      d.setValue(temp);
      
      //************************************************************/        
      return root;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in prefix order
   
   public void showPreOrder()
   {
      preOrderHelper(myRoot);
      System.out.println();
   }
   
   private void preOrderHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD*****************************
   if(root!=null){
       System.out.print(root.getValue() + " ");
       preOrderHelper(root.getLeft());
       preOrderHelper(root.getRight());
   }
   //************************************************************  
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in infix order
   public void showInOrder()
   {
      inOrderHelper(myRoot);
      System.out.println();
   }
   
   private void inOrderHelper(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper(root.getLeft());
         System.out.print(root.getValue() + " ");    
         inOrderHelper(root.getRight());
      }
   }
      
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in postfix order
   
   public void showPostOrder()
   {
      postOrderHelper(myRoot);
      System.out.println();
   }
   
   private void postOrderHelper(TreeNode root)
   {
   if(root != null){
       postOrderHelper(root.getLeft());
       postOrderHelper(root.getRight());
       System.out.print(root.getValue()+" ");
    }
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:returns whether or not x is found in the tree
   public boolean contains(Comparable x)
   {
      if (searchHelper(myRoot, x)==null)
         return false;
      return true;
   }
   
   private TreeNode searchHelper(TreeNode root, Comparable x)
   {
//    while(root !=null){
//        Comparable right = root.getRight();
//        if(root.getValue() < right)
//            root = root.getLeft();
//        else if(root.getValue() > right)
//            root = root.getRight();
//    }
      return root;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:returns a reference to the parent of the node that contains x, returns null if no such node exists
   //THIS WILL BE CALLED IN THE METHOD removeRecur
   private TreeNode searchParent(TreeNode root, Comparable x)
   {
   //************COMPLETE THIS METHOD*****************************
   if(root!=null){
         if(root.getValue().equals(x))
            return root;
         if(root.getValue().compareTo(x)>=0)
            return searchHelper(root.getLeft(),x);
         else
            return searchHelper(root.getRight(),x);
      }
   //************************************************************  
      return null;
   }
   
   //post: determines if root is a leaf or not O(1)
   private boolean isLeaf(TreeNode root)
   {
   //************COMPLETE THIS METHOD*****************************
    if(root.getLeft()==null && root.getRight()==null)
        return true;
   //************************************************************  
      return false;
   }
      
   //post: returns true if only one child O(1)
   private boolean oneKid(TreeNode root)
   {
   //************COMPLETE THIS METHOD****************************
   //maybe a logical XOR
   //if(( root.getLeft() || root.getRight() ) && ! ( root.getLeft() && root.getRight() ))
   //     return true;
    if(root.getLeft()!=null && root.getRight()==null)
         return true;
    if(root.getLeft()==null && root.getRight()!=null)
         return true;
   //************************************************************  
      return false;
   }
      
   //pre: root points to an in-order Binary Search Tree
   //post:returns the number of nodes in the tree
   public int size()
   {
      return sizeHelper(myRoot);
   }
   
   private int sizeHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD*****************************
   if (root == null) 
        return 0; 
   else 
    return(sizeHelper(root.getLeft()) + 1 + sizeHelper(root.getRight())); 
   }
         
   public int height()
   {
      return heightHelper(myRoot);
   }

   //pre: root points to an in-order Binary Search Tree
   //post:returns the height (depth) of the tree
   public int heightHelper(TreeNode root){
   //************COMPLETE THIS METHOD*****************************
    if(root == null)
        return  0;      
    return Math.max(heightHelper(root.getLeft()),heightHelper(root.getRight()))+1; 
   }
   
   //EXTRA CREDIT
   //pre: root points to an in-order Binary Search Tree
   //post:returns true if p is an ancestor of c, false otherwise
   
   public boolean isAncestor(TreeNode root, Comparable p, Comparable c){
       //search for parent if contains child.
      return false;
   }
   
   //EXTRA CREDIT
   //pre: root points to an in-order Binary Search Tree
   //post:shows all elements of the tree at a particular depth
   
   public void printLevel(TreeNode root, int level)
   {   }
 
  //Nothing to see here...move along.
   private String temp;
   private void inOrderHelper2(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper2(root.getLeft());
         temp += (root.getValue() + ", "); 
         inOrderHelper2(root.getRight());
      }
   }
   public String toString()
   {
      temp="";
      inOrderHelper2(myRoot);
      if(temp.length() > 1)
         temp = temp.substring(0, temp.length()-2);
      return "[" + temp + "]";
   } 
}