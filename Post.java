public class Post {
    private String title;
    private String fileName;
    private int numLikes;
    
    public Post(String inTitle, String inFileName, int inNumLikes){
        title = inTitle;
        fileName = inFileName;
        numLikes=inNumLikes;
    }

    public String getTitle(){
        return title;
    }

    public String getFName(){
        return fileName;
    }

    public int getLikes(){
        return numLikes;
    }

    public String toString(){
        String output="Title: "+title+"\nFile Name: "+fileName+"\nLikes: "+numLikes;
        return output;
    }
}
