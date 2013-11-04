import java.awt.*;
import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JPanel;

public class call {
	
    private int num = 4;
    private String webSite = "https://cp52-2.fonality.com/call.cgi?";
    private String[] userInfoLabel = {"server_id", "extention", "username", "password"};
    private String[] userInfo;
    private String phoneNumber;
    private String url;
    private Scanner input;
    private HttpsURLConnection con; 
    private URI uri;
    private int responseCode;


    public void setupDisplay(){
	
    }

    public void input(){
	System.out.println("Enter phone number: ");
	input = new Scanner(System.in);
	phoneNumber = input.nextLine();
	phoneNumber = "number=" + phoneNumber + "&";
    }
	
    public void getUser(){
	userInfo = new String[num];
	for(int i = 0; i < userInfo.length; i++){
		System.out.println("Enter " + userInfoLabel[i]); 
		userInfo[i] = input.nextLine();
	}
    }

    public void urlConnection() throws Exception {

	String urlParameters = "server_id=" + userInfo[0] + "&extension=" + userInfo[1] + "&username=" + userInfo[2] + "&password=" + userInfo[3] + "&";
	url = webSite +  urlParameters + phoneNumber;
	
	URL obj = new URL(url);
	con = (HttpsURLConnection) obj.openConnection();

	con.setRequestMethod("POST");
	con.setDoOutput(true);
	
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	
	wr.writeBytes(url);
	
	responseCode = con.getResponseCode();

	wr.flush();
	wr.close();
	
    }

    public void print() throws Exception {

	System.out.println("\nSending 'POST' request to URL : " + url);
//	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);
				 
	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	String inputLine;
	StringBuffer response = new StringBuffer();
								 
	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	//print result
	System.out.println(response.toString());
    }
}
