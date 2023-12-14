package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Medecin> medecins = new ArrayList<>();


    public RecyclerAdapter (Context context,List<Medecin> medecins){
        this.mContext = context;
        this.medecins = medecins;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nom_medecin, prenom_medecin, sexe_medecin, specialite_medecin, adresse_medecin, numtel_medecin;
        //private ImageView mImageView;
        //private RatingBar mRate;
        private LinearLayout mContainer;

        public MyViewHolder (View view){
            super(view);

            nom_medecin = view.findViewById(R.id.medecin_nom);
            prenom_medecin = view.findViewById(R.id.medecin_preom);
            sexe_medecin = view.findViewById(R.id.medecin_sexe);
            specialite_medecin = view.findViewById(R.id.medecin_specialite);
            adresse_medecin = view.findViewById(R.id.medecin_adresse);
            numtel_medecin = view.findViewById(R.id.medecin_numtel);


            mContainer = view.findViewById(R.id.medecin_container);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.medecins_list_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Medecin medecin = medecins.get(position);


        holder.nom_medecin.setText("Nom : "+medecin.getNom());
        holder.prenom_medecin.setText("Prénom : "+medecin.getPrenom());
        holder.sexe_medecin.setText("Sexe : "+medecin.getSexe());
        holder.specialite_medecin.setText("Spécialité : "+medecin.getSpecialite());
        holder.adresse_medecin.setText("Adresse : "+medecin.getAdresse());
        holder.numtel_medecin.setText("Numéro du téléphone : "+medecin.getNumtel());





        //Glide.with(mContext).load(product.getImage()).into(holder.mImageView);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailedMedecinsActivity.class);

                intent.putExtra("nom",medecin.getNom());
                intent.putExtra("prenom",medecin.getPrenom());
                intent.putExtra("sexe",medecin.getSexe());
                intent.putExtra("specialite",medecin.getSpecialite());
                intent.putExtra("adresse",medecin.getAdresse());
                intent.putExtra("numtel",medecin.getNumtel());





                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return medecins.size();
    }
}
