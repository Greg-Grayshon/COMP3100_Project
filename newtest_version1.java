import java.io.*;
import java.net.*;
import java.util.Scanner;

public class newtest_version1 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 50000);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			dout.write(("HELO\n").getBytes());
			
			String str = (String) in.readLine();
			System.out.println("message= " + str);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please Enter your Username");
			String userN = scan.nextLine();
			
			dout.write(("AUTH" + userN +  "\n").getBytes());
			
			String str2 = (String) in.readLine();
			System.out.println("message= " + str2);
			
			dout.write(("REDY\n").getBytes());
			
			String str3 = (String) in.readLine();
			System.out.println("message= " + str3);
			
			
			
			int Space_Counter = 0;
		
		String Result = "";
		
		
		for(int i = 0;i<str3.length();i++) {
			if(str3.charAt(i) == ' ') {
				Space_Counter ++;
				
			}
			
			if (Space_Counter >= 4){
				
				Result= Result + str3.charAt(i);
						
			}

		}
		
			
			
			
			
			
			
			
			
			
			
			
			dout.write(("GETS Capable" + Result + "\n").getBytes());
			
			String str4 = (String) in.readLine();
			System.out.println("message= " + str4);
			
			
			dout.write(("QUIT\n").getBytes());

			String str5 = (String) in.readLine();
			System.out.println("message= " + str5);
			
			dout.flush();
			dout.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
