// Binary Search tree based on the work of Hussein Suleman's Binary Tree which was modified for this application's use. 
// 10/04/2023
// Andrew Erasmus


public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**
    * Constructor to make an empty binary tree
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   // /**
   //  * 
   //  * @return
   //  */
   // public int getHeight ()
   // {
   //    return getHeight (root);
   // }  
   // /**
   //  * 
   //  * @param node
   //  * @return
   //  */ 
   // public int getHeight ( BinaryTreeNode<dataType> node )
   // {
   //    if (node == null)
   //       return -1;
   //    else
   //       return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   // }


   /**
    * Accessor method that will get the size of the binary tree.
    * This happens when the method is first called for the root node.
    * @return returns the number of nodes in the tree by calling the overriden method
    */
   public int getSize ()
   {
      return getSize (root);
   }   

   /**
    * Recursive method that will get the size of the binary tree
    * @param node the node that is passed so that the number of nodes below it can be calculated
    * @return returns the number of nodes in the tree by counting the current node and calling the method recursively to count all other nodes
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   /**
    * Method to print out the current node.
    * @param node the node that will be printed out
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.getData());
   }
   /**
    * Method that will allow the nodes to be printed out in alphabetical order with in order traversal.
    * This default method will call the overriden inOrder method to start traversing at the root node
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * Method that will allow the nodes to be printed out in alphabetical order with in order traversal.
    * @param node the current node being operated on to print its left child, the node itself, then its right child. This happens recursively to print all the children's children as well.
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
  
}
