package net.sanchaya.vachana.di.module;

import com.carrealtime.ui.login.LoginPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by sandeepcmsm on 21/06/16.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }


}
