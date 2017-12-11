import java.io.*;
import java.net.*;

public class ThreadWriter extends Thread {
    Socket socket;
    public ThreadWriter(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        try{
            BufferedReader bufr =
                    new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufout =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line;
            while((line=bufr.readLine())!=null){
                if("NO".equals(line))
                    break;
               bufout.write(line);
               bufout.newLine();
               bufout.flush();
            }
            socket.close();
            bufr.close();

        }
        catch (Exception e){

        }
    }
}
