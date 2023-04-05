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

    public boolean equals(Post other){

        if((this.title.equals(other.getTitle())) && (this.fileName.equals(other.getFName())) && (this.numLikes == (other.getLikes())) ){
            return true;
        }
        return false;

    }

    public String toString(){
        String output="Title: "+title+"\nFile Name: "+fileName+"\nLikes: "+numLikes;
        return output;
    }
}
