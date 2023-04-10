// Linked list structure for the user's posts
// 2023/04/05
// Andrew Erasmus

public class PostList{
    private Node head;

    private class Node {
        private Post p;
        private Node link;
    
        public Node() {
            p = null;
            link = null;
        }
    
        public Node(Post newPost, Node linkValue) {
            p = newPost;
            link = linkValue;
        }
    
        public Post getPost() {
            return p;
        }
    
        public Node getLink() {
            return link;
        }
    
        public void setLink(Node inNode){
            link = inNode;
        }
    
        public String toString() {
            return p.toString()+"\n";
        }
    }
    public PostList(){
        head = null;
    }

    public String addToStart(Post inPost){
        String addMsg = "-- Post Added --\n"+inPost;
        head = new Node(inPost, head);
        return addMsg;

    }

    public void outputPosts()
   {
      Node position = head;
      while (position != null)
      {
         System.out.println(position);
         position = position.getLink();
      }
   }

   // Add functionality to find a post with a specific title 
   // Add method to remove post based on title and filename (can have the same title)

    //Possibly add a find method to display a post



}