package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

/**
 * Created by ricki on 29/07/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FirstFragment extends Fragment {
 View myView;
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.first_layout,container,false);
        //lista1 = (ListView) myView.findViewById(R.id.listnoticias);
        //return super.onCreateView(inflater, container, savedInstanceState);
/*
      webView=(WebView) myView.findViewById(R.id.webView2);
    webView.getSettings().setJavaScriptEnabled(true);
        String url="http://10.20.0.149/Webservicesnereo/noticia1.php";
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url){
             view.loadUrl(url);
                return true;

            }

        });*/
       return myView;
    }
}
