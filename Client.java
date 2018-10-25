import java.io.*;
import java.net.*;

class Client
{
	public static void main(String[] args)throws Exception
	{
		Socket c = new Socket(InetAddress.getLocalHost(),3210);
		BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
		System.out.println("Message:"+br.readLine());
		c.close();
		br.close();
	}
}