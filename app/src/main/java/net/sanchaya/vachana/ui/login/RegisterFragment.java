package net.sanchaya.vachana.ui.login;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.carrealtime.R;
import com.carrealtime.navigation.Navigator;
import com.carrealtime.ui.base.BaseFragment;
import com.carrealtime.ui.util.StringUtil;
import java.util.Calendar;
import javax.inject.Inject;

/**
 * Created by sandeepcmsm on 22/06/16.
 */
public class RegisterFragment extends BaseFragment implements ILoginView {

  @Inject Navigator mNavigator;
  @Inject LoginPresenter mPresenter;
  @BindView(R.id.register) Button register;
  @BindView(R.id.country) TextView country;
  @BindView(R.id.dob) TextView dob;
  @BindView(R.id.gender) TextView gender;
  String countryName;

  private RegisterFragment() {
  }

  public static RegisterFragment newInstance(String mS) {
    RegisterFragment mRegisterFragment = new RegisterFragment();
    mRegisterFragment.countryName = mS;
    return mRegisterFragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (countryName != null) country.setText(countryName);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.register_fm, null);
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
    getActivity().finish();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
  }

  @OnClick(R.id.register) public void onClick() {
    mPresenter.register();
  }

  @OnClick({ R.id.country, R.id.dob, R.id.gender }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.country:
        launchCountryFm();
        break;
      case R.id.dob:
        setDob();
        break;
      case R.id.gender:
        setGender();
        break;
    }
  }

  private void setGender() {
    PopupMenu mGenderpopup = new PopupMenu(getActivity(), gender);

    mGenderpopup.getMenuInflater().inflate(R.menu.gender_menu, mGenderpopup.getMenu());
    mGenderpopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      public boolean onMenuItemClick(MenuItem item) {
        gender.setText(item.getTitle());
        return true;
      }
    });
    mGenderpopup.show();
  }

  private void setDob() {

    Calendar now = Calendar.getInstance();
    DatePickerDialog mDatePickerDialog =
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dob.setText(StringUtil.getFormattedDate(year, monthOfYear, dayOfMonth));
          }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

    mDatePickerDialog.show();
  }

  private void launchCountryFm() {
    getActivity().getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content, SelectCountryFragment.newInstance(this), null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        .addToBackStack(null)
        .commit();
  }
}
