package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.data.model.Vachana;
import net.sanchaya.vachana.ui.base.BaseMvpFragment;
import net.sanchaya.vachana.ui.util.animutils.DividerItemDecoration;
import net.sanchaya.vachana.ui.views.KanTextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFm extends BaseMvpFragment<VachanaPresenter,IHomeView> implements IHomeView,
    VachanaAdapter.OnClick {
  private static final String TAG = MainFm.class.getSimpleName();
  @BindView(R.id.recycler) RecyclerView recycler;
  List<Vachana> mVachanas;
  @Inject VachanaPresenter mPresenter;
  public MainFm() {
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.bind(this, mView);
    daggerComponent().inject(this);
    try {
      mVachanas = mPresenter.getFromAssets(getActivity());
    } catch (Exception mE) {
      mE.printStackTrace();
    }
    return mView;
  }

  @Override public void onStart() {
    super.onStart();

  }

  @Override public VachanaPresenter getPresenter() {
    return mPresenter;
  }

  @Override public IHomeView getMvpView() {
    return this;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    recycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
    recycler.setAdapter(new VachanaAdapter(this,mVachanas));
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context context() {
    return null;
  }

  @Override public void onVachanaClick(int id, KanTextView mName,Vachana mVachana) {
    ShowVachanaDialogFm mFm = ShowVachanaDialogFm.newInstance(mVachanas,id,mVachana);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      mFm.setEnterTransition(new Fade());
      setExitTransition(new Fade());
    }

    getActivity().getSupportFragmentManager()
        .beginTransaction()
        .addSharedElement(mName,"name")
        .add(mFm,null)
        .addToBackStack(TAG)
        .commit();

  }
}
