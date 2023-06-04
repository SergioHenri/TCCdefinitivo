package com.example.tcc_definitivo.menu;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.tcc_definitivo.R;


import com.example.tcc_definitivo.databinding.ActivityAprendeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class ecoponto extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;

    private ActivityAprendeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityAprendeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.iconree);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        assert mapFragment != null;
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                if (ActivityCompat.checkSelfPermission(ecoponto.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ecoponto.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                String mensagemCapitãoCasa=("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)");
                mMap = googleMap;
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                LatLng Capitao = new LatLng(-23.725853657994577, -46.560203344828466);
                Marker CapitãoCasa=mMap.addMarker(new MarkerOptions().position(Capitao).title("Ecoponto Capitão Casa").snippet("Horario:8h ás 16h \n " +
                       mensagemCapitãoCasa).icon(icon));
                //
                LatLng Bastitini = new LatLng(-23.756410445773568, -46.57896513578265);
                Marker Bastitini2=mMap.addMarker(new MarkerOptions().position(Bastitini).title("Bastitini").snippet("Horario:9h ás 17h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)").icon(icon));
                //


                LatLng DER = new LatLng(-23.701566577377374, -46.55744748975392);
                Marker DER2=mMap.addMarker(new MarkerOptions().position(DER).title("DER").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //
                LatLng Divinéia = new LatLng(-23.742691487761345, -46.56998292043948);
                Marker Divinéia2=mMap.addMarker(new MarkerOptions().position(Divinéia).title("Ecoponto Divinéia").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //
                LatLng EcopontoJardimRe = new LatLng(-23.72621727038957, -46.53505710509643);
                Marker  EcopontoJardimRe2=mMap.addMarker(new MarkerOptions().position(EcopontoJardimRe).title("Ecoponto Jardim Regina").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //
                LatLng Passaros = new LatLng(-23.70988379390493, -46.58480999144998);
                Marker  Passaros2=mMap.addMarker(new MarkerOptions().position(Passaros).title("Ecoponto Passaros").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //
                LatLng Riacho = new LatLng(-23.78197944023038, -46.52919536276595);
                Marker  Riacho2=mMap.addMarker(new MarkerOptions().position(Riacho).title("Ecoponto Riacho Grande").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //
                LatLng Taboao = new LatLng(-23.661831426812594, -46.59489668369156);
                Marker  Taboao2=mMap.addMarker(new MarkerOptions().position(Taboao).title("Ecoponto Taboão").snippet("Horario:8h ás 16h \n " +
                        "O que pode ser descartado:• Papel\n" +
                        "• Vidro\n" +
                        "• Plástico\n" +
                        "• Metal\n" +
                        "• Objetos Volumosos, como móveis e utensílios doméstico e Lampadas\n" +
                        "• Resíduos de Construção Civil (limitado a 1m³ ou 10 sacos de 100 litros por obra)\n").icon(icon));
                //

                LocationListener locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        mMap = googleMap;
                        fusedLocationClient = LocationServices.getFusedLocationProviderClient(ecoponto.this);
                        if (ActivityCompat.checkSelfPermission(ecoponto.this, Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ecoponto.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                            ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                            ActivityCompat.requestPermissions(ecoponto.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }

                        fusedLocationClient.getLastLocation()
                                .addOnSuccessListener(ecoponto.this, new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {
                                        // Got last known location. In some rare situations this can be null.
                                        if (location != null) {
                                            MarkerOptions markerOptions = new MarkerOptions()
                                                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                                                    .title("Minha Localização");

                                            Marker marker = mMap.addMarker(markerOptions);
                                            // Atualizar a UI com a nova localização
                                            // Logic to handle location object
                                        }
                                    }
                                });



                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                    }
                };

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }

        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        //vou colocar todos os ecopontos aqui





        //Função para mostrar minha localização


        //Cria instancia para gerenciar atualizações de localização

        //recebe as atualizações de localização








    }
}