import java.io.*;
import java.nio.ByteBuffer;  
import java.util.logging.*;  
import java.util.*;

public class ThreadWriter extends Thread implements Runnable{
  
    public ThreadWriter() {  
    }
 
@Override        
    public void run() {  
  Scanner scan = new Scanner(System.in);
   while (true) {  
       try {  
           String st = scan.next();
           st = ThreadReader.sCHANNEL.getLocalAddress().toString()+")"+"["+st+"]";
           ThreadReader.sCHANNEL.write(ByteBuffer.wrap(st.getBytes()));

       } catch (IOException ex) {  
           Logger.getLogger(ThreadWriter.class.getName()).log(  
                   Level.SEVERE, null, ex);  
       }  
   }  

} 
          
}
