package net.sanchaya.vachana;

import android.app.Application;
import android.content.Context;
import net.sanchaya.vachana.di.VachanaAppComponent;
import timber.log.Timber;

/**
 * Created by sandeepcmsm on 14/06/16.
 */

public class VachanaApp extends Application {

    private VachanaAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        component = VachanaAppComponent.Initializer.init(this);
        component(this).inject(this);

    }

    @Override protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }

    public static VachanaAppComponent component(Context context) {
        return ((VachanaApp) context.getApplicationContext()).component;
    }
}
