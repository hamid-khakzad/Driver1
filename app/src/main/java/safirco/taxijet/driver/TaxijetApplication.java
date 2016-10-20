package safirco.taxijet.driver;

import android.app.Application;
import android.content.res.Configuration;

import safirco.taxijet.driver.utils.FontsOverride;

/**
 * Created by khakzad on 9/14/2016.
 */

public class TaxijetApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "SERIF", "IRANSansMobile_Medium.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "IRANSansMobile_Medium.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "IRANSansMobile_Medium.ttf");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
