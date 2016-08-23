package net.sanchaya.vachana.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.carrealtime.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectCountryFragment extends Fragment {

  @BindView(R.id.recycler_view) RecyclerView recyclerView;
  OnSelectCountry mOnSelectCountry;
  RegisterFragment mRegisterFragment;

  List<String> countries = new ArrayList<>();

  public static Fragment newInstance(RegisterFragment mRegisterFragment) {

    SelectCountryFragment mSelectCountryFragment = new SelectCountryFragment();
    mSelectCountryFragment.mRegisterFragment = mRegisterFragment;
    return mSelectCountryFragment;
  }

  public interface OnSelectCountry {
    void onCountrySelected(String mS, RegisterFragment mRegisterFragment);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof LoginActivity) mOnSelectCountry = (OnSelectCountry) context;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View mView = inflater.inflate(R.layout.country_layout, null, false);
    ButterKnife.bind(this, mView);
    return mView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    countries.addAll(
        Arrays.asList(getActivity().getResources().getStringArray(R.array.countries_array)));
    CountryAdapter mCountryAdapter = new CountryAdapter();
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(mCountryAdapter);
  }

  class CountryAdapter extends RecyclerView.Adapter<VHolder> {

    @Override public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View mView = parent.inflate(getActivity(), R.layout.country_text_layout, null);
      return new VHolder(mView);
    }

    @Override public void onBindViewHolder(VHolder holder, final int position) {
      holder.countryName.setText(countries.get(position));
      holder.countryName.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          mOnSelectCountry.onCountrySelected(countries.get(position).toString(), mRegisterFragment);
          getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
      });
    }

    @Override public int getItemCount() {
      return (countries.size() != 0) ? countries.size() : 0;
    }
  }

  class VHolder extends RecyclerView.ViewHolder {
    TextView countryName;

    public VHolder(View itemView) {
      super(itemView);
      countryName = (TextView) itemView.findViewById(R.id.country_id);
    }
  }
}
