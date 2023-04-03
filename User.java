
public class User {
    private String accName;
    private String desc;

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

}