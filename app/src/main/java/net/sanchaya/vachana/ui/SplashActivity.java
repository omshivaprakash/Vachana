package net.sanchaya.vachana.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import com.carrealtime.R;
import com.carrealtime.ui.login.LoginActivity;
import com.carrealtime.ui.util.Utils;
import com.carrealtime.ui.util.animutils.TransitionHelper;

public class SplashActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

    super.onCreate(savedInstanceState);
    //setupWindowAnimations();
    setContentView(R.layout.splash);
    closeActivity();
  }

  private void setupWindowAnimations() {
    Visibility enterTransition = buildEnterTransition();
    //getWindow().setEnterTransition(enterTransition);
    getWindow().setExitTransition(new Slide(Gravity.LEFT));
  }

  private Visibility buildEnterTransition() {
    Fade enterTransition = new Fade();
    Fade mFade = new Fade();
    mFade.setMode(Visibility.MODE_IN);
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

  private void closeActivity() {
    if (!Utils.isConnected(this)) {
      Utils.showAlertDialog(this, "No Internet", "There is no connection. Please "
          + "Connect your "
          + "device to internet.\n Try again"
          + ".", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
          dialog.cancel();
          //supportFinishAfterTransition();
          finish();
        }
      });
      return;
    }

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        Intent mIntent = new Intent(SplashActivity.this, LoginActivity.class);
        final Pair<View, String>[] pairs =
            TransitionHelper.createSafeTransitionParticipants(SplashActivity.this, true);

        ActivityOptionsCompat mActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this, pairs);
        SplashActivity.this.startActivity(mIntent, mActivityOptionsCompat.toBundle());
        overridePendingTransition(0, R.anim.splash_fade_out);
        SplashActivity.this.finish();
        //supportFinishAfterTransition();
      }
    }, 1000);
  }
}
