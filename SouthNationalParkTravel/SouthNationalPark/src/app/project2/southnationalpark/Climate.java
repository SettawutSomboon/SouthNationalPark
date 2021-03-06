package app.project2.southnationalpark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Climate extends Activity {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.climate);


		 if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
		  showInfo();
	
	      
	}

	private void showInfo() {
		// TODO Auto-generated method stub
		final TextView climate = (TextView)findViewById(R.id.txt_climate_data);
		final TextView parkname = (TextView)findViewById(R.id.txt_parkname);
		//Button Tab
		Button btn_topography = (Button)findViewById(R.id.btn_topography);
		Button btn_climate = (Button)findViewById(R.id.btn_climate);
		Button btn_plant = (Button)findViewById(R.id.btn_plant);
		Button btn_animal = (Button)findViewById(R.id.btn_animal);

    	
    	String url = "http://10.0.3.2/SouthNationalParkTravel/getClimate.php";
    	
    	Intent intent= getIntent();
    	final String id = intent.getStringExtra("pid"); 

		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("climateID", id));
        
        //�Ѻ��� id �����觵����ѧ ˹������
        btn_topography.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent topography = new Intent(Climate.this, Topography.class);
                topography.putExtra("pid", id);
				startActivity(topography);

            }
        });
        btn_climate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent climate = new Intent(Climate.this, Climate.class);
                climate.putExtra("pid", id);
				startActivity(climate);

            }
        });
        btn_plant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent plant = new Intent(Climate.this, Plant.class);
                plant.putExtra("pid", id);
				startActivity(plant);

            }
        });
        btn_animal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent animal = new Intent(Climate.this, Animal.class);
                animal.putExtra("pid", id);
				startActivity(animal);

            }
        });
        
        String resultServer  = getHttpPost(url,params);
	  	 
    	String strClimate = "";
    	String strParkname = "";
    	
    	JSONObject c;
		try {
			c = new JSONObject(resultServer);
			strClimate = c.getString("climate");
			strParkname  = c.getString("parkname");

			
			if(!strClimate.equals(""))
			{
				climate.setText(strClimate);
				parkname.setText(strParkname);
			}
			else
			{
				climate.setText("-");
				parkname.setText("-");
			}
        	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
	public String getHttpPost(String url,List<NameValuePair> params) {
		StringBuilder str = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) { // Status OK
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					str.append(line);
				}
			} else {
				Log.e("Log", "Failed to download result..");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
		
	}
}
