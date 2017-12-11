import java.net.*;
import java.util.ArrayList;




class Server {

    public static void main(String[] arg) throws Exception
    {
        ArrayList<Socket> list = new ArrayList<Socket>();
	   ServerSocket server = new ServerSocket(10000);
		while(true) {

            Socket socket = server.accept();
            list.add(socket);
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println(ip+" is connected");
            new ServerThread(socket).start();
        }
    }
    
}
