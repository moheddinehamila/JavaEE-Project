package Services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import Entities.User;
import Interfaces.IServiceUser;
@Stateless
@LocalBean
public class ServiceUser implements IServiceUser{ 
	


	public User Dologin(String email, String Password) {
		
		try {
		URL obj = new URL("http://192.168.1.111/Token");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        StringBuilder sb = new StringBuilder("grant_type=password");
        sb.append("&username=").append(email);
        sb.append("&password=").append(Password);

        System.out.println(sb.toString());

        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(sb.toString());
        wr.flush();

        int httpResult = con.getResponseCode();
        InputStream inputStream;
        if (httpResult == 200)  {
            inputStream = con.getInputStream();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));

            StringBuilder response = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null)
                response.append(currentLine);

            in.close();
            

            String jsonResponse = response.toString();
    	
    	
    		JSONObject jo = new JSONObject(jsonResponse);
            String Id = jo.getString("userId");
            String FirstName = jo.getString("FirstName");
            String LastName = jo.getString("LastName");
            String PhoneNumber = jo.getString("PhoneNumber");
            String Email = jo.getString("userName");
            String Country = jo.getString("Country");	
            String role = jo.getString("role");



            User c=	 new User(Id, FirstName, LastName, Email, PhoneNumber, Country, role);
            System.out.println("////////////"+c.getPhoneNumber());
            System.out.println("++++++++++++"+c.getLastName());
            System.out.println("++++++++++++"+c.getRole());
            return c;
        } else {
            return null;
        }

       

     
		}catch (Exception e) {
			// TODO: handle exception
		}
return null ;
	}
public String Register(String FirstName,String LastName,String Email, String Password, String Confirmpassword, String PhoneNumber,String Country )  {
	String Res ="";
	try {
	URL obj = new URL("http://192.168.1.111/api/account/register");
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");

    String jsonString = new JSONObject()
			.put("FirstName",FirstName )
			.put("LastName",LastName )
			.put("Email",Email)
			.put("Password",Password)
			.put("Confirmpassword",Confirmpassword)
			.put("PhoneNumber",PhoneNumber)
			.put("Country",Country)
			.toString();

	System.out.println(jsonString);

    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
    wr.write(jsonString);
    wr.flush();
   
    int httpResult = con.getResponseCode();
  if (httpResult == 200) {
	  Res="Success";
	  return Res ;
  }
	}catch (Exception e) {
		// TODO: handle exception
	}
    
	return null;
		
		
	}
	}

