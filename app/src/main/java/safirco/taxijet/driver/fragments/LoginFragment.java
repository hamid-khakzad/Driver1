package safirco.taxijet.driver.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import safirco.taxijet.driver.R;
import safirco.taxijet.driver.network.TaxijetApiInterface;

import static android.content.ContentValues.TAG;

/**
 * Created by khakzad on 9/17/2016.
 */

public class LoginFragment extends Fragment {
    @BindView(R.id.next_button)
    Button nextLevelBtn;

    @OnClick(R.id.next_button)
    public void submit() {
    /*    Toast.makeText(getActivity(), "test", LENGTH_SHORT).show();
        FragmentTransaction fts = getFragmentManager().beginTransaction();
        fts.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        fts.replace(R.id.fragment_placeholder, new SmsTokenFragment(), "fragment");
        fts.commit();*/
        HashMap<String, String> map = new HashMap<>();
//put something inside the map, could be null
        map.put("mobileNumber", "09132124770");

        final String BASE_URL = "http://185.126.202.85:80/api/v1/services/TaxiBookingService/1.0.0/";
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


       final RequestBody body =
                RequestBody.create(MediaType.parse("application/json"), new JSONObject(map).toString());
       final TaxijetApiInterface taxijetEndpoint =
                retrofit.create(TaxijetApiInterface.class);
        String username = "09132124770";
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= 10000; i++) {
                    Call<ResponseBody> result0 = taxijetEndpoint.checkDriverMobileNumber(body);
                    result0.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Check Driver: " + response);

                                if (rawResponse.isSuccessful()) {
                                    Log.d("Retrofit Response:  ", response);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Check Driver Error: " + sw.toString() );

                        }
                    });
    Call<ResponseBody> result1 = taxijetEndpoint.checkDriverMobileNumber(body);
    result1.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
            try {
                final String response = rawResponse.body().string();
                //get your response....
                Log.d(TAG, "RetroFit2.0 :Retro Check Driver: " + response);

                if (rawResponse.isSuccessful()) {
                    Log.d("Retrofit Response:  ", response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
            // other stuff...
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            // stack trace as a string
            Log.d(TAG, "RetroFit2.0 :Retro Check Driver Error: " + sw.toString() );

        }
    });
                    Call<ResponseBody> result3 = taxijetEndpoint.checkDriverMobileNumber(body);
                    result3.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Check Driver: " + response);

                                if (rawResponse.isSuccessful()) {
                                    Log.d("Retrofit Response:  ", response);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Check Driver Error: " + sw.toString() );

                        }
                    });
/*
                    Call<ResponseBody> result2 = taxijetEndpoint.sendGcmMessage();
                    result2.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result3 = taxijetEndpoint.sendGcmMessage();
                    result3.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result4 = taxijetEndpoint.sendGcmMessage();
                    result4.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result5 = taxijetEndpoint.sendGcmMessage();
                    result5.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result6 = taxijetEndpoint.sendGcmMessage();
                    result6.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result7 = taxijetEndpoint.sendGcmMessage();
                    result7.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });

                    Call<ResponseBody> result8 = taxijetEndpoint.sendGcmMessage();
                    result8.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });

                    Call<ResponseBody> result9 = taxijetEndpoint.sendGcmMessage();
                    result9.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result10 = taxijetEndpoint.sendGcmMessage();
                    result10.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result11 = taxijetEndpoint.sendGcmMessage();
                    result11.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result12 = taxijetEndpoint.sendGcmMessage();
                    result12.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result13 = taxijetEndpoint.sendGcmMessage();
                    result13.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result14 = taxijetEndpoint.sendGcmMessage();
                    result14.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result15 = taxijetEndpoint.sendGcmMessage();
                    result15.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result16 = taxijetEndpoint.sendGcmMessage();
                    result16.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result17 = taxijetEndpoint.sendGcmMessage();
                    result17.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result18 = taxijetEndpoint.sendGcmMessage();
                    result18.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result19 = taxijetEndpoint.sendGcmMessage();
                    result19.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result20 = taxijetEndpoint.sendGcmMessage();
                    result20.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result21 = taxijetEndpoint.sendGcmMessage();
                    result21.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result22 = taxijetEndpoint.sendGcmMessage();
                    result22.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result23 = taxijetEndpoint.sendGcmMessage();
                    result23.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result24 = taxijetEndpoint.sendGcmMessage();
                    result24.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result25 = taxijetEndpoint.sendGcmMessage();
                    result25.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result26 = taxijetEndpoint.sendGcmMessage();
                    result26.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result27 = taxijetEndpoint.sendGcmMessage();
                    result27.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result28 = taxijetEndpoint.sendGcmMessage();
                    result28.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result29 = taxijetEndpoint.sendGcmMessage();
                    result29.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result30 = taxijetEndpoint.sendGcmMessage();
                    result30.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result31 = taxijetEndpoint.sendGcmMessage();
                    result31.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result32 = taxijetEndpoint.sendGcmMessage();
                    result32.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result33 = taxijetEndpoint.sendGcmMessage();
                    result33.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result34 = taxijetEndpoint.sendGcmMessage();
                    result34.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result35 = taxijetEndpoint.sendGcmMessage();
                    result35.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result36 = taxijetEndpoint.sendGcmMessage();
                    result36.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result37 = taxijetEndpoint.sendGcmMessage();
                    result37.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result38 = taxijetEndpoint.sendGcmMessage();
                    result38.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result39 = taxijetEndpoint.sendGcmMessage();
                    result39.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });
                    Call<ResponseBody> result40 = taxijetEndpoint.sendGcmMessage();
                    result40.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                            try {
                                final String response = rawResponse.body().string();
                                //get your response....
                                Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message : " + response);

                                if (rawResponse.isSuccessful()) {
                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //TODO: update your UI
                                            //  Toast.makeText(getActivity(), response, LENGTH_SHORT).show();
                                            Log.d("Retrofit Response:  ", response);
                                        }

                                    });
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                            // other stuff...
                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            throwable.printStackTrace(pw);
                            // stack trace as a string
                            Log.d(TAG, "RetroFit2.0 :Retro Send Gcm Message Error: " + sw.toString() );
                        }
                    });*/
                }
            }





        };
        thread.start();
}



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, fragmentLayout);
        return fragmentLayout;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
