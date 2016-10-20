package safirco.taxijet.driver.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import safirco.taxijet.driver.R;
import safirco.taxijet.driver.fragments.LoginFragment;

/**
 * Created by khakzad on 9/13/2016.
 */

public class MobileAuthActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_mobileauth);
        ButterKnife.bind(this);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        mFragmentManager.beginTransaction().add(R.id.fragment_placeholder, new LoginFragment(), "LoginFragment").setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).commit();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        float density = metrics.density;
        int dpi = metrics.densityDpi;
    }
}
