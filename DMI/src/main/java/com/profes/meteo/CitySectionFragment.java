package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_city)
public class CitySectionFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @App
    MyApplication application;

    @ViewById(R.id.city_48h)
    ImageView imageCity48h;

    @ViewById(R.id.city_7d)
    ImageView imageCity7d;

    @AfterViews
    void afterViews() {

        application.getImageLoader().get(
                "http://servlet.dmi.dk/byvejr/servlet/byvejr_dag1?mode=long&by=1000",
                ImageLoader.getImageListener(imageCity48h, R.drawable.ic_launcher, android.R.drawable.ic_dialog_alert));

        application.getImageLoader().get(
                "http://servlet.dmi.dk/byvejr/servlet/byvejr?by=1000&tabel=dag3_9",
                ImageLoader.getImageListener(imageCity7d, R.drawable.ic_launcher, android.R.drawable.ic_dialog_alert));
    }
}