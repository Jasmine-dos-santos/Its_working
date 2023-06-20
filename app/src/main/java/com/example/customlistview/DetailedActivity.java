package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.customlistview.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int area = intent.getIntExtra("area", R.string.SouthArea);
            int duration = intent.getIntExtra("duration", R.string.SouthDuration);
            int image = intent.getIntExtra("image", R.drawable.maggi);

            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDuration.setText(duration);
            binding.detailArea.setText(area);
            binding.detailImage.setImageResource(image);
        }
    }
}