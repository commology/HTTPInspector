package com.commology.dogfood.httpinspector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;

public class ActivityAMap extends AppCompatActivity {

    private static final String TAG = "ActivityAMap";

    private MapView mAMapView;
    private AMap mAMap;

    private MyLocationStyle mMyLocationStyle;

    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;
    private AMapLocationListener mLocationListener;

    public ActivityAMap() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amap);

        mAMapView = findViewById(R.id.amap_mapview);
        mAMapView.onCreate(savedInstanceState);

        if (mAMap == null) {
            mAMap = mAMapView.getMap();
        }

        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //mLocationClient.setLocationListener(this);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setNeedAddress(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();

        mMyLocationStyle = new MyLocationStyle();
        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
        mMyLocationStyle.interval(1000);

        mAMap.setMyLocationStyle(mMyLocationStyle);
        mAMap.getUiSettings().setMyLocationButtonEnabled(true);
        mAMap.setMyLocationEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAMapView.onSaveInstanceState(outState);
    }
}
