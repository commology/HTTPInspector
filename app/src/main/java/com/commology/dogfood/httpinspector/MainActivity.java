package com.commology.dogfood.httpinspector;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.commology.dogfood.RecyclerViewAdapter;
import com.commology.dogfood.RecyclerViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> dataset = new ArrayList<>();
        dataset.add("Beijing");
        dataset.add("Shanghai");
        dataset.add("Tianjin");
        dataset.add("Guangzhou");
        dataset.add("Shenzhen");
        recyclerViewAdapter = new RecyclerViewAdapter<String>(dataset, R.layout.main_view) {
            @Override
            public void onItemClick(View view, int position, ArrayList<String> dataset) {
                Toast.makeText(view.getContext(), "Clicked: " + dataset.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBindItemView(@NonNull RecyclerViewHolder holder, int position, ArrayList<String> dataset) {
                TextView textView = holder.itemView.findViewById(R.id.test_text);
                textView.setText(dataset.get(position));
            }
        };

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
