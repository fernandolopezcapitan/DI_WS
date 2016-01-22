package com.dam.salesianostriana.pmdm.calculadoracalorias;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapTrackerFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;
    MapView mapView;
    TextView txtMetros, txtCalorias;

    public MapTrackerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_map_tracker, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        txtMetros = (TextView) v.findViewById(R.id.Mapas_Distancia);
        txtCalorias = (TextView) v.findViewById(R.id.Mapas_Calorias);

        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(this);


        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng sydney = new LatLng(37.422134, -6.146573);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

        final List<LatLng> lista_lat = new ArrayList<>();
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                final LatLng lat_long = new LatLng(latLng.latitude, latLng.longitude);
                final Marker marcador = map.addMarker(new MarkerOptions()
                        .position(lat_long)
                        .draggable(true));

                map.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                marcador.setTitle("Mi posicion");
                marcador.showInfoWindow();

                lista_lat.add(lat_long);
                PolylineOptions options = new PolylineOptions();

                for (int i = 0; i < lista_lat.size(); i++) {
                    options.add(new LatLng(lista_lat.get(i).latitude, lista_lat.get(i).longitude))
                            .width(15)
                            .color(Color.BLUE);

                    DecimalFormat decimalFormat = new DecimalFormat("##.##");
                    double metros = SphericalUtil.computeDistanceBetween(lista_lat.get(0), lista_lat.get(lista_lat.size() - 1)) / 1000;
                    //hace que se vaya mostrando la distancia recorrida en ese momento.
                    txtMetros.setText(String.valueOf(decimalFormat.format(metros) + " km"));
                    txtCalorias.setText(String.valueOf(decimalFormat.format(calcularCalorias(55, metros)) + " k/cal"));
                }
                Polyline polygon = map.addPolyline(options);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(lat_long, 15));

            }
        });
    }

    public double calcularCalorias(double peso, double distancia){
        return peso * distancia;
    }

}
