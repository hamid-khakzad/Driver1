package safirco.taxijet.driver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khakzad on 9/21/2016.
 */

public class CheckRegisterParam {

    @SerializedName("mobile_number")
    String mobileNumber;

    public CheckRegisterParam(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
