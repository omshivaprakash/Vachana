package net.sanchaya.vachana.data;

import net.sanchaya.vachana.data.model.Vachanaa;
import retrofit2.http.GET;
import rx.Observable;

public interface Apis {

  @GET("today_vachana") Observable<Vachanaa> getTodayVachana();
}
