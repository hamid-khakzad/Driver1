package safirco.taxijet.driver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khakzad on 9/21/2016.
 */

public class CheckRegisterResponse {

    @SerializedName("return")
    HttpStatus status;

    @SerializedName("token_status")
    String token;

}
