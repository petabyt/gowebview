package com.example.myapp;

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
import java.lang.reflect.Method;
import android.content.Context;

import webview.Webview;

public class MainActivity extends Activity {

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)

	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

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
		webview.loadUrl("file:///android_asset/index.html");

		// Load startup code once webview has finished loading
		//webview.setWebViewClient(new WebViewClient(){
		//	public void onPageFinished(WebView view, String weburl){
		//		webview.loadUrl("javascript: ");
		//	}
		//});

		webview.addJavascriptInterface(new backend(this), "b");
	 }

	// Access like "b.test()"
	public class backend {
		Context context;
		backend(Context c) {
			context = c;
		}

		// Here you can manually insert functions you want to bind.
		@JavascriptInterface
		public void toast(String str) {
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
		}
		
		@JavascriptInterface
		public String test() {
			return Webview.test();
		}
	}
}
