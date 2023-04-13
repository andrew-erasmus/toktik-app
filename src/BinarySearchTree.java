// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
    * Method to insert a node into the binary tree in the correct position.
    * If there are no nodes in the tree, add this node as root, if not, run overriden method.
    * @param d the datatype of the node that will be added to the tree.
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**
    * Overriden insert method that is recursive to add a datatype at the correct leaf in the tree.
    * @param d the datatype to be inserted into the tree
    * @param node the current node being checked to see where to add the datatype
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.getData()) <= 0)
      {
         if (node.getLeft() == null)
            node.setLeft(new BinaryTreeNode<dataType> (d, null, null));
         else
            insert (d, node.getLeft());
      }
      else
      {
         if (node.getRight() == null)
            node.setRight(new BinaryTreeNode<dataType> (d, null, null));
         else
            insert (d, node.getRight());
      }
   }
   /**
    * Method to find a node in the tree. If there are no nodes in the tree, return null. If there are, run overriden find method.
    * @param d the datatype being searched for in the tree
    * @return returns the result of the find method. If the datatype/node is found or not.
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
    * Method to find a node in the tree. Done recursively until the node is found or until a leaf is reached
    * @param d the datatype being searhed for
    * @param node the current node being compared to see if found
    * @return returns the node if found or null if not found.
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.getData()) == 0) 
         return node;
      else if (d.compareTo (node.getData()) < 0)
         return (node.getLeft() == null) ? null : find (d, node.getLeft());
      else
         return (node.getRight() == null) ? null : find (d, node.getRight());
   }
   /**
    * Method to delete a node from the tree based on the datatype d.
    * This method is used to call the delete method starting at the root of the tree
    * @param d the datatype used to identify the node to delete
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }
   /**
    * Method to delete a node from the tree based on the datatype d.
    * @param d the datatype used to identify the node to delete
    * @param node the current node being compared for deletion
    * @return returns the result of the deletion by returning null if not found or return the node being deleted.
    */   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.getData()) < 0)
         node.setLeft(delete (d, node.getLeft()));
      else if (d.compareTo (node.getData()) > 0)
         node.setRight(delete (d, node.getLeft()));
      else if (node.getLeft() != null && node.getRight() != null )
      {
         node.setData(findMin (node.getRight()).getData());
         node.setRight(removeMin (node.getRight()));
      }
      else
         if (node.getLeft() != null)
            node = node.getLeft();
         else
            node = node.getRight();
      return node;
   }
   /**
    * Method to find the minimum node in a subtree
    * @param node the node that is used as the root of the subtree to find the smallest node below it
    * @return returns the minimum node in the tree
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.getLeft() != null)
            node = node.getLeft();
      return node;
   }
   /**
    * Method to remove the min node from the tree
    * @param node the current node being used to recursivly traverse the tree.
    * @return returns the node that is being removed
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.getLeft() != null)
      {
         node.setLeft(removeMin (node.getLeft()));
         return node;
      }
      else
         return node.getRight();
   }
}
