package fr.epsi.birthdayapp;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Anniversaire  {

    private String date;
    private String tel;
    private String photo;

    private String nom;

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getTel() {
        return tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
