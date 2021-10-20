package com.mrm.webview;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class WebViewClient extends android.webkit.WebViewClient {
    private final Activity activity;

    public WebViewClient(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        if ("journaldev.com/".equals(request.getUrl().getHost())) {
            // This is my website, so do not override; let my WebView load the page
            return false;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
        activity.startActivity(intent);
        return true;
    }
}
