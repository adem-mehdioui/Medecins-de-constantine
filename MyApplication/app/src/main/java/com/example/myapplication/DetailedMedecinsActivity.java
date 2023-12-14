package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailedMedecinsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;
   // private ImageView mImage;
    private TextView Tnom, Tprenom, Tsexe, Tspecialite, Tadresse, Tnumtel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_products);

        mToolbar = findViewById(R.id.toolbar);
        //mImage = findViewById(R.id.image_view);
        Tnom = findViewById(R.id.nom);
        Tprenom = findViewById(R.id.prenom);
        Tsexe = findViewById(R.id.sexe);
        Tspecialite = findViewById(R.id.specialite);
        Tadresse = findViewById(R.id.adresse);
        Tnumtel = findViewById(R.id.numtel);

        // Setting up action bar
       // setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
       // mActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp));

        // Catching incoming intent
        Intent intent = getIntent();
        //double price = intent.getDoubleExtra("price",0);
        //float rate = intent.getFloatExtra("rate",0);
        String nom = intent.getStringExtra("nom");
        String prenom = intent.getStringExtra("prenom");
        String sexe = intent.getStringExtra("sexe");
        String specialite = intent.getStringExtra("specialite");
        String adresse = intent.getStringExtra("adresse");
        String numtel = intent.getStringExtra("numtel");





        if (intent !=null){

           // mActionBar.setTitle(title);
            //mRating.setText("Rating :"+rate+" /2");
            //mPrice.setText(String.valueOf(price));
            Tnom.setText(nom);
            Tprenom.setText(prenom);
            Tsexe.setText(sexe);
            Tspecialite.setText(specialite);
            Tadresse.setText(adresse);
            Tnumtel.setText(numtel);
            //Glide.with(DetailedMedecinsActivity.this).load(image).into(mImage);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
