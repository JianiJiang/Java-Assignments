import java.net.*;

class Test
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("130.229.171.172",10000);

       new ThreadWriter(socket).start();
       new ThreadReader(socket).start();

    }
    
}
