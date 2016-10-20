package safirco.taxijet.driver.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import safirco.taxijet.driver.R;

/**
 * Created by khakzad on 9/17/2016.
 */

public class SmsTokenFragment extends Fragment {

    @BindView(R.id.description_text)
    TextView mDescriptionText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout=inflater.inflate(R.layout.fragment_smscode,container,false);
        ButterKnife.bind(this,fragmentLayout);
        mDescriptionText.setText(String.format(getString(R.string.smscode_description),"09132124770"));
        return fragmentLayout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
