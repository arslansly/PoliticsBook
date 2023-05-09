package com.arslan.politicsbookjava;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputBinding;
import android.widget.TextView;

import com.arslan.politicsbookjava.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Intent intent = getIntent();

        //Casting
        //Politics selectedPolitics = (Politics) intent.getSerializableExtra("politics");
        //Politics selectedPolitics = chosenPolitics;
        Singleton singleton = Singleton.getInstance();
        Politics selectedPolitics = singleton.getSentPolitics();
        binding.nameText.setText(selectedPolitics.name);
        binding.detailsText.setText(selectedPolitics.gecmis);
        binding.imageView.setImageResource(selectedPolitics.image);




    }
}