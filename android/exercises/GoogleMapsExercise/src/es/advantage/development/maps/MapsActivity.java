/*
 * Copyright [2013] [Ricardo García Fernández] [ricardogarfe@gmail.com]
 * 
 * This file is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package es.advantage.development.maps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapsActivity extends MapActivity {

    private MapView mapView;
    private MapController mapController;

    private Location mLocation;
    private LocationManager mLocationManager;
    private MyLocationListener mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtener mapView para configurar sus valores.
        mapView = (MapView) findViewById(R.id.mapView);

        // Aplicar Zoom y clickable
        mapView.setBuiltInZoomControls(true);
        mapView.setClickable(true);

        // Map controller para interactuar con la vista.
        mapController = mapView.getController();

        GeoPoint geoPoint = new GeoPoint((int) (0 * 1E6), (int) (0 * 1E6));

        mapController.setZoom(18);
        mapController.animateTo(geoPoint);

        setLocationListener();

    }

    private void refreshMap() {

        GeoPoint geoPoint = new GeoPoint((int) (mLocation.getLatitude() * 1E6),
                (int) (mLocation.getLongitude() * 1E6));

        mapController.setZoom(18);
        mapController.animateTo(geoPoint);
    }

    private void setLocationListener() {

        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mLocationListener = new MyLocationListener();

        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                5000, 15, mLocationListener);
    }

    public class MyLocationListener implements LocationListener {

        /*
         * (non-Javadoc)
         * 
         * @see
         * android.location.LocationListener#onLocationChanged(android.location.
         * Location)
         */
        @Override
        public void onLocationChanged(Location location) {

            mLocation = location;

            Log.d("MyLocationListener",
                    "Location:\n * Latitude:\t"
                            + String.valueOf(mLocation.getLatitude())
                            + "\n* Longitude:\t"
                            + String.valueOf(mLocation.getLongitude()));
            refreshMap();
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * android.location.LocationListener#onStatusChanged(java.lang.String,
         * int, android.os.Bundle)
         */
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * android.location.LocationListener#onProviderEnabled(java.lang.String)
         * 
         * <p>Se ejecuta siempre que se activa el estado.</p>
         */
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * android.location.LocationListener#onProviderDisabled(java.lang.String
         * )
         * 
         * <p>Se ejecuta siempre que se desactiva el estado.</p>
         */
        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_maps, menu);
        return true;
    }

    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        mLocationManager.removeUpdates(mLocationListener);
        super.onDestroy();
    }
}
