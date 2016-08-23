package net.sanchaya.vachana.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.Menu;
import android.view.Window;
import butterknife.ButterKnife;
import com.carrealtime.R;

/**
 * Created by sandeepcmsm on 22/06/16.
 */

public class LoginActivity extends AppCompatActivity
    implements SelectCountryFragment.OnSelectCountry {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
     //inside your activity (if you did not enable transitions in your theme)
    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
     //set an enter transition
    //Fade mEnterTransition = new Fade(Visibility.MODE_IN);
    //mEnterTransition.setDuration(1000);
    //getWindow().setEnterTransition(mEnterTransition);
     //set an exit transition
    Slide mExitTransition = new Slide(Gravity.LEFT);
    //mExitTransition.setDuration(1000);
    getWindow().setExitTransition(mExitTransition);
    setContentView(R.layout.empty_layout);
    //setupWindowAnimations1();
    ButterKnife.bind(this);
    launchLoginFragment();
  }

  private void setupWindowAnimations1() {
    // Re-enter transition is executed when returning to this activity
    Slide slideTransition = new Slide();
    slideTransition.setSlideEdge(Gravity.LEFT);
    slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
    getWindow().setReenterTransition(slideTransition);
    Slide mSlideIn = new Slide();
    mSlideIn.setSlideEdge(Gravity.RIGHT);
    mSlideIn.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
    getWindow().setExitTransition(mSlideIn);
  }

  private void setupWindowAnimations() {
    Visibility enterTransition = buildEnterTransition();
    getWindow().setEnterTransition(enterTransition);
  }

  private Visibility buildEnterTransition() {
    Fade enterTransition = new Fade();
    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
    // This view will not be affected by enter transition animation
    //enterTransition.excludeTarget(R.id.square_red, true);
    return enterTransition;
  }

  private Visibility buildReturnTransition() {
    Visibility enterTransition = new Slide();
    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
    return enterTransition;
  }

  private void launchLoginFragment() {
    Transition explodeTransform = TransitionInflater.from(this).
        inflateTransition(android.R.transition.slide_left);
    LoginFragment mLoginFragment = LoginFragment.newInstance();
    mLoginFragment.setEnterTransition(explodeTransform);
    mLoginFragment.setExitTransition(explodeTransform);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, LoginFragment.newInstance(), null)
        .commit();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    //        return super.onCreateOptionsMenu(menu);
    return true;
  }

  private void launchRegisterFragment(String mS) {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, RegisterFragment.newInstance(mS), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        .commit();
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
  }

  @Override public void onCountrySelected(String mS, RegisterFragment mRegisterFragment) {
    //launchRegisterFragment(mS);

  }
}
