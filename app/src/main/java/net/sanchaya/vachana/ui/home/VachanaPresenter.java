package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.sanchaya.vachana.data.Apis;
import net.sanchaya.vachana.data.model.Vachana;
import net.sanchaya.vachana.data.model.Vachanaa;
import net.sanchaya.vachana.ui.base.BasePresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VachanaPresenter extends BasePresenter<IHomeView> {

  @Inject Apis mApis;

  @Inject @Singleton public VachanaPresenter() {
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  @Override public void destroy() {

  }

  public List<Vachana> getFromAssets(Context mContext) throws Exception {
    AssetManager mAssetManager = mContext.getAssets();
    BufferedReader reader = null;
    reader = new BufferedReader(new InputStreamReader(mAssetManager.open("allama.json")));

    StringBuilder sb = new StringBuilder();
    String mLine = reader.readLine();
    while (mLine != null) {
      sb.append(mLine); // process line
      mLine = reader.readLine();
    }
    reader.close();
    List<Vachana> mFromAssets = new Gson().fromJson(sb.toString(), new TypeToken<List<Vachana>>() {
    }.getType());

    return mFromAssets;
  }

  public void getPreviousVachana() {

  }

  public void getNextVachana() {

  }

  public void getTodayVachana() {
    addSubscription(mApis.getTodayVachana()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Subscriber<Vachanaa>() {
          @Override public void onCompleted() {
            // TODO: 26/08/16
          }

          @Override public void onError(Throwable e) {
            // TODO: 26/08/16
          }

          @Override public void onNext(Vachanaa mVachanaa) {
              getView().updateTodayVachana(mVachanaa);
          }
        }));
  }
}
