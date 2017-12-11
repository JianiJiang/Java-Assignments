import java.io.*;
import java.net.InetSocketAddress;  
import java.nio.ByteBuffer;  
import java.nio.channels.*; 
import java.util.logging.*; 
public class ThreadReader extends Thread implements Runnable{


    public static SocketChannel sCHANNEL;
    
    public ThreadReader() {    

    }  
    public void init() {  
        try {  
            sCHANNEL = SocketChannel.open();
            sCHANNEL.configureBlocking(false);
            sCHANNEL.connect(new InetSocketAddress(NioClient.SERVER_Addr, 9999));

        } catch (IOException ex) {  
            Logger.getLogger(NioClient.class.getName()).log(Level.SEVERE,  
                    null, ex);  
        }  
    }  
    public void execute() {  

        int num = 0;  
        try {  
            while (!sCHANNEL.finishConnect()) {
            }  
        } catch (IOException ex) {  
            Logger.getLogger(NioClient.class.getName()).log(Level.SEVERE,  
                    null, ex);  
        }  
 
        while (true) {  
            try {  

                ByteBuffer buffer = ByteBuffer.allocate(1024);  
                buffer.clear();  

                StringBuffer stringByte = new StringBuffer();  
             

                while ((num = sCHANNEL.read(buffer)) > 0) {
                    stringByte.append(new String(buffer.array(), 0, num));  
                    buffer.clear();  
                }  
                if (stringByte.length()>0)
                {
                    String rcvCTX = stringByte.toString();
                    String rcvIP = NioClient.getCTX(rcvCTX,"/",")");
                    String localIP =sCHANNEL.getLocalAddress().toString()+")";
                    localIP = NioClient.getCTX(localIP,"/",")");
                    if(rcvIP.equals(localIP))
                    {
                        String endLabel = NioClient.getCTX(rcvCTX,"{","}");

                        if(endLabel.equals("end")){
                            String ctx = NioClient.getCTX(rcvCTX,"[","]");
                            System.out.println(ctx);
                            sCHANNEL.close();
                            sCHANNEL.socket().close();
                            System.exit(0);
                        }
                        else{
                            String ctx = NioClient.getCTX(rcvCTX,"[","]");
                            System.out.println(ctx);
                        }
                    } 
                } 
              
            } catch (IOException ex) {  
                Logger.getLogger(NioClient.class.getName()).log(  
                        Level.SEVERE, null, ex);  
            }  
        }  

    }  

    @Override
    public void run() {  
        
        init();  
        execute();  
    }  
    
}
