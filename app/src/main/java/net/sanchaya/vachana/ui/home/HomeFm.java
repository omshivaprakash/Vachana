package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.data.model.Vachanaa;
import net.sanchaya.vachana.ui.base.BaseMvpFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFm extends BaseMvpFragment<VachanaPresenter, IHomeView> implements IHomeView {
  private static final String TAG = HomeFm.class.getSimpleName();
  //Vachanaa mVachana;
  @Inject VachanaPresenter mPresenter;
  @BindView(R.id.vachana) TextView vachana;
  @BindView(R.id.allama) Button allama;

  public HomeFm() {
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.fragment_home, container, false);
    ButterKnife.bind(this, mView);
    setFontTypeFace();
    daggerComponent().inject(this);
    try {
      mPresenter.getTodayVachana();
    } catch (Exception mE) {
      mE.printStackTrace();
    }
    return mView;
  }

  private void setFontTypeFace() {
    Typeface normalTypeface =
        Typeface.createFromAsset(getActivity().getAssets(), "fonts/BalooTamma-Regular.ttf");
    vachana.setTypeface(normalTypeface);
    allama.setTypeface(normalTypeface);

  }

  @Override public void onStart() {
    super.onStart();
  }

  @Override public VachanaPresenter getPresenter() {
    return mPresenter;
  }

  @Override public IHomeView getMvpView() {
    return this;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
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

  @Override public Context context() {
    return null;
  }

  @Override public void updateTodayVachana(Vachanaa mVachanaa) {
    vachana.setText(mVachanaa.getVachana().getVachana());
  }

  @OnClick(R.id.allama) public void onClick() {
    launchAllamaFm();
  }

  private void launchAllamaFm() {
    MainFm mFm = MainFm.newInstance();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      mFm.setEnterTransition(new Fade());
      setExitTransition(new Fade());
    }

    getActivity().getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.content, mFm)
        .addToBackStack(TAG)
        .commit();
  }
}
