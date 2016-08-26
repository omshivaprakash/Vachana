package net.sanchaya.vachana.ui.home;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.VachanaApp;
import net.sanchaya.vachana.data.model.Vachana;
import net.sanchaya.vachana.ui.views.KanTextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShowVachanaDialogFm extends DialogFragment {
  @Inject VachanaPresenter mPresenter;
  List<Vachana> mVachanas;
  Vachana mVachana;
  @BindView(R.id.title) TextView title;
  @BindView(R.id.fav) ImageView fav;
  @BindView(R.id.close) ImageView close;
  @BindView(R.id.name) KanTextView name;
  @BindView(R.id.prev) Button prev;
  @BindView(R.id.next) Button next;
  @BindView(R.id.cardView) CardView cardView;

  public ShowVachanaDialogFm() {
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mVachanas = getArguments().getParcelableArrayList("vachana");
    mVachana = getArguments().getParcelable("v");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.fragment_adapter, container);
    ButterKnife.bind(this, mView);
    VachanaApp.component(getActivity()).inject(this);

    return mView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    Typeface normalTypeface =
        Typeface.createFromAsset(getActivity().getAssets(), "fonts/BalooTamma-Regular.ttf");
    title.setTypeface(normalTypeface);
    name.setTypeface(normalTypeface);
    name.setText(mVachana.getName());
  }

  public static ShowVachanaDialogFm newInstance(List<Vachana> mVachanas, int mId, Vachana mVachana) {
    ShowVachanaDialogFm mFm = new ShowVachanaDialogFm();
    Bundle mBundle = new Bundle();
    mBundle.putParcelableArrayList("vachana", (ArrayList<? extends Parcelable>) mVachanas);
    mBundle.putParcelable("v",mVachana);
    mBundle.putInt("pos", mId);
    mFm.setArguments(mBundle);
    return mFm;
  }

  @OnClick({ R.id.fav, R.id.close, R.id.prev, R.id.next, R.id.cardView })
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fav:

        break;
      case R.id.close:
        dismiss();
        break;
      case R.id.prev:
        mPresenter.getPreviousVachana();
        break;
      case R.id.next:
        mPresenter.getNextVachana();
        break;
      case R.id.cardView:
        break;
    }
  }
}
