package fr.epsi.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Anniversaire> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        recyclerView = (RecyclerView) findViewById(R.id.recyleView);

//        mAdapter = new AnniversaireAdapter(this, ArrayList<Anniversaire> list);
//        recyclerView.setAdapter(mAdapter);


    }
}
