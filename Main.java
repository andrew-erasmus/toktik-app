public class Main {
    public static void main(String[] args) {
        User andrew = new User("andrewOnTok", "I make fun videos");
        User bella = new User("bellasTok", "I make art videos");
        User hayden = new User("haydennn", "I make car videos");

        BinarySearchTree<User> bst = new BinarySearchTree<User>();

        bst.insert(bella);
        bst.insert(andrew);
        bst.insert(hayden);

        bst.preOrder();
    }
}
