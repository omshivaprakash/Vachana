package net.sanchaya.vachana.ui.webview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.VachanaApp;

import static android.app.Activity.RESULT_OK;
import static net.sanchaya.vachana.ui.webview.WebviewActivity.FINISH_URL_STRING;
import static net.sanchaya.vachana.ui.webview.WebviewActivity.POST_DATA;
import static net.sanchaya.vachana.ui.webview.WebviewActivity.URL_STRING;

public class WebFragment extends Fragment {


    @BindView(R.id.web_view) WebView mWebView;
    @BindView(R.id.progress_bar) ProgressBar mProgressBar;
    private String mUrl;
    private String finishUrl ;
    private String postData;
    public static final String ABOUT_US="www.wikibackpacker.com";

    public static WebFragment getInstance(String url, String finishUrl, String postData) {
        WebFragment webFragment = new WebFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(URL_STRING, url);
        bundle.putString(FINISH_URL_STRING, finishUrl);
        bundle.putString(POST_DATA, postData);
        webFragment.setArguments(bundle);
        return webFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview_layout, container, false);
        ButterKnife.bind(this, view);
        mUrl = getArguments().getString(URL_STRING);
        finishUrl = getArguments().getString(FINISH_URL_STRING);
        postData = getArguments().getString(POST_DATA);
        setUpWebView();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setUpWebView() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);

            }
        });
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    private void closeAndShowSuccessScreen() {
        if (getActivity() != null) {
            getActivity().setResult(RESULT_OK);
            getActivity().finish();
        }
    }


    private void closeSelfDelayed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeSelf();
            }
        }, 500);
    }

    private void closeSelf() {
        if (getActivity() == null) return;
        getActivity().finish();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (postData != null)
            mWebView.loadData(postData, "text/html", "utf-8");
        else
            mWebView.loadUrl(ABOUT_US);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            try {
                getActivity().onBackPressed();
            } catch (IllegalStateException ignored) {
                // There's no way to avoid getting this if saveInstanceState has already been called.
                return false;
            }

            return true;
        }
        return false;
    }

    private void finishWithResult(String msg) {
        Intent intent = new Intent();
        intent.putExtra("msg", msg);
        getActivity().setResult(RESULT_OK, intent);
        getActivity().finish();
    }

    private VachanaApp getApp() {
        return ((VachanaApp) getActivity().getApplication());
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
