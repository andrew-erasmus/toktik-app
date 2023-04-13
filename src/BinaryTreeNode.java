// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>
{
   private dataType data;
   private BinaryTreeNode<dataType> left;
   private BinaryTreeNode<dataType> right;
   
   /**
    * Constructor to create a node in the binary tree with data, a link to a left and a right child
    * @param d data to be added to the node of generic type datatype
    * @param l a node that will be a link to the left child
    * @param r a node that will be a link to the right child
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   /**
    * Accessor method to return the left child of the current node
    * @return returns the left child's node
    */
   public BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Accessor method to return the right child of the current node
    * @return returns the right child's node
    */
   public BinaryTreeNode<dataType> getRight () { return right; }

   /**
    * Modifier method to set the left child of the current node to a different value
    * @param l the node to set the left child to
    */
    public void setLeft (BinaryTreeNode<dataType> l) { left=l; }
    /**
     * Modifier method to set the right child of the current node to a different value
     * @param r the node to set the right child to
     */
    public void setRight (BinaryTreeNode<dataType> r) {  right=r; }

   /**
    * Accessor method to return the data of the node
    * @return returns the data of the node with generic type "datatype"
    */
    public dataType getData () { return data; }

    /**
     * Modifier method to set the data of the current node to a different value
     * @param d the data to set the current node's data to
     */
    public void setData (dataType d) {  data=d; }


}
