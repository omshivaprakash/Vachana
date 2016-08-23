package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.carrealtime.R;
import com.carrealtime.ui.LocationFragment;
import com.carrealtime.ui.base.DrawerActivity;

public class MainActivity extends DrawerActivity {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.container) FrameLayout container;
  @BindView(R.id.main_layout) CoordinatorLayout mainLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    // inside your activity (if you did not enable transitions in your theme)
    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    // set an enter transition
    getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
    // set an exit transition
    getWindow().setExitTransition(new Slide(Gravity.LEFT));
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
    setupDefaultDrawer(toolbar);
    //getSupportActionBar().setLogo(getResources().getDrawable(R.drawable.ic_car_white));
    launchMainFragment();
    final CoordinatorLayout frameLayout = (CoordinatorLayout) findViewById(R.id.main_layout);
    frameLayout.getBackground().setAlpha(0);
/*   final FloatingActionsMenu fabMenu = (FloatingActionsMenu) findViewById(R.id.fab_menu);
    fabMenu.setOnFloatingActionsMenuUpdateListener(
        new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
          @Override public void onMenuExpanded() {
            frameLayout.getBackground().setAlpha(240);
            frameLayout.setOnTouchListener(new View.OnTouchListener() {
              @Override public boolean onTouch(View v, MotionEvent event) {
                fabMenu.collapse();
                return true;
              }
            });
          }

          @Override public void onMenuCollapsed() {
            frameLayout.getBackground().setAlpha(0);
            frameLayout.setOnTouchListener(null);
          }
        });*/

  }

  private void launchMainFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, new MainActivityFragment(), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.slide_out_right)
        .commit();
  }

  private void openFragment(String mS) {
    getSupportFragmentManager().beginTransaction()
        .add(R.id.container, LocationFragment.newInstance(mS), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        .commit();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    switch (id) {
      case R.id.action_settings:
        Toast.makeText(this, "Settings Tapped", Toast.LENGTH_SHORT).show();
        break;
      case R.id.action_aboutUs:
        Toast.makeText(this, "About Us Tapped", Toast.LENGTH_SHORT).show();
        break;

      case R.id.action_contactUs:
        Toast.makeText(this, "Contact Us Tapped", Toast.LENGTH_SHORT).show();
        break;

      case R.id.action_faq:
        Toast.makeText(this, "FAQ Tapped", Toast.LENGTH_SHORT).show();
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  /*@OnClick({
      R.id.fab_location, R.id.fab_alarm, R.id.fab_check, R.id.fab_analysis, R.id.fab_data,
      R.id.fab_menu, R.id.toolbar
  })

  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fab_location:
        openFragment("Vehicle location");
        break;
      case R.id.fab_alarm:
        openFragment("Vehicle Alarm");
        break;
      case R.id.fab_check:
        openFragment("Vehicle Check");

        break;
      case R.id.fab_analysis:
        openFragment("Vehicle Analysis");

        break;
      case R.id.fab_data:
        openFragment("Vehicle Data");
        break;
      case R.id.toolbar:
        launchMainFragment();
        break;
    }
  }*/

  public static Intent getCallingIntent(Context mContext) {
    Intent mIntent = new Intent(mContext, MainActivity.class);

    return mIntent;
  }
}
