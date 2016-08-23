package net.sanchaya.vachana.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
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
public class LoginFragment extends BaseFragment implements ILoginView {

  @Inject LoginPresenter mPresenter;
  @Inject Navigator mNavigator;
  @BindView(R.id.sign_in) Button signIn;
  @BindView(R.id.register_link) TextView registerLink;

  private LoginFragment() {
  }

  public static LoginFragment newInstance() {
    return new LoginFragment();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.login_fm, null);
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
    //getActivity().finish();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
  }

  @OnClick({ R.id.register_link, R.id.sign_in }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.register_link:
        launchRegisterFm();
        break;
      case R.id.sign_in:
        mPresenter.login();
        break;
    }
  }

  private void launchRegisterFm() {
    getActivity().getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, SocialSignInFragment.newInstance(), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        .addToBackStack(null)
        .commit();
  }
}
