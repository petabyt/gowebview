package __APPID__;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebSettings;


import webview.Webview;

public class MainActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Create webview with debugging ON, this is very helpful
        WebView webview = findViewById(R.id.WebView);
        webview.setWebContentsDebuggingEnabled(true);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultTextEncodingName("utf-8");

        webview.loadUrl("file:///android_asset/index.html");
        webview.addJavascriptInterface(new backend(), "backend");
    }
}

class backend {
    @JavascriptInterface
    public String test() {
        return Webview.verses().split("\0")[1];
    }
}
