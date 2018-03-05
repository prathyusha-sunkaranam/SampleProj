package com.example.mansopresk01.sampleproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class WebViewActivity extends AppCompatActivity {

    WebView simpleWebView;
    Button loadWebPage, loadFromStaticHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        simpleWebView = (WebView)findViewById(R.id.simpleWebView);

        String myPdfUrl = "https://www.adobe.com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        String url = "http://docs.google.com/gview?embedded=true&url=" + myPdfUrl;
        Log.i("TAG", "Opening PDF: " + url);
        simpleWebView.getSettings().setJavaScriptEnabled(true);
        simpleWebView.loadUrl(url);
    }

}




//mywebview=(WebView)findViewById(R.id.webView1);
//        mywebview.loadUrl("https://www.javatpoint.com/android-webview-example");