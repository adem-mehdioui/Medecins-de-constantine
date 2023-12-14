package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity {

    private ActionBar mActionBar;

    private ProgressBar progressBar;

    // Variable declarations
    private RecyclerView.Adapter mAdapter;
    private List<Medecin> medecins;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;



    private static final String BASE_URL = "http://192.168.1.8/android/getMedecins.php";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setting up action bar
        // setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        progressBar = findViewById(R.id.progressbar);


        recyclerView = findViewById(R.id.products_recyclerView);
        manager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(manager);

        medecins = new ArrayList<>();

        getMedecins();


    }



    private void getMedecins (){
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       progressBar.setVisibility(View.GONE);

                        try {


                            //Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){



                                JSONObject object = array.getJSONObject(i);


                                String nom = object.getString("nom");
                                String prenom = object.getString("prenom");
                                String sexe = object.getString("sexe");
                                String specialite = object.getString("specialite");
                                String adresse = object.getString("adresse");
                                String numtel = object.getString("numtel");





                                //double price = object.getDouble("price");
                               // double rating = object.getDouble("rating");
                              //  String image = object.getString("image");

                                //String rate = String.valueOf(rating);
                               // float newRate = Float.valueOf(rate);

                               // Product product = new Product(title,price, newRate,image);

                                Medecin medecin = new Medecin(nom,prenom,sexe,specialite,adresse,numtel);
                                medecins.add(medecin);

                            }

                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                        }

                        mAdapter = new RecyclerAdapter(MainActivity.this,medecins);
                        recyclerView.setAdapter(mAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);

            }
        });

        Volley.newRequestQueue(MainActivity.this).add(stringRequest);

    }


}