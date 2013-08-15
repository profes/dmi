package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_main_dummy)
public class DummySectionFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @App
    MyApplication application;

    @ViewById
    ImageView image;

    @AfterViews
    void afterViews() {
        application.getImageLoader().get(
                "http://servlet.dmi.dk/byvejr/servlet/byvejr_dag1?mode=long&by=1000",
                ImageLoader.getImageListener(image, R.drawable.ic_launcher, android.R.drawable.ic_dialog_alert));
    }
}