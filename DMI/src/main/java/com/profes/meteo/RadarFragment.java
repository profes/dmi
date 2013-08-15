package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_radar)
public class RadarFragment extends Fragment {

    @App
    MyApplication application;

    @ViewById
    ImageView radar;

    @AfterViews
    void afterViews() {

        application.getImageLoader().get(
                "http://www.dmi.dk/dmi/radar-animation640.gif",
                ImageLoader.getImageListener(radar, R.drawable.ic_launcher, android.R.drawable.ic_dialog_alert));
        // sectionLabel.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
    }
}