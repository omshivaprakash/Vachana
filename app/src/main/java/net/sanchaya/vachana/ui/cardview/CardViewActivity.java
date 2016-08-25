package net.sanchaya.vachana.ui.cardview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.List;
import net.sanchaya.vachana.R;
import net.sanchaya.vachana.data.model.Vachana;

public class CardViewActivity extends AppCompatActivity
    implements View.OnClickListener {

  private ViewPager mViewPager;

  private CardPagerAdapter mCardAdapter;
  private ShadowTransformer mCardShadowTransformer;
  private CardFragmentPagerAdapter mFragmentCardAdapter;
  private ShadowTransformer mFragmentCardShadowTransformer;

  private boolean mShowingFragments = false;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_card);
    List<Vachana> mVachanas = getIntent().getParcelableArrayListExtra("vachana");

    mViewPager = (ViewPager) findViewById(R.id.viewPager);

    mCardAdapter = new CardPagerAdapter(mVachanas);
    mFragmentCardAdapter =
        new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));

    mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
    mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

    mViewPager.setAdapter(mCardAdapter);
    mViewPager.setPageTransformer(false, mCardShadowTransformer);
    mViewPager.setOffscreenPageLimit(3);
  }

  @Override public void onClick(View view) {

  }

  public static float dpToPixels(int dp, Context context) {
    return dp * (context.getResources().getDisplayMetrics().density);
  }
}
