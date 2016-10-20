package safirco.taxijet.driver.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by khakzad on 9/21/2016.
 */

public class ApiClient {

    public static final String BASE_URL = "http://185.126.202.85:80/api/v1/services/TaxiBookingService/1.0.0/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
