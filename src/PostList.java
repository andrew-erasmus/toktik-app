// Linked list structure to store the all the posts that a user makes
// 2023/04/05
// Andrew Erasmus

public class PostList {
    private Node head;

    /**
     * Inner class
     */
    private class Node {
        private Post p;
        private Node link;

        /**
         * 
         */
        public Node() {
            p = null;
            link = null;
        }

        /**
         * 
         * @param newPost
         * @param linkValue
         */
        public Node(Post newPost, Node linkValue) {
            p = newPost;
            link = linkValue;
        }

        /**
         * 
         * @return
         */
        public Post getPost() {
            return p;
        }

        /**
         * 
         * @return
         */
        public Node getLink() {
            return link;
        }

        /**
         * 
         * @param inNode
         */
        public void setLink(Node inNode) {
            link = inNode;
        }

        /**
         * 
         */
        public String toString() {
            return p.toString() + "\n";
        }
    }

    /**
     * 
     */
    public PostList() {
        head = null;
    }

    /**
     * 
     * @param inPost
     * @return
     */
    public String addToStart(Post inPost) {
        String addMsg = "-- Post Added --\n" + inPost;
        head = new Node(inPost, head);
        return addMsg;

    }

    /**
     * 
     */
    public void outputPosts() {
        Node position = head;
        while (position != null) {
            System.out.println(position);
            position = position.getLink();
        }
    }

    public void findPost(String title, String fileName){
        Node position = head;
        while (position != null){
            if((position.getPost().getTitle().equals(title)) && (!position.getPost().getFName().equals(fileName))){
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

