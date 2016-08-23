package net.sanchaya.vachana.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.carrealtime.R;
import com.carrealtime.ui.util.StringUtil;
import java.util.Calendar;
import java.util.Date;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

  @BindView(R.id.time) TextView time;

  public MainActivityFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.fragment_main, container, false);

    ButterKnife.bind(this, mView);
    return mView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Calendar now = Calendar.getInstance();
    Date mDate = now.getTime();

    String t = mDate.getHours() +":"+mDate.getMinutes();
    time.setText(StringUtil.getFormattedDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
        now.get(Calendar.DAY_OF_MONTH))+t);
        /*

        // Set up the large red button on the center right side
        // With custom button and content sizes and margins
        int redActionButtonSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_size);
        int redActionButtonMargin = getResources().getDimensionPixelOffset(R.dimen.action_button_margin);
        int redActionButtonContentSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_content_size);
        int redActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.red_action_button_content_margin);
        int redActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.red_action_menu_radius);
        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_size);
        int blueSubActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_content_margin);

        ImageView fabIconStar = new ImageView(getActivity());
        fabIconStar.setImageDrawable(getResources().getDrawable(R.drawable.ic_drive_eta_blue_800));

        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(redActionButtonSize, redActionButtonSize);
        starParams.setMargins(
                redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin
        );
        fabIconStar.setLayoutParams(starParams);

        FloatingActionButton.LayoutParams fabIconStarParams = new FloatingActionButton.LayoutParams(redActionButtonContentSize, redActionButtonContentSize);
        fabIconStarParams.setMargins(
                redActionButtonContentMargin,
                redActionButtonContentMargin,
                redActionButtonContentMargin,
                redActionButtonContentMargin
        );

        final FloatingActionButton leftCenterButton = new FloatingActionButton.Builder(getActivity())
                .setContentView(fabIconStar, fabIconStarParams)
                .setBackgroundDrawable(R.drawable.button_action_dark_selector)
                .setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER)
                .setLayoutParams(starParams)
                .build();
        // Set up customized SubActionButtons for the right center menu
        SubActionButton.Builder lCSubBuilder = new SubActionButton.Builder(getActivity());
        lCSubBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_sub_action));

        FrameLayout.LayoutParams blueContentParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        blueContentParams.setMargins(
                blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin
        );
        lCSubBuilder.setLayoutParams(blueContentParams);
        // Set custom layout params
        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(blueSubActionButtonSize, blueSubActionButtonSize);
        lCSubBuilder.setLayoutParams(blueParams);

        ImageView lcIcon1 = new ImageView(getActivity());
        ImageView lcIcon2 = new ImageView(getActivity());
        ImageView lcIcon3 = new ImageView(getActivity());
        ImageView lcIcon4 = new ImageView(getActivity());
        ImageView lcIcon5 = new ImageView(getActivity());
        ImageView lcIcon6 = new ImageView(getActivity());

        lcIcon1.setImageDrawable(getResources().getDrawable(R.drawable.location_pin));

        lcIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_alarm));
        lcIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_drive_eta_blue_800));
        lcIcon4.setImageDrawable(getResources().getDrawable(R.drawable.steering_wheel));
        lcIcon5.setImageDrawable(getResources().getDrawable(R.drawable.ic_trending_up));
        lcIcon6.setImageDrawable(getResources().getDrawable(R.drawable.ic_alarm));

        // Build another menu with custom options
        final FloatingActionMenu leftCenterMenu = new FloatingActionMenu.Builder(getActivity())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon1, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon2, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon3, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon4, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon5, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon6, blueContentParams).build())
                .setRadius(redActionMenuRadius)
                .setStartAngle(180)
                .setEndAngle(360)
                .attachTo(leftCenterButton)
                .build();
        */

  }
}
