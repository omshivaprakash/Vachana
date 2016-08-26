package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.ui.base.DrawerActivity;

public class MainActivity extends DrawerActivity {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.content) FrameLayout content;

  @Override protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);

    setupDefaultDrawer(toolbar);
    launchMainFragment();
  }

  private void launchMainFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, new HomeFm(), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.slide_out_right)
        .commit();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    return super.onOptionsItemSelected(item);
  }

  public static Intent getCallingIntent(Context mContext) {
    Intent mIntent = new Intent(mContext, MainActivity.class);

    return mIntent;
  }
}
