package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

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
        // sectionLabel.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

    }
}