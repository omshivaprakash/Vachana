package net.sanchaya.vachana.ui.base;

import java.lang.ref.WeakReference;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private WeakReference<T> view;
    private CompositeSubscription subs = new CompositeSubscription();

    @Override
    public void takeView(T t) {
        view = new WeakReference<>(t);
    }

    @Override
    public void detachFromView() {
        if (subs.hasSubscriptions()) subs.clear();
    }

    protected final void addSubscription(Subscription subscription) {
        subs.add(subscription);
    }

    protected T getView() {
        return view.get();
    }
}
