package net.sanchaya.vachana.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import com.carrealtime.ui.home.MainActivity;
import com.carrealtime.ui.util.animutils.TransitionHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton public class Navigator {

  @Inject public Navigator() {
    //empty
  }

  /**
   * Goes to the home screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToHome(Activity context) {
    if (context != null) {
      Intent intentToLaunch = MainActivity.getCallingIntent(context);
      final Pair<View, String>[] pairs =
          TransitionHelper.createSafeTransitionParticipants(context, true);

      ActivityOptionsCompat mActivityOptionsCompat =
          ActivityOptionsCompat.makeSceneTransitionAnimation(context,pairs);
      context.startActivity(intentToLaunch, mActivityOptionsCompat.toBundle());
    }
  }
}
