import java.net.*;
import java.io.*;

class Server
{
	public static void main(String args[])throws Exception
	{
		try
		{
			Console in = System.console();
			ServerSocket ss = new ServerSocket(3210);
			Socket con = null;
			
			int[] id = new int[1000];
			System.out.print("Server is ready\n Enter message:");
			String msg = in.readLine();
			String fake = null;
			for(int k = 0;k < msg.length();k++)
			{
				fake = fake + "*";
			}
			System.out.print("Enter number of clients:");
			int n = Integer.parseInt(in.readLine());
			System.out.print("Enter IDs of clients:");
			for(int i = 0;i < n;i++)
			{
				id[i] = Integer.parseInt(in.readLine());
			}
		
			int j = 0;
		
			for(int k = 0;k < 100;k++)
			{
				int flag = 0;
				for(int l = 0;l < n;l++)
				{
					if((k+1) == id[l])
					{
						flag = 1;
					}
				}
				
				con = ss.accept();
				PrintWriter out = new PrintWriter(new OutputStreamWriter(con.getOutputStream()));
			
				if(flag == 1)
				{
					out.println(msg);
				}
				else
				{
					//con = ss.accept();
					out.println(fake);
				}
				out.close();
			}
			ss.close();
			con.close();
			//bf.close();
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
		}
	}
}