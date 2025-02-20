public class Post {
    String title;
    String name;
    String likes; 
    
    public Post(String title, String name, String likes){
        this.title = title;
        this.name = name;
        this.likes = likes; 
    }
    public String display(){
        String line = "Title: " + title + "\n";
        line = line + "Name: " + name + "\n";
        line = line + "Likes: " + likes + "\n"; 
        return line;
    }   
}
