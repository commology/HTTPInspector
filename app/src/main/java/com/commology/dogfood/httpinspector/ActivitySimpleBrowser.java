package com.commology.dogfood.httpinspector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ActivitySimpleBrowser extends AppCompatActivity {

    private static final String TAG = "ActivitySimpleBrowser";

    EditText mInputURL;
    Button mButtonGo;

    LinearLayout mLLWebview;
    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_browser);

        mLLWebview = findViewById(R.id.ll_simple_webview_container);
        createWebView();

        mInputURL = findViewById(R.id.text_input_url);
        mInputURL.setText("https://www.qq.com");
        mButtonGo = findViewById(R.id.button_go);
        mButtonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl(mInputURL.getText().toString());
            }
        });
    }

    private boolean createWebView() {
        mWebView = new WebView(getApplication());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView.setLayoutParams(layoutParams);

        mWebSettings = mWebView.getSettings();


        mLLWebview.addView(mWebView);

        return true;
    }

    private boolean destroyWebView() {
        mLLWebview.removeView(mWebView);
        mWebView.stopLoading();
        mWebView.removeAllViews();
        mWebView.destroy();
        mWebView = null;

        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyWebView();
    }
}
