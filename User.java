// Andrew Erasmus
// 11/04/2023
// A class to store a user and all the related information to their account

public class User implements Comparable<User>{
    private String accName;
    private String desc;
    private PostList posts = new PostList();

    /**
     * 
     * @param accName
     * @param desc
     */
    public User(String accName, String desc){
        this.accName = accName;
        this.desc = desc;
    }

    /**
     * 
     * @return
     */
    public String getUsername(){
        return accName;
    }

    /**
     * 
     * @return
     */
    public String getDesc(){
        return desc;
    }

    /**
     * 
     */
    public String toString(){
        return "Account name: "+accName+"\nDescription: "+desc+"\n";
    }

    /**
     * 
     */
    public int compareTo(User other){
        
        return this.accName.compareTo(other.getUsername());
    }

    /**
     * 
     * @param addP
     */
    public void addPost(Post addP){
        posts.addToStart(addP);
    }

    /**
     * 
     */
    public void getPosts(){
        posts.outputPosts();
    }

    
   
}