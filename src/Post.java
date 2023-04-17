// Andrew Erasmus
// 11/04/2023
// class to handle the post that a user makes to their account on the application

public class Post {
    private String title;
    private String fileName;
    private int numLikes;
    
    /**
     * Constructor to make a post based off the information parsed in
     * @param inTitle The title of the post
     * @param inFileName The filename of the post
     * @param inNumLikes The number of likes that the post has
     */
    public Post(String inTitle, String inFileName, int inNumLikes){
        title = inTitle;
        fileName = inFileName;
        numLikes=inNumLikes;
    }

    /**
     * Method to get the title of the post
     * @return the title string of the post 
     */
    public String getTitle(){
        return title;
    }

    /**
     * Accesses the filename of the post object
     * @return the filename string of the post
     */
    public String getFName(){
        return fileName;
    }

    /**
     * Accesses the number of likes that the post has
     * @return the integer number of likes that a post
     */
    public int getLikes(){
        return numLikes;
    }

    /**
     * Method to compare two post objects to see if they are the same based off of the title and filename
     * The title and filename of the post is unique so can be used to compare the posts
     * @param other the other post object that is being compaired
     * @return returns whether they are the same object or not
     */
    public boolean equals(Post other){

        if((this.title.equals(other.getTitle())) && (this.fileName.equals(other.getFName()))){
            return true;
        }
        return false;

    }

    /**
     * Outputs the Post in a presentable manner
     */
    public String toString(){
        String output="Title: "+title+"\nFile Name: "+fileName+"\nLikes: "+numLikes;
        return output;
    }

    /**
     * Method to update the title of a post that a user chooses
     * @param t
     */
    public void updateTitle(String t){
        title = t;
    }
}
