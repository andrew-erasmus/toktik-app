import java.lang.Math;
public class BinaryTree {
    BinaryTreeNode<User> root;

    public BinaryTree() {
        root = null;
    }

    public int getHeight(){
        return getHeight(root);
    }

    public int getHeight(BinaryTreeNode<User> node){
        if (node == null){
            return -1;
        }else{
            return 1+ Math.max( getHeight(node.getLeft()), getHeight (node.getRight()));
        }
    }

    public int getSize(){
        return getSize(root);
    }

    public int getSize(BinaryTreeNode<User> node){
        if (node == null){
            return 0;
        }else{
            return 1+ getSize(node.getLeft()) + getSize(node.getRight());
        }
    }
}
