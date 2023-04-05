
public class User implements Comparable<User>{
    private String accName;
    private String desc;
    private PostList posts = new PostList();

    public User(String accName, String desc){
        this.accName = accName;
        this.desc = desc;
    }

    public String getUsername(){
        return accName;
    }

    public String getDesc(){
        return desc;
    }

    public String toString(){
        return "Account name: "+accName+"\nDescription: "+desc;
    }

    public int compareTo(User other){
        
        return this.accName.compareTo(other.getUsername());
    }

    public void addPost(Post addP){
        posts.addToStart(addP);
    }

    // add functions for post manipulation
   
}