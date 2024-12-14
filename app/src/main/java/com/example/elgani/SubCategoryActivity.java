package com.example.elgani;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SubCategoryActivity extends AppCompatActivity implements ProfessionAdapter.OnItemClickListener {

    private ActivityResultLauncher<Intent> filePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Profession> subCategories = new ArrayList<>();
        String profession = getIntent().getStringExtra("profession");

        if (profession.equals("Programmer")) {
            subCategories.add(new Profession("Platform", R.drawable.pp));
            subCategories.add(new Profession("Website", R.drawable.w));
            subCategories.add(new Profession("Web Application", R.drawable.wa));
            subCategories.add(new Profession("Logiciel", R.drawable.lo));
        } else if (profession.equals("Architect")) {
            subCategories.add(new Profession("Specification Document", R.drawable.c));
        }

        ProfessionAdapter adapter = new ProfessionAdapter(subCategories, this);
        recyclerView.setAdapter(adapter);

        // File Picker Result Handling
        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Uri selectedFileUri = result.getData().getData();
                if (selectedFileUri != null) {
                    Toast.makeText(this, "File Selected: " + selectedFileUri.getPath(), Toast.LENGTH_SHORT).show();
                    // TODO: Implement file upload to server or further processing
                }
            }
        });
    }

    @Override
    public void onItemClick(String subCategoryName) {
        Intent intent = new Intent(this, CustomerFormActivity.class);
        startActivity(intent);
    }


}
