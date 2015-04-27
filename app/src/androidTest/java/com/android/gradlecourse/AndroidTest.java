package com.android.gradlecourse;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * @author ----zhaoruyang----
 * @data: 2015/4/27
 */
public class AndroidTest extends AndroidTestCase {
    private static final String TAG = "AndroidTest";

    public AndroidTest() {

    }

    public void testLog() {
        Log.i(TAG, "test log out ");
    }

    public void testSsLog() {
        Log.i(TAG, "test log out ");
    }
}
