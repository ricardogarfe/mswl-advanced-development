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

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import es.advantage.development.maps.model.Node;
import es.advantage.development.maps.overlays.MapOverlay;

public class MapsExerciseActivity extends MapActivity {

    private MapView mapView;
    private MapController mapController;

    private GeoPoint mGeoPoint;
    private Node mNodeMap;

    private TextView textViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtener mapView para configurar sus valores.
        mapView = (MapView) findViewById(R.id.mapView);

        // TexViewLocation
        textViewLocation = (TextView) findViewById(R.id.textViewLocation);

        // Aplicar Zoom y clickable
        mapView.setBuiltInZoomControls(true);
        mapView.setClickable(true);

        // Map controller para interactuar con la vista.
        mapController = mapView.getController();

        initializeValuesFromIntent();

        refreshMap();

    }

    /**
     * Inicializar valores para mostrar en el mapa.
     */
    private void initializeValuesFromIntent() {
        // Retrieve value from nucleos activity.
        Intent intentFromActivity = getIntent();

        if (intentFromActivity != null) {

            mNodeMap = intentFromActivity.getParcelableExtra("node");

        }

    }

    private void refreshMap() {
        if (mNodeMap == null) {
            Toast.makeText(getBaseContext(), "Location not available!",
                    Toast.LENGTH_LONG).show();

            return;
        }

        mGeoPoint = new GeoPoint((int) (mNodeMap.mLat * 1E6),
                (int) (mNodeMap.mLon * 1E6));

        mapController.setZoom(18);
        mapController.animateTo(mGeoPoint);

        MapOverlay myMapOver = new MapOverlay();

        Drawable drawable = getResources().getDrawable(mNodeMap.mImageResource);
        drawable.setBounds(0, 0, 50, 50);

        myMapOver.setDrawable(drawable);
        myMapOver.setGeoPoint(mGeoPoint);
        myMapOver.setTextToShow(mNodeMap.mTitle);

        final List<Overlay> overlays = mapView.getOverlays();
        overlays.clear();

        overlays.add(myMapOver);

        mapView.setBuiltInZoomControls(true);

        mapView.setClickable(true);

        textViewLocation.setText("Your Current Location: \n"
                + String.valueOf(mGeoPoint.getLatitudeE6()) + " , "
                + String.valueOf(mGeoPoint.getLongitudeE6()));
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

}
