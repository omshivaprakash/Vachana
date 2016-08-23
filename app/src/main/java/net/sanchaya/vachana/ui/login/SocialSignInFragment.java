package net.sanchaya.vachana.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.carrealtime.R;
import com.carrealtime.navigation.Navigator;
import com.carrealtime.ui.base.BaseFragment;
import javax.inject.Inject;

/**
 * Created by sandeepcmsm on 22/06/16.
 */
public class SocialSignInFragment extends BaseFragment implements ILoginView {

  @Inject Navigator mNavigator;
  @Inject LoginPresenter mPresenter;
  @BindView(R.id.google) ImageButton google;
  @BindView(R.id.twitter) ImageButton twitter;
  @BindView(R.id.facebook) ImageButton facebook;
  @BindView(R.id.register) Button register;

  private SocialSignInFragment() {
  }

  public static SocialSignInFragment newInstance() {
    return new SocialSignInFragment();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.social_signin_fm, null);
    ButterKnife.bind(this, mView);
    daggerComponent().inject(this);
    mPresenter.setView(this);

    return mView;
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public void goToHome() {
    mNavigator.navigateToHome(getActivity());
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
  }


  private void launchRegisterFm() {
    getActivity().getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, RegisterFragment.newInstance(null), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        .addToBackStack(null)
        .commit();
  }
  @OnClick({ R.id.google, R.id.twitter, R.id.facebook, R.id.register })
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.google:
        break;
      case R.id.twitter:
        break;
      case R.id.facebook:
        break;
      case R.id.register:
        break;
    }
    //mPresenter.register();
    launchRegisterFm();
  }
}
