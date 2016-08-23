package net.sanchaya.vachana;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import com.carrealtime.di.CarRealTimeAppComponent;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by sandeepcmsm on 14/06/16.
 */

public class VachanaApp extends MultiDexApplication {

    private CarRealTimeAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        component = CarRealTimeAppComponent.Initializer.init(this);
        component(this).inject(this);

    }

    @Override protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static CarRealTimeAppComponent component(Context context) {
        return ((VachanaApp) context.getApplicationContext()).component;
    }
}
