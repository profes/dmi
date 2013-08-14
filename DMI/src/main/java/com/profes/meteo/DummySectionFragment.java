package com.profes.meteo;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_main_dummy)
public class DummySectionFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @ViewById
    TextView sectionLabel;

    @AfterViews
    void afterViews() {
        sectionLabel.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
    }
}