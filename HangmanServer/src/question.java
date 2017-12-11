import java.util.*;

class question
{
	
 byte[] c=new byte[40];
 char[] a=new char[20];
 String prt;

    void ques() throws Exception
{
	try{
	int radnum=new Random().nextInt(51527)+1;

		FilereaderDemo ques=new FilereaderDemo(radnum) ;

	String str=ques.question;
	a=str.toCharArray();	
	System.out.println(str);
		for(int x=0;x<str.toCharArray().length;x++)
		{
			int t=2*x;
			c[t]='_';
			c[t+1]=' ';

		}	
	//	prt=new String(c,0,c.length);
		prt = prt.substring(0,c.length);
	}
	catch (Exception e)
	{
		
	}
}



}	

	

