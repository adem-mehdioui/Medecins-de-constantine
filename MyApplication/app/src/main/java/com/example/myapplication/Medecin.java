package com.example.myapplication;

public class Medecin {

    private String nom, prenom, sexe, specialite, adresse, numtel;

    public Medecin(String nom, String prenom, String sexe, String specialite, String adresse, String numtel) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.specialite = specialite;
        this.adresse = adresse;
        this.numtel = numtel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }
}
