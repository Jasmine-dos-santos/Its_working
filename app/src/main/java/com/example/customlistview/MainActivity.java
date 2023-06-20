package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.customlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.log, R.drawable.log, R.drawable.log, R.drawable.log};
        int[] areaList = {R.string.NorthArea, R.string.SouthArea,R.string.EastArea,R.string.WestArea};
        int[] durationList = {R.string.NorthDuration, R.string.SouthDuration, R.string.EastDuration,R.string.WestDuration};
        String[] nameList = {"North", "South", "East", "West"};
        String[] timeList = {"+-4HRS", "+-2HRS", "0HRS","+-1HRS"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], areaList[i], durationList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("area", areaList[i]);
                intent.putExtra("duration",durationList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}