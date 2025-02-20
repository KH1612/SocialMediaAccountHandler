import java.util.ArrayList;

public class User{
    
    String account;
    String description;
    ArrayList<Post> posts; 
    
    User(String a,String d){
        this.account = a;
        this.description = d;
        posts = new ArrayList<Post>();
    }
    
    /** 
     * @param post
     */
    public void addPost(Post post){
        posts.add(post);

    }
    

    public String showPosts(){
        String line = "";
        if (this.posts.size() == 0)
        {
            line = "This account has no posts \n";
        }
        else
        {
            for (int i = 0; i < this.posts.size();i++){
                line = line + this.posts.get(i).display() + "\n";
            }
        }   
        return line;
    }

    
}