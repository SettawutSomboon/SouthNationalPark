package app.project2.southnationalpark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CategoryNationalPark extends Activity implements OnClickListener{
	Button btnLand,btnMarine;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_con);
		
		btnLand = (Button)findViewById(R.id.btn_land);
		btnMarine = (Button)findViewById(R.id.btn_marine);
		btnLand.setOnClickListener(this);
		btnMarine.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}
}
