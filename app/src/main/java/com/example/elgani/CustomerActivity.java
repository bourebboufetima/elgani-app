package com.example.elgani;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity implements ProfessionAdapter.OnItemClickListener{

    private String selectedServiceField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Profession> professions = new ArrayList<>();
        professions.add(new Profession("Programmer", R.drawable.p));
        professions.add(new Profession("Architect", R.drawable.aa));
        professions.add(new Profession("Human Resources", R.drawable.hr));
        professions.add(new Profession("Digital Marketing", R.drawable.dm));
        professions.add(new Profession("Video Editing and Design", R.drawable.ve));
        professions.add(new Profession("Artificial Intelligence", R.drawable.aii));
        professions.add(new Profession("Writing", R.drawable.tw));
        professions.add(new Profession("Teacher", R.drawable.t));

        ProfessionAdapter adapter = new ProfessionAdapter(professions, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String professionName) {
        if (professionName.equals("Programmer")) {
            Intent intent = new Intent(this, SubCategoryActivity.class);
            intent.putExtra("profession", "Programmer");
            startActivity(intent);
        } else if (professionName.equals("Architect")) {
            Intent intent = new Intent(this, SubCategoryActivity.class);
            intent.putExtra("profession", "Architect");
            startActivity(intent);
        } else {
            Toast.makeText(this, professionName + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
