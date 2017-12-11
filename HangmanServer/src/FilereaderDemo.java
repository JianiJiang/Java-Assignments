import java.io.*;

class FilereaderDemo
{
	String question=new String();

		FileReader fr = new FileReader("/Users/nicole/IdeaProjects/HangmanServer/words.txt");


	FilereaderDemo(int n) throws Exception	
	{

		char[] buf=new char[65535];
		int num=0;
		String ss=new String();
		while((num=fr.read(buf))!=-1)
		{
			ss=ss+new String(buf,0,num);
		}
	
		String[] lib=ss.split("\n");
		
		question=lib[n];

	}

}