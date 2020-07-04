package com.example.googlemappapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng Benha = new LatLng(30.4740706, 31.2023205);
        mMap.addMarker(new MarkerOptions().position(Benha).title("محطة المياه - بنها")).showInfoWindow();

        /*
        mMap.addMarker(new MarkerOptions().position(Benha).title("محطة المياه - بنها").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone))).showInfoWindow();

         */
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Benha, 16));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                // The coordinates == latLng
                Toast.makeText(MapsActivity.this, latLng.latitude + "," + latLng.longitude, Toast.LENGTH_SHORT).show();
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(latLng).title("new location")).showInfoWindow();

            }
        });
    }
}