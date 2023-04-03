public class BinaryTreeNode<User> {
    private User userAcc;
    private BinaryTreeNode<User> left;
    private BinaryTreeNode<User> right;

    public BinaryTreeNode(User u, BinaryTreeNode<User> l, BinaryTreeNode<User> r) {
        userAcc = u;
        left = l;
        right = r;
    }

    public BinaryTreeNode<User> getLeft() {
        return left;
    }

    public BinaryTreeNode<User> getRight() {
        return right;
    }

    // check if User is the correct datatype
}
