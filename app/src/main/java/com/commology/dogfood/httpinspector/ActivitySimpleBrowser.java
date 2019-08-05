package com.commology.dogfood.httpinspector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class ActivitySimpleBrowser extends AppCompatActivity {

    private static final String TAG = "ActivitySimpleBrowser";

    LinearLayout mLinearLayout;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_browser);

        mLinearLayout = findViewById(R.id.ll_simple_webview);
        createWebView();

        mWebView.loadUrl("https://www.qq.com");
    }

    private boolean createWebView() {
        mWebView = new WebView(getApplication());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView.setLayoutParams(layoutParams);
        mLinearLayout.addView(mWebView);

        return true;
    }

    private boolean destroyWebView() {
        mLinearLayout.removeView(mWebView);
        mWebView.stopLoading();
        mWebView.removeAllViews();
        mWebView.destroy();
        mWebView = null;

        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyWebView();
    }
}
