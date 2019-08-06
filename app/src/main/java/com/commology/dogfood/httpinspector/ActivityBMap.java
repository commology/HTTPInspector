package com.commology.dogfood.httpinspector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class ActivityBMap extends AppCompatActivity {

    private static final String TAG = "ActivityBMap";

    private MapView mBMapView;
    private BaiduMap mBMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmap);

        mBMapView = findViewById(R.id.bmap_mapview);
        if (mBMap != null) {
            mBMap = mBMapView.getMap();
        }

        LatLng point = new LatLng(39.963175, 116.400244);

        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round);

        //OverlayOptions option = new MarkerOptions()
        //        .position(point)
        //        .icon(bitmap);

        //mBMap.addOverlay(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBMapView.onPause();
    }
}
