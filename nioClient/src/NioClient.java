import java.util.*;
public class NioClient {  
    
    static String SERVER_Addr;
    
    public static void main(String[] args) {  
        System.out.println("Welcome to HangMan Game! Please enter the server address:");
        Scanner scan = new Scanner(System.in);
        SERVER_Addr = scan.next();
        ThreadReader read = new ThreadReader();
        ThreadWriter write = new ThreadWriter();
        new Thread(read).start(); 
        new Thread(write).start();
    }  
    
    public static String getCTX(String oc,String firstSplit,String secondSplit){
        String rc = oc.substring(oc.lastIndexOf(firstSplit),
        oc.lastIndexOf(secondSplit));
        rc = rc.substring(1,rc.length());
        return rc;
    }
} 
