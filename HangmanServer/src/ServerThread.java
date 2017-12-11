import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import java.lang.*;

public class ServerThread extends Thread{
    
    Socket socket;
    public ServerThread(Socket socket)
	{
        this.socket = socket;
    }
    @Override
	
    public void run()
    {
        try{

			int score = 0;
            BufferedReader bufin =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufout =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true)
            {
                String num2 = String.valueOf(score);
                String sc = "Your Score :" + num2+"  "+"Do you want to start playing? (YES or NO)";


                bufout.write(sc);
                bufout.newLine();
                bufout.flush();

                String line = bufin.readLine();
                String ip = socket.getInetAddress().getHostAddress();

                if ("NO".equals(line))
                    break;
                else if("YES".equals(line)){
                    question Q = new question();
                    Q.ques();

                    String prt = Q.prt;

                    byte[] answerf = new byte[Q.a.length];

                    String num1 = String.valueOf(Q.a.length);
                    String st = "Your left chance(s): ";
                    String ot = st + num1+": ";
                    ot=ot+prt;


                        bufout.write(ot);
                        bufout.newLine();
                        bufout.flush();

                    for (int x = 0; x < Q.a.length; x++) {

                        String str = bufin.readLine();

                        byte[] d = str.getBytes();

                        logic L = new logic(d,Q,x);

                        x = L.xx;
                        Q = L.QQ;
						prt=new String(Q.c,0,Q.c.length);
						
						if(x==Q.a.length)
						{
							ot=L.outputword+" your answer: "+prt;
							bufout.write(ot);
							bufout.newLine();
							bufout.flush();							
						}
						else
						{
							num1 = String.valueOf(Q.a.length-x-1);
							st = "Your left chance(s): ";
							ot = st + num1+"   ";
							ot=L.outputword+ot+"  "+prt;
							bufout.write(ot);
							bufout.newLine();
							bufout.flush();
						}


                    }
                    for (int x = 0; x < Q.a.length; x++) {
                        int t = 2 * x;
                        answerf[x] = Q.c[t];
                    }	
                    String ansstr = new String(answerf, 0, answerf.length);
                    String questionstr = new String(Q.a, 0, Q.a.length);
					

                    if (ansstr.equals(questionstr))
                    {
                        System.out.println(ip+":"+ansstr);
                        score = score + 1;
                    }
					else
					{
						score=score-1;
					}
                }

            }
            socket.close();
        }
        catch (Exception e)
        {

        }
    }
}