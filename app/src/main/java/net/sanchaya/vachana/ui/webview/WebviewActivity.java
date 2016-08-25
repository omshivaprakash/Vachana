package net.sanchaya.vachana.ui.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.ui.util.FragmentHelper;

public class WebviewActivity extends AppCompatActivity {

    public static final String URL_STRING = "url";
    public static final String TITLE = "title";
    public static final String FINISH_URL_STRING = "finish_url";
    public static final String POST_DATA = "post_data";
    @BindView(R.id.toolbar_title) TextView mToolbarTitle;
    @BindView(R.id.action_done) TextView mActionDone;
    @BindView(R.id.web_content_container) FrameLayout mWebContentContainer;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        setupToolbar();

        if (getIntent().getExtras() == null) return;
        String url = getIntent().getExtras().getString(URL_STRING);
        String title = getIntent().getExtras().getString(TITLE);
        String finishUrl = getIntent().getExtras().getString(FINISH_URL_STRING);
        String postData = getIntent().getExtras().getString(POST_DATA);

        FragmentHelper.replaceContentFragment(this, R.id.web_content_container, WebFragment.getInstance(url, finishUrl, postData));
    }

    private void setupToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setSupportActionBar(mToolbar);
        }

    }
}
