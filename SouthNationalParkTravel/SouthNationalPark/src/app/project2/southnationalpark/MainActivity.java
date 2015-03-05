package app.project2.southnationalpark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements LocationListener {

    private static final LatLng Sirinat = new LatLng(8.095575, 98.299368);
    private static final LatLng KhaoPhanomBenchaNationalPark = new LatLng(8.272131, 98.921310);
    private static final LatLng ThanBokKhoraniNationalPark = new LatLng(8.347745, 98.729836);
    private static final LatLng MuKoLantaNationalPark = new LatLng(7.534930, 99.097354);
    private static final LatLng HatNoppharatTharaMuKoPhiPhiNationalPark = new LatLng(8.035472, 98.822867);
    private static final LatLng MuKoChumphonNationalPark = new LatLng(10.256674, 99.200420);
    private static final LatLng HatChaoMaiNationalPark = new LatLng(7.425277, 99.347266);
    private static final LatLng KhaoNanNationalPark = new LatLng(8.777478, 99.781141);
    private static final LatLng KhaoLuangNaionalPark = new LatLng(8.532179, 99.724045);
    private static final LatLng NamTokYongNationalPark = new LatLng(8.182895, 99.734505);
    private static final LatLng NamtokSiKhitNationalPark = new LatLng(9.029087, 99.693024);
    private static final LatLng HatKhanomMuKoThaleTaiNationPark = new LatLng(9.212719, 99.870805);
    
GoogleMap mMap;
double lat, lng;
Marker mMarker;

LocationManager lm;
LocationListener locationListener;

LatLng startPosition = new LatLng(13.095397, 100.964078);
LatLng endPosition = new LatLng(13.171791,100.926245);

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

mMap = ((MapFragment)getFragmentManager()
.findFragmentById(R.id.map)).getMap();


LatLng coordinates = new LatLng(13.095397, 100.964078); 
mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 7));
mMap.setMyLocationEnabled(true);
mMap.getUiSettings().setCompassEnabled(true);
mMap.getUiSettings().setRotateGesturesEnabled(true);
//locationListener = new MyLocationListener();

lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000,100, this);


}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.nationalpark_menu:
        CameraPosition cameraK = new CameraPosition.Builder()
                .target(KhaoPhanomBenchaNationalPark)
                .zoom(10)
                .bearing(0)
                .tilt(0)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraK));
        addMarker();
        return true;
    default:
        return super.onOptionsItemSelected(item);
    }
}

private void addMarker() {
	mMap.addMarker(new MarkerOptions()
    .position(KhaoPhanomBenchaNationalPark)
    .title(getString(R.string.KhaoPhanomBenchaNationalPark_title))
    .snippet(getString(R.string.KhaoPhanomBenchaNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
            .position(Sirinat)
            .title(getString(R.string.Sirinat_title))
            .snippet(getString(R.string.Sirinat_snippet))
    );
	mMap.addMarker(new MarkerOptions()
    .position(ThanBokKhoraniNationalPark)
    .title(getString(R.string.ThanBokKhoraniNationalPark_title))
    .snippet(getString(R.string.ThanBokKhoraniNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(MuKoLantaNationalPark)
    .title(getString(R.string.MuKoLantaNationalPark_title))
    .snippet(getString(R.string.MuKoLantaNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(HatNoppharatTharaMuKoPhiPhiNationalPark)
    .title(getString(R.string.HatNoppharatTharaMuKoPhiPhiNationalPark_title))
    .snippet(getString(R.string.HatNoppharatTharaMuKoPhiPhiNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(MuKoChumphonNationalPark)
    .title(getString(R.string.MuKoChumphonNationalPark_title))
    .snippet(getString(R.string.MuKoChumphonNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(HatChaoMaiNationalPark)
    .title(getString(R.string.HatChaoMaiNationalPark_title))
    .snippet(getString(R.string.HatChaoMaiNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(KhaoNanNationalPark)
    .title(getString(R.string.KhaoNanNationalPark_title))
    .snippet(getString(R.string.KhaoNanNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(KhaoLuangNaionalPark)
    .title(getString(R.string.KhaoLuangNaionalPark_title))
    .snippet(getString(R.string.KhaoLuangNaionalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(NamTokYongNationalPark)
    .title(getString(R.string.NamTokYongNationalPark_title))
    .snippet(getString(R.string.NamTokYongNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(NamtokSiKhitNationalPark)
    .title(getString(R.string.NamtokSiKhitNationalPark_title))
    .snippet(getString(R.string.NamtokSiKhitNationalPark_snippet))
);
	mMap.addMarker(new MarkerOptions()
    .position(HatKhanomMuKoThaleTaiNationPark)
    .title(getString(R.string.HatKhanomMuKoThaleTaiNationPark_title))
    .snippet(getString(R.string.HatKhanomMuKoThaleTaiNationPark_snippet))
);
}

@Override
public void onLocationChanged(Location location) {
// TODO Auto-generated method stub
String lat = String.valueOf(location.getLatitude());
String lon = String.valueOf(location.getLongitude());
Log.e("GPS", "location changed: lat="+lat+", lon="+lon);
//tv.setText("lat="+lat+", lon="+lon);
LatLng coordinates = new LatLng(location.getLatitude(), location.getLongitude()); 
mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 12));


//Update Value of Lat Long
}

@Override
public void onProviderDisabled(String provider) {
// TODO Auto-generated method stub

}

@Override
public void onProviderEnabled(String provider) {
// TODO Auto-generated method stub

}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
// TODO Auto-generated method stub

}




}