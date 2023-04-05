// Stack linked data structure for the user's posts
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
            return "Node: " + p.getTitle();
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

    public void outputPost()
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

    //
    /*public String pop(){
        String rvMsg = "-- Post removed --\n" + head.getPost().getTitle();
        head.setLink(null);
        return rvMsg;
        
    }*/

    //Possibly add a find method to display a post



}