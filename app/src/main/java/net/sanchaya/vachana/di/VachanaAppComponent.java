package net.sanchaya.vachana.di;

import dagger.Component;
import javax.inject.Singleton;
import net.sanchaya.vachana.VachanaApp;
import net.sanchaya.vachana.di.module.ApiModule;
import net.sanchaya.vachana.di.module.AppModule;
import net.sanchaya.vachana.di.module.PresenterModule;
import net.sanchaya.vachana.ui.home.MainFm;
import net.sanchaya.vachana.ui.home.ShowVachanaDialogFm;

@Singleton @Component(modules = { AppModule.class, ApiModule.class, PresenterModule.class })
public interface VachanaAppComponent {

  void inject(VachanaApp mVachanaApp);

  void inject(MainFm mFm);

  void inject(ShowVachanaDialogFm mShowVachanaDialogFm);

  final class Initializer {
    public static VachanaAppComponent init(VachanaApp app) {
      return DaggerVachanaAppComponent.builder().appModule(new AppModule(app)).build();
    }
  }
}
