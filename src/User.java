// Andrew Erasmus
// 11/04/2023
// A class to store a user and all the related information to their account

public class User implements Comparable<User>{
    private String accName;
    private String desc;
    private PostList posts = new PostList();

    /**
     * Constructor for the User object
     * @param accName the name of the user's account to be added
     * @param desc decription of the user's account
     */
    public User(String accName, String desc){
        this.accName = accName;
        this.desc = desc;
    }

    /**
     * Accessor method for the username
     * @return returns the account name
     */
    public String getUsername(){
        return accName;
    }

    /**
     * Accessor method for the user's account description
     * @return returns the account name
     */
    public String getDesc(){
        return desc;
    }

    /**
     * To string method that outputs the User account with the format
     * Account name: ***
     * Description: ***
     */
    public String toString(){
        return "Account name: "+accName+"\nDescription: "+desc+"\n";
    }

    /**
     * Overridden compareTo method that compares user objects.
     * Checks if the users have the same name to see if they are the same object
     */
    @Override
    public int compareTo(User other){
        
        return this.accName.compareTo(other.getUsername());
    }

    /**
     * Adds a post object to the list of the user's posts.
     * Adds this to the start of the list.
     * @param addP
     */
    public void addPost(Post addP){
        posts.addToStart(addP);
    }

    /**
     * Prints out the list of user's posts in the order of the most recent post first.
     */
    public void getPosts(){
        posts.outputPosts();
    }

    public void findPost(){

    }

    public void deletePost(){
        
    }
    
   
}