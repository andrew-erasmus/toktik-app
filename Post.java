// Andrew Erasmus
// 11/04/2023
// class to handle the post that a user makes to their account on the application

public class Post {
    private String title;
    private String fileName;
    private int numLikes;
    
    /**
     * 
     * @param inTitle
     * @param inFileName
     * @param inNumLikes
     */
    public Post(String inTitle, String inFileName, int inNumLikes){
        title = inTitle;
        fileName = inFileName;
        numLikes=inNumLikes;
    }

    /**
     * 
     * @return
     */
    public String getTitle(){
        return title;
    }

    /**
     * 
     * @return
     */
    public String getFName(){
        return fileName;
    }

    /**
     * 
     * @return
     */
    public int getLikes(){
        return numLikes;
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean equals(Post other){

        if((this.title.equals(other.getTitle())) && (this.fileName.equals(other.getFName())) && (this.numLikes == (other.getLikes())) ){
            return true;
        }
        return false;

    }

    /**
     * 
     */
    public String toString(){
        String output="Title: "+title+"\nFile Name: "+fileName+"\nLikes: "+numLikes;
        return output;
    }
}
