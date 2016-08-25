package net.sanchaya.vachana.ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class KanTextView extends TextView {
  Typeface normalTypeface =
      Typeface.createFromAsset(getContext().getAssets(), "fonts/BalooTamma-Regular.ttf");

  public KanTextView(Context context) {
    super(context);
  }
  public KanTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public KanTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public KanTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override public void setTypeface(Typeface tf, int style) {
    super.setTypeface(tf, style);
      super.setTypeface(normalTypeface);
    }
}
