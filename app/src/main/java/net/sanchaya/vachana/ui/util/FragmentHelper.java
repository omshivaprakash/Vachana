package net.sanchaya.vachana.ui.util;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Anu
 */
public class FragmentHelper {

    /**
     * this method won't add fragment to backstack
     *
     * @param activity
     * @param containerId
     * @param fragment
     * @param tag
     */
    public static void replaceContentFragment(final Activity activity, final int containerId,
                                              final Fragment fragment, String tag) {
        if (activity != null && !activity.isFinishing() && fragment != null) {
            FragmentTransaction
                beginTransaction = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(containerId, fragment, tag).commitAllowingStateLoss();
        }
    }

    /**
     * this method won't add fragment to backstack
     *
     * @param activity
     * @param containerId
     * @param fragment
     */
    public static void replaceContentFragment(final Activity activity, final int containerId,
                                              final Fragment fragment) {
        if (activity != null && !activity.isFinishing() && fragment != null) {
            FragmentTransaction
                beginTransaction = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(containerId, fragment).commit();
        }
    }

    /**
     * this method will add fragment to backstack
     *
     * @param activity
     * @param containerId
     * @param fragment
     * @param tag
     */
    public static void replaceAndAddContentFragment(final Activity activity, final int containerId,
                                                    final Fragment fragment, String tag) {
        if (activity != null && !activity.isFinishing() && fragment != null) {
            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
    }

    public static void popContentFragment(final Activity activity, String tag) {
        if (activity != null && !activity.isFinishing()) {
            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            manager.popBackStack();
        }
    }

    public static void clearBackStack(final Activity activity) {
        try {
            if (null != activity)
                ((AppCompatActivity) activity).getSupportFragmentManager().popBackStackImmediate(null,
                                                                                                 FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static Fragment getFragment(final Activity activity, final int containerId) {
        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        return fragmentManager.findFragmentById(containerId);
    }

}
