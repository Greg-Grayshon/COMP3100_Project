import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Arrays;

public class DS_Client {

	static int serverID(String Giant_String, String Locate) {

		String temp[] = Giant_String.split(" ");

		int Main_Count = 0;

		for (int z = 0; z < temp.length; z++) {

			if (Locate.contains(temp[z])) {
				Main_Count++;
			}
		}

		return Main_Count;
	}

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 50000);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			dout.write(("HELO\n").getBytes());

			String str = (String) in.readLine();
			System.out.println("message= " + str);
																						// Initial Connect + Authorise

			dout.write(("AUTH" + "Greg G" + "\n").getBytes());

			String str2 = (String) in.readLine();
			System.out.println("message= " + str2);

			int Space_Counter = 0;
			String JobID = "";

			dout.write(("REDY\n").getBytes());

			String str3 = (String) in.readLine();
			System.out.println("message= " + str3);

			// Get JOBN Parameters
			for (int k = 0; k < str3.length(); k++) {
				if (str3.charAt(k) == ' ') {
					Space_Counter++;

				}

				if (Space_Counter == 2) {

					JobID = JobID + str3.charAt(k);

				}

			}

			Space_Counter = 0;

			String Result = "";

			for (int i = 0; i < str3.length(); i++) {
				if (str3.charAt(i) == ' ') {
					Space_Counter++;

				}

				if (Space_Counter >= 4) {

					Result = Result + str3.charAt(i);

				}

			}

			dout.write(("GETS Capable" + Result + "\n").getBytes()); 			// Obtain number of all capable servers

			String str4 = (String) in.readLine();
			System.out.println("message= " + str4);

			Space_Counter = 0;

			String NRecsWord = "";

			for (int i = 0; i < str4.length(); i++) {
				if (str4.charAt(i) == ' ') {
					Space_Counter++;

				}

				if (Space_Counter == 1) {

					NRecsWord = NRecsWord + str4.charAt(i);

				}

			}

			NRecsWord = NRecsWord.replaceFirst(" ", "");

			Integer.parseInt(NRecsWord);

			dout.write(("OK\n").getBytes());
			String str5 = (String) in.readLine();
			System.out.println("message= " + str5);

			int nRecs;
			try {
				nRecs = Integer.valueOf(NRecsWord);
			} catch (NumberFormatException e) {
				nRecs = 0;
			}

			int Original_Count = 0;

			String ServerType = "";

			String Server_String_Copy = "";

			for (int i = 0; i < nRecs; i++) {

				int Main_Counter = 0;

				int Server_Count = 0;

				String CoreCount = "";

				dout.write(("OK\n").getBytes());
				String str9 = (String) in.readLine();
				System.out.println("message= " + str9);

				Server_String_Copy = Server_String_Copy + str9;				 // Make Copy of String of all servers

				for (int j = 0; j < str9.length(); j++) {
					if (str9.charAt(j) == ' ') {
						Main_Counter++;

					}

					if (Main_Counter == 4) {

						CoreCount = CoreCount + str9.charAt(j);

					}

					CoreCount = CoreCount.replaceFirst(" ", "");

					int Core_Count_Int;

					try {

						Core_Count_Int = Integer.parseInt(CoreCount);
					}

					catch (NumberFormatException e) {

						Core_Count_Int = 0;

					}

					if (Core_Count_Int >= Original_Count) {

						Original_Count = Core_Count_Int;

						for (int k = 0; k < str9.length(); k++) {
							if (str9.charAt(k) == ' ') {
								Server_Count++;

							}

							if (Server_Count == 0) {

								ServerType = ""; // Retrieve ServerType
								ServerType = str9.substring(0, k + 1);

							}

						}

					}

				}

			}

			String LargeServerCount = String.valueOf(Original_Count);

			int Server_Count = serverID(Server_String_Copy, LargeServerCount); 			// Retrieve Highest Server Count

			int jobtest = 0;

			Space_Counter = 0;

			int JobCount = 0;

			String Jobs = " JOBN";

			try {

				JobCount = Integer.parseInt(JobID);
			}

			catch (NumberFormatException e) { // convert JobID to integer

				JobCount = 0;

			}

			String str12 = "JOBN";

			String JobTest = str12.substring(0, 4);

			System.out.println(JobTest);

			

				dout.write(("SCHD " + JobID + " " + ServerType + " 0\n").getBytes());
				String str8 = (String) in.readLine();
				System.out.println("message= " + str8);

				JobID = "";																//Schedule Jobs
				Space_Counter = 0;

				for (int f = 0; f < str8.length(); f++) {
					if (str8.charAt(f) == ' ') {
						Space_Counter++;

					}

					if (Space_Counter == 2) {

						JobID = JobID + str8.charAt(f);
																					// Loop to Schedule Jobs
					}

				}

				String str18 = (String) in.readLine();
				System.out.println("message= " + str18);

				dout.write(("REDY\n").getBytes());

				str12 = (String) in.readLine();
				System.out.println("message= " + str12);

			

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
