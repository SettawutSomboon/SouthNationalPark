package app.project2.southnationalpark;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class AdviceNational extends Activity implements OnClickListener{
	
	Button btn_general,btn_food,btn_weather,btn_uniform,btn_animal,btn_other,btn_gallery;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advicemain);
		
		btn_general = (Button)findViewById(R.id.btn_general);
		btn_food = (Button)findViewById(R.id.btn_food);
		btn_weather = (Button)findViewById(R.id.btn_weather);
		btn_uniform = (Button)findViewById(R.id.btn_uniform);
		btn_animal = (Button)findViewById(R.id.btn_animal);
		btn_other = (Button)findViewById(R.id.btn_other);
		btn_gallery = (Button)findViewById(R.id.btn_gallery);
		
		btn_general.setOnClickListener(this);
		btn_food.setOnClickListener(this);
		btn_weather.setOnClickListener(this);
		btn_uniform.setOnClickListener(this);
		btn_animal.setOnClickListener(this);
		btn_other.setOnClickListener(this);
		btn_gallery.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.btn_general:
			Log.d("general","general");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("�����")
			.setMessage(R.string.general)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_food:
			Log.d("food","food");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("�����")
			.setMessage(R.string.food)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_weather:
			Log.d("weather","weather");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("Ĵ١��")
			.setMessage(R.string.weather)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_uniform:
			Log.d("uniform","uniform");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("����觡��")
			.setMessage(R.string.uniform)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_animal:
			Log.d("animal","animal");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("��ŧ�ѵ��Ѵ����")
			.setMessage(R.string.animal)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_other:
			Log.d("other","other");
			//Display difficulty dialog 
			new AlertDialog.Builder(this)
			.setTitle("����")
			.setMessage(R.string.other)
			.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        })
					.show();
			break;
		case R.id.btn_gallery:
			Log.d("gallery","gallery");
			Intent GalleryIntent = new Intent(this, Test.class);
			startActivity(GalleryIntent);
			break;

	}
	}
}
