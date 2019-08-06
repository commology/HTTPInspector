package com.commology.dogfood.httpinspector;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.commology.dogfood.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null)
            for (String permission : permissions)
                if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED)
                    return false;
        return true;
    }

    public static String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.INTERNET
    };

    public final int REQUEST_PERMISSIONS_ALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!hasPermissions(this, PERMISSIONS))
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);

        recyclerView = findViewById(R.id.main_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> dataset = new ArrayList<>();
        dataset.add("Simple Browser");
        dataset.add("Gaode Map");
        dataset.add("Baidu Map");
        dataset.add("Beijing");
        dataset.add("Shanghai");
        dataset.add("Tianjin");
        dataset.add("Guangzhou");
        dataset.add("Shenzhen");
        dataset.add("Wuhan");
        dataset.add("Chengdu");
        dataset.add("Chongqing");
        dataset.add("Zhengzhou");
        dataset.add("Haikou");
        dataset.add("Nanchang");
        dataset.add("Nanjing");
        dataset.add("Wuxi");
        dataset.add("Suzhou");
        dataset.add("Changzhou");
        dataset.add("Hangzhou");
        dataset.add("Qingdao");
        dataset.add("Dalian");
        dataset.add("Xining");
        dataset.add("Yinchuan");
        dataset.add("Shenyang");
        dataset.add("Ningbo");
        dataset.add("Fuzhou");
        dataset.add("Xiamen");
        dataset.add("Xining");
        dataset.add("Wenzhou");
        dataset.add("Anqing");
        dataset.add("Hefei");
        recyclerViewAdapter = new RecyclerViewAdapter<String>(dataset, R.layout.main_view_item) {
            @Override
            public void onClickItem(View view, int position, ArrayList<String> dataset) {
                Toast.makeText(view.getContext(), "Clicked: " + dataset.get(position), Toast.LENGTH_SHORT).show();

                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, ActivitySimpleBrowser.class);
                        view.getContext().startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ActivityAMap.class);
                        view.getContext().startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ActivityBMap.class);
                        view.getContext().startActivity(intent);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onBindItemView(@NonNull RecyclerViewHolder holder, int position, ArrayList<String> dataset) {
                TextView textView = holder.itemView.findViewById(R.id.main_view_item_text);
                textView.setText(dataset.get(position));
            }
        };

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_PERMISSIONS_ALL:
                if (grantResults.length > 0)
                    for (int resultCode : grantResults) {
                        if (resultCode == PackageManager.PERMISSION_DENIED)
                            Toast.makeText(this, "Not enough permissions", Toast.LENGTH_SHORT);
                    }
                break;
            default:
                break;
        }

    }
}
