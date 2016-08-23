package net.sanchaya.vachana.ui.login;

/**
 * Created by sandeepcmsm on 22/06/16.
 */

public class LoginPresenter {

    ILoginView mView;

    public LoginPresenter() {
    }

    public void setView(ILoginView mLoginView) {
        mView = mLoginView;
    }

  public void login() {
    mView.goToHome();
  }

  public void register() {
    mView.goToHome();
  }
}


