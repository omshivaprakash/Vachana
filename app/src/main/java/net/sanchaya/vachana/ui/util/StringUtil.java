package net.sanchaya.vachana.ui.util;

/**
 * Created by sandeepcmsm on 27/06/16.
 */

public final class StringUtil {
  public static void transoform() {
  }

  public static String getAmtInDollars(Integer mPrice) {
    StringBuilder mStringBuilder = new StringBuilder();
    return mStringBuilder.append("$").append(String.valueOf(mPrice)).append(".00").toString();
  }

  public static String getFormattedDate(int mYear, int mMonthOfYear, int mDayOfMonth) {
    return new StringBuilder().append(mDayOfMonth)
        .append("-")
        .append(mMonthOfYear)
        .append("-")
        .append(mYear)
        .toString();
  }
}
