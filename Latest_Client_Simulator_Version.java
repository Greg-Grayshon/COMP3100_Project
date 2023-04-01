import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Arrays;
public class MAIN_VERSION_4 {







static int serverID (String MT, String Word){
	
	String a[] = MT.split(" ");
	
	
	int Counter = 0;
	
			for(int m = 0;m<a.length;m++) {
			
			if(Word.equals(a[m])) {
				Counter++;
				
			}
			}
			
			return Counter;

			
	}








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
			
			
			
Space_Counter = 0;
	
	String Result2 = "";
	
	
	for(int i = 0;i<str4.length();i++) {
		if(str4.charAt(i) == ' ') {
			Space_Counter ++;
			
		}
		
		if (Space_Counter == 1){
			
			Result2= Result2 + str4.charAt(i);
			
			
					
		}

	}
			

		Result2=Result2.replaceFirst(" ", "");
					

			
			Integer.parseInt(Result2);
			
			
			
			
			
			dout.write(("OK\n").getBytes());
			String str5 = (String) in.readLine();
			System.out.println("message= " + str5);
			
			
int nRecs;
		try {
		   nRecs= Integer.valueOf(Result2);
		}
		catch (NumberFormatException e) {
		   nRecs = 0;
		}	
	

int Original_Count = 0;	

String ServerType = "";

int BIG_Server_count = 0;
	
String Repeat = "";	

String ServerID1 = "";

int listNum = 0;

String MT = "";


String [] Server_IDS = new String[100000000];

	
	for(int i =0; i<nRecs;i++)
{


int Main_Counter = 0;

int Server_Count = 0;

String CoreCount = "";



			dout.write(("OK\n").getBytes());
			String str9 = (String) in.readLine();
			System.out.println("message= " + str9);
			
			
			MT = MT +  str9;
			

		for(int j = 0;j<str9.length();j++) {
			if(str9.charAt(j) == ' ') {
				Main_Counter ++;
				
			}
			
			if(Main_Counter == 4){
			
			
			
			CoreCount = CoreCount+str9.charAt(j);
			
			
			}


CoreCount=CoreCount.replaceFirst(" ", "");




int hello;

try {

hello = Integer.parseInt(CoreCount);
}

catch (NumberFormatException e) {

hello =0;

}


if(hello >= Original_Count){


Original_Count = hello;

BIG_Server_count++;

for(int k = 0;k<str9.length();k++) {
			if(str9.charAt(k) == ' ') {
				Server_Count ++;
				
				
			}



			if(Server_Count == 0){
			
			ServerType = "";
			ServerType = str9.substring(0,k+1);
			
			
			
			
			String substrings[] = str9.split(" ");
			
			Arrays.toString(substrings);	
			
			Server_IDS[listNum] = substrings[1];
			
			listNum++;
			
	
			
			}
			




		
				
			if(Server_Count == 1){
			
		
		
			
			}
	
}

}







}


}	
	
		String LargeServerCount = String.valueOf(Original_Count);
		
		String B = "xlarge";
		
		
		String T = "inactive";
		
		int ServerC = serverID(MT,LargeServerCount);
		
		
		
	System.out.println(ServerC);
	
	// System.out.println(serverID(MT,LargeServerCount));		
	
			
			
			dout.write(("QUIT\n").getBytes());

			String str7 = (String) in.readLine();
			System.out.println("message= " + str7);
			
			dout.flush();
			dout.close();
			s.close();
		} 
		
		catch (Exception e) {
			System.out.println(e);
			
			

}	
}
	}

