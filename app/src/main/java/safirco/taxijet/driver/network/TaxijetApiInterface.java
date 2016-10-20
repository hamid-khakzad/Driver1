package safirco.taxijet.driver.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by khakzad on 9/17/2016.
 */

public interface TaxijetApiInterface {

    @Headers({"application-id: 42446AAE-940B-4DAB-FFC0-D3CC0FB47300", "secret-key: 5D686E2C-A06C-AB7C-FF92-B9A179FBA800","Content-Type: application/json"})
    @POST("checkDriverRegister")
    Call<ResponseBody> checkDriverMobileNumber(@Body RequestBody mobilenumber);


    //@Headers({"application-id: 42446AAE-940B-4DAB-FFC0-D3CC0FB47300", "secret-key: 5D686E2C-A06C-AB7C-FF92-B9A179FBA800","Content-Type: application/json"})
    @POST("sendGcmMessage")
    Call<ResponseBody> sendGcmMessage();
}
