package net.sanchaya.vachana.di;

import com.carrealtime.CarRealTimeApp;
import com.carrealtime.di.module.AppModule;
import com.carrealtime.di.module.PresenterModule;
import com.carrealtime.di.module.SimulationApiModule;
import com.carrealtime.ui.home.MainActivity;
import com.carrealtime.ui.home.MainActivityFragment;
import com.carrealtime.ui.login.LoginActivity;
import com.carrealtime.ui.login.LoginFragment;
import com.carrealtime.ui.login.RegisterFragment;
import com.carrealtime.ui.login.SocialSignInFragment;
import com.carrealtime.ui.webview.WebviewActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, SimulationApiModule.class, PresenterModule.class})
public interface CarRealTimeAppComponent {

    void inject(MainActivity mainActivity);

    void inject(CarRealTimeApp app);

    void inject(LoginActivity mActivity);

    void inject(WebviewActivity mWebviewActivity);

    void inject(MainActivityFragment mMainActivityFragment);

    void inject(LoginFragment mLoginFragment);

    void inject(RegisterFragment mRegisterFragment);

  void inject(SocialSignInFragment mSocialSignInFragment);

  final class Initializer {
        public static CarRealTimeAppComponent init(CarRealTimeApp app) {
            return DaggerCarRealTimeAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
