package net.sanchaya.vachana.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.carrealtime.CarRealTimeApp;
import com.carrealtime.di.CarRealTimeAppComponent;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setToolbarTitle(String mToolbarTitle, boolean showBackButton) {

        try {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mToolbarTitle);

            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(showBackButton);
        } catch (Exception e) {

        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected CarRealTimeAppComponent daggerComponent() {
        return CarRealTimeApp.component(getActivity());
    }
}
