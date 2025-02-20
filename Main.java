import java.io.*; // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Main {
    public static void main(String[] args){
        System.out.print("a");
        try {
            FileWriter f = new FileWriter("tst.txt");
            f.write("null\n");
            f.append("d");
            f.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        


    }
} 

    



