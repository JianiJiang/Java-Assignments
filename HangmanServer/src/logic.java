
class logic
{
	String outputword=new String();
	int xx=0;
	question QQ=new question();
	byte[] dd;
	logic(byte[] d,question Q,int x)
	{
		byte[] answerf=new byte[Q.a.length];
			if(d.length==Q.a.length)
			{
				String dstr=new String(d,0,d.length);
				String astr=new String(Q.a,0,Q.a.length);
				
				if(dstr.equals(astr))
				{
					outputword="You win!!";
					for(int y=0;y<Q.a.length;y++)
					{
						int t=2*y;
						Q.c[t]=d[y];
					}
					x=Q.a.length;
				}
				else
				{
					outputword="Wrong word.";
				}
		
			}


			if(d.length!=Q.a.length&&d.length!=1)
			{
				outputword="PLEASE! ONE character or ONE whole word!";
			}


				if(d.length==1)
			{	
					int flag=0;		
				for(int y=0;y<Q.a.length;y++)
				{

				


					if(Q.a[y]==d[0])
					{	
						Q.c[2*y]=d[0];
						flag=1;
					}
				}
			
				if(flag==0)
					outputword="Wrong word.";

				else	
				{
					outputword="right!";
					x=x-1;
				}
				
				for(int y=0;y<Q.a.length;y++)
				{
				int t=2*y;
				answerf[y]=Q.c[t];
				}				
				
				String ansstr=new String(answerf,0,answerf.length);
				String questionstr=new String(Q.a,0,Q.a.length);
				if(ansstr.equals(questionstr))
					x=Q.a.length;

			}					
			dd=d;
			QQ=Q;
			xx=x;		

		
	}
}
