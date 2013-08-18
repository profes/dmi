package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@EFragment(R.layout.fragment_radar)
public class RadarFragment extends Fragment {

    public static final String TAG = "com.profes.meteo";
    @App
    MyApplication application;

    @ViewById
    ImageView radar;
    private String requestUrl;

    @AfterViews
    void afterViews() {

        requestUrl = "http://www.dmi.dk/dmi/radar-animation640.gif";

        application.getRequestQueue().add(
                new JsonArrayRequest(getResources().getString(R.string.url_radar_images),
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray jsonArray) {
                                Log.v(TAG, jsonArray.toString());
                                String[] urls = new String[jsonArray.length()];
                                try {
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        String url = jsonObject.getString("src");

                                        Log.v(TAG, "Url: " + url);
                                        urls[i] = url;
                                    }

                                    requestUrl = "http://www.dmi.dk" + urls[urls.length - 1];
                                } catch (JSONException e) {
                                    Log.e(TAG, "Error parsing radar json", e);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e(TAG, "Failed getting radar json " + volleyError.networkResponse, volleyError.getCause());
                            }
                        }
                ));


        application.getImageLoader().get(
                requestUrl,
                ImageLoader.getImageListener(radar, R.drawable.ic_launcher, android.R.drawable.ic_dialog_alert));
    }
}