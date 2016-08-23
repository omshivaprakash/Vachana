package net.sanchaya.vachana.ui.base;

import android.os.Bundle;
import android.view.View;

public abstract class BaseMvpFragment<T extends BasePresenter<V>, V extends IBaseView> extends BaseFragment implements IBaseView {

    public abstract T getPresenter();

    public abstract V getMvpView();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().takeView(getMvpView());
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
        getPresenter().detachFromView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
