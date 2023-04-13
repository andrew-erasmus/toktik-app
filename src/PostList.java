// Linked list structure to store the all the posts that a user makes
// 2023/04/05
// Andrew Erasmus

public class PostList {
    private Node head;

    /**
     * Inner class to handle the node operations of the linked list.
     * Node contains a Post as the data and another node as the link
     */
    private class Node {
        private Post p;
        private Node link;

        /**
         * Default constructor for a node
         */
        public Node() {
            p = null;
            link = null;
        }

        /**
         * Constructor for a node to add to the linked list
         * @param newPost a post to add to the linked list
         * @param linkValue the link to the next node in the linked list
         */
        public Node(Post newPost, Node linkValue) {
            p = newPost;
            link = linkValue;
        }

        /**
         * Accessor for the post object in the node
         * @return returns the post of the current node
         */
        public Post getPost() {
            return p;
        }

        /**
         * Accessor method to return the next node in the linked list aftern this one
         * @return
         */
        public Node getLink() {
            return link;
        }

        /**
         * Modifier to set the link of a node to a different node
         * @param inNode the node that the current link will be set to
         */
        public void setLink(Node inNode) {
            link = inNode;
        }

        /**
         * To string to print out the post object in the linked list
         */
        public String toString() {
            return p.toString() + "\n";
        }
    }

    /**
     * Default constructor to make an empty linked list
     */
    public PostList() {
        head = null;
    }

    /**
     * Method to add a post to the beginning of the linked list.
     * Will allow posts to be stored in order of recency
     * @param inPost the post to be added to the list
     * @return returns a message to confirm that the post has been added
     */
    public String addToStart(Post inPost) {
        String addMsg = "-- Post Added --\n" + inPost;
        head = new Node(inPost, head);
        return addMsg;

    }

    /**
     * Outputs all the posts in the linked list in the order of the most recent post being displayed first
     */
    public void outputPosts() {
        Node position = head;
        while (position != null) {
            System.out.println(position);
            position = position.getLink();
        }
    }

    /**
     * Method to find the a post in the user's list of post based on the filename.
     * Posts with the same name are different if they have different filenames
     * @param fileName the filename of the post being searched for.
     */
    public void findPost(String fileName){
        Node position = head;
        while (position != null){
            if((!position.getPost().getFName().equals(fileName))){
                System.out.println("\n--Result--\n");
                System.out.println(position.getPost().toString());
                return;
            }
            position = position.getLink();
        }

        System.out.println("\n--Post does not exist--\n");

    }

    // Add method to remove post -- possibly iterator

}

