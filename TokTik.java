import java.io.*;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class TokTik {
    public static void main(String[] args) throws FileNotFoundException{
        BinaryTree TokTik = new BinaryTree();
        TokTik.addNode(new User("TokTik", "The official acount of TokTik"));
        Scanner userInput = new Scanner(System.in);
        
        
        while(true){
            post(); 
            String choice = userInput.nextLine();
                if (choice.equals("1"))
                {
                    System.out.print("Enter name of account: ");
                    String name = userInput.nextLine();
                    if (TokTik.findNode(name)==null)
                    {
                        System.out.println("Account not found");
                        pause();
                    }
                    else
                    {
                        System.out.print(TokTik.findNode(name));
                        promptEnterKey();
                    }
     
                }
                else if (choice.equals("2"))
                {
                    TokTik.inOrderTraverseTree(TokTik.root);
                    promptEnterKey();
                }
                else if (choice.equals("3"))
                {
                    System.out.print("Enter name of account to be added: ");
                    String name = userInput.nextLine();
                    System.out.print("Enter description of account to be added: ");
                    String description = userInput.nextLine();
                    Boolean found = TokTik.addNode(new User(name, description));
                    if (found)
                    {System.out.print("Account already exists, try another account name");}  
                    else
                    {System.out.print(name + " has been created");}
                    pause();
                }
                else if (choice.equals("4"))
                {
                    System.out.print("Enter name of account to be deleted: ");
                    String name = userInput.nextLine();
                    Boolean removed = TokTik.remove(name);
                    if(removed)
                    {System.out.println(name + "has been removed");}
                    else
                    {System.out.println("Account not found");}

                    pause();
                                   
                }
                else if (choice.equals("5"))
                {
                    System.out.print("Enter name of account: ");
                    String name = userInput.nextLine(); 
                    Node focusNode = TokTik.findNode(name);
                    if (focusNode ==null)
                    {
                        System.out.print("Account not found");
                        pause();
                    }
                    else
                    {
                        System.out.print(focusNode.user.showPosts());
                        promptEnterKey(); 
                    } 
                }
                else if (choice.equals("6"))
                {
                    System.out.print("Enter name of account: ");
                    String name = userInput.nextLine(); 
                    Node focusNode = TokTik.findNode(name);
                    if (focusNode ==null)
                    {
                        System.out.print("Account not found");
                        pause();
                    }
                    else
                    {
                        System.out.print("Enter the title of the video: ");
                        String title = userInput.nextLine();
                        System.out.print("Enter the filename of the video: ");
                        String filename = userInput.nextLine();
                        System.out.print("Enter the number of likes that the video has: ");
                        String likes = userInput.nextLine();
                        focusNode.user.addPost(new Post(title,filename,likes));
                        TokTik.remove(name);
                        TokTik.addNode(focusNode.user);
                        

                    }      
                }
                else if (choice.equals("7"))
                {
                    System.out.print("Enter filename to process: ");
                    String path = userInput.nextLine();
                    File dataset = new File(path);
                    try {
                        Scanner fileRead = new Scanner(dataset);
                    } catch (Exception e) {
                        System.out.println("File not found");
                        continue;
                    }
                    Scanner fileRead = new Scanner(dataset);
                    while(fileRead.hasNextLine()){
                        String line = fileRead.nextLine(); 
                        if (line.charAt(0) == 'C'){
                            int space1 = line.indexOf(" ");
                            int space2 = line.indexOf(" ",space1 + 1);
                    
                            String account = line.substring(space1+1, space2);
                            String description = line.substring(space2 + 1);
            
                            TokTik.addNode(new User(account, description));
                        }
                        else 
                        {
                            int space1 = line.indexOf(" ");
                            int space2 = line.indexOf(" ",space1 + 1);
                            int space3 = line.indexOf(" ",space2 + 1);
                            int space4 = line.indexOf(" ", space3 + 1);
            
                            String account = line.substring(space1 +1, space2);
                            String name = line.substring(space2 +1 ,space3);
                            String likes = line.substring(space3 +1 ,space4);
                            String title = line.substring(space4 +1); 
                            Node focusNode = TokTik.findNode(account);
                            focusNode.user.addPost(new Post(title,name,likes));
                            TokTik.remove(account);
                            TokTik.addNode(focusNode.user);
                        }
                        
                    } 
                    fileRead.close();   
                }
                else if (choice.equals("8"))
                {
                    break;
                }
                
        }
        
        userInput.close();
        
        
    }


public static void post(){
    String menu = "Choose an action from the menu: \n";
    menu = menu + "1. Find the profile description for a given account \n";
    menu = menu + "2. List all accounts \n";
    menu = menu + "3. Create an account \n";
    menu = menu + "4. Delete an account \n";
    menu = menu + "5. Display all posts for a single account \n";
    menu = menu + "6. Add a new post for an account \n";
    menu = menu + "7. Load a file of actions from disk and process this \n";
    menu = menu + "8. Quit \n";
    System.out.print(menu);
} 
public static void pause(){
    try {
        Thread.sleep(2000);
        } 
    catch(InterruptedException e) 
        {
        System.out.println("got interrupted!");
        }

    }

public static void promptEnterKey(){
        System.out.println("Press ENTER to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 

