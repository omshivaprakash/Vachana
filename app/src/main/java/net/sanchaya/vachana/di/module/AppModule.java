package net.sanchaya.vachana.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module public class AppModule {

  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides Context provideContext() {
    return application;
  }


/*  @Provides RealmConfiguration provideRealmConfiguration(Context context) {
    return new RealmConfiguration.Builder(context).deleteRealmIfMigrationNeeded().build();
  }

  @Provides @Singleton Realm provideRealm(RealmConfiguration configuration) {
    return Realm.getInstance(configuration);
  }


  @Provides @Singleton
  Crashlytics provideCrashlytics() {
    return new Crashlytics();
  }*/
}
