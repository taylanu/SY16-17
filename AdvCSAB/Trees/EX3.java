public boolean hasOneChild(TreeNode root)
      {
            boolean state = false;
            if (root != null)
                  state = ((root.getLeft()!=null && root.getRight()==null) ||
                        (root.getLeft()==null && root.getRight()!=null));
            return state;
      }

public class TreeNode
{   private Object value;  private TreeNode left, right;
      public TreeNode(Object v)
      { value = v; left = null; right = null; }
      public TreeNode(Object v, TreeNode dl, TreeNode dr)
      { value = v; left = dl; right = dr; }
      public Object getValue()                     public void setValue(Object v)
      { return value; }                                   {  value = v;   }
      public TreeNode getLeft()                  public TreeNode getRight()
      { return left;    }                                    {  return right;    }
      public void setLeft(TreeNode dl)      
      {  right = dr;    }
      public void setRight(TreeNode dr)
      { left = dl;  }                                          
   }

public void changeTree(TreeNode root)
{
if(root==null || (root.getLeft()==null && root.getRight()==null))
return;

if(root.getLeft()!=null && hasOneChild(root.getLeft()){
if(root.getLeft().getLeft != null)

root.setLeft(root.getLeft().getLeft());

else
root.setLeft(root.getLeft().getRight();
}
else if(root.getRight()!=null && hasOneChild(root.getRight()){
if(root.getRight().getLeft() != null)
root.setRight(root.getRight().getLeft());
else
root.setRight(root.getRight().getRight());
}
else{
changeTree(root.getLeft());
changeTree(root.getRight());
}
}
public void numberLeaves (TreeNode root, int nextNum)
{
if(root==null)
return;
if(root.getLeft()==null && root.getRight()==null)
root.setValue(nextNum);
else{
numberLeaves(root.getLeft());
numberLeaves(root.getRight());
}