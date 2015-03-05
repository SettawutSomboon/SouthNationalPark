package app.project2.southnationalpark;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ShareActionProvider;
import app.project2.southnationalpark.feed.FeedMain;


public class MainMenu extends Activity implements OnClickListener{
	private ShareActionProvider shareProvider;

	Uri imgURI;
	final int LOAD_IMAGE_COMPLETE = 100;
	Button btnNational,btnMap,btnNews,btnActivity,btnFacebook;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnNational = (Button)findViewById(R.id.ImageButton01);
		btnMap = (Button)findViewById(R.id.ImageButton02);
		btnNews = (Button)findViewById(R.id.ImageButton03);
		btnActivity = (Button)findViewById(R.id.ImageButton04);
		btnFacebook = (Button)findViewById(R.id.btn_fb);
		
		btnNational.setOnClickListener(this);
		btnMap.setOnClickListener(this);
		btnNews.setOnClickListener(this);
		btnFacebook.setOnClickListener(this);
		btnActivity.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ImageButton01:
			Log.d("Information","Information");
			Intent InformationIntent = new Intent(this, Category.class);
			startActivity(InformationIntent);
			break;
			
		case R.id.ImageButton02:
			Log.d("Map","Map");
			Intent MapIntent = new Intent(this, MainActivity.class);
			startActivity(MapIntent);
			break;
			
		case R.id.ImageButton03:
			Log.d("Feed","Feed");
			Intent FeedIntent = new Intent(this, app.project2.southnationalpark.feed.FeedMain.class);
			startActivity(FeedIntent);
			break;
			
		case R.id.btn_fb:
			Log.d("Facebook","Facebook");
			//Intent FacebookIntent = new Intent(this, FacebookActivity.class);
			//startActivity(FacebookIntent);
			Intent i = new Intent(Intent.ACTION_PICK,
					   Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i, LOAD_IMAGE_COMPLETE);
			break;
			
		case R.id.ImageButton04:
			Log.d("Activity","Activity");
			Intent ActivityIntent = new Intent(this, AdviceNational.class);
			startActivity(ActivityIntent);
			break;

		default:
			break;
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if ((resultCode == RESULT_OK) && (requestCode == LOAD_IMAGE_COMPLETE)) {
			imgURI = data.getData();	
			
			if (shareProvider != null) {
				shareProvider.setShareIntent(ShareIntent());
			}
		}
		
	}

	private Intent ShareIntent() {
		Intent i = new Intent(Intent.ACTION_SEND);
		if (imgURI != null) {
			i.putExtra(Intent.EXTRA_STREAM, imgURI);
			i.setType("image/png");
		}
		return i;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.share, menu);
		MenuItem item = menu.findItem(R.id.menu_item_share);

		shareProvider = (ShareActionProvider) item.getActionProvider();
		shareProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
		return true;
		
	}
	@Override
    public void onDestroy() {
        super.onDestroy();
    }
	public void onBackPressed() {
                finish();              
    }
}
