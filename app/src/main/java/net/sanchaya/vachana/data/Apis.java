package net.sanchaya.vachana.data;

import com.carrealtime.data.simulationmodel.TripDetails;
import com.carrealtime.data.simulationmodel.TripList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface Apis {

  @GET("/vehicle/{vehicleId}/trip/") Observable<TripList> getTripList(
      @Path("vehicleId") String vehiceleId);

  @GET("/vehicle/{vehicleId}/trip/{tripId}/") Observable<TripDetails> getTripList(
      @Path("vehicleId") String vehiceleId, @Path("tripId") String tripId);
}
