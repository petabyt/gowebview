package __APPID__;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebSettings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.webkit.WebViewClient;


import webview.Webview;

public class MainActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

	private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

		// Get initial configuration
		final String[] startup = Webview.startup().split("\0");

        // Create webview with debugging ON, this is very helpful
		webview = (WebView) findViewById(R.id.WebView);
        webview.setWebContentsDebuggingEnabled(true);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultTextEncodingName("utf-8");

		// Load requested URL
        webview.loadUrl(startup[0]);

		// Load startup code once webview has finished loading
		webview.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String weburl){
                webview.loadUrl("javascript:" + startup[1]);
            }
        });

        webview.addJavascriptInterface(new backend(), "b");
    }
}

// Access like "b.test()"
class backend {
    @JavascriptInterface
    public String test() {
        return Webview.test();
    }
}
