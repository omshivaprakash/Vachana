package net.sanchaya.vachana.ui.home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.data.model.Vachana;
import net.sanchaya.vachana.ui.views.KanTextView;

public class VachanaAdapter extends RecyclerView.Adapter<VachanaAdapter.ViewHolder> {

  List<Vachana> mVachanas = null;
  Context mContext;
  OnClick mOnClick;

  interface OnClick {
    void onVachanaClick(int id, KanTextView mName);
  }

  public VachanaAdapter() {
  }

  public VachanaAdapter(MainFm mFm, List<Vachana> mList) {
    mOnClick = mFm;
    mVachanas = mList;
    mContext = mFm.getActivity();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View post = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycler_trip_list, parent, false);
    return new ViewHolder(post);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    final Vachana mVachana = mVachanas.get(position);
    holder.name.setText(mVachana.getId() + "");
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View mView) {
        mOnClick.onVachanaClick(mVachana.getId(),holder.name);
      }
    });
  }

  @Override public int getItemCount() {
    return mVachanas != null ? mVachanas.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    KanTextView name;

    public ViewHolder(View view) {
      super(view);
      Typeface normalTypeface =
          Typeface.createFromAsset(mContext.getAssets(), "fonts/BalooTamma-Regular.ttf");
      name = (KanTextView) view.findViewById(R.id.name);
      name.setTypeface(normalTypeface);
    }
  }
}
