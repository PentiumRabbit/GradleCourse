package com.android.libgrable.utils;

import com.android.libgrable.BuildConfig;

/**
 * @author ----zhaoruyang----
 * @data: 2015/4/21
 */
public class GradleUtil {
    private static final String TAG = "GradleUtil";

    public static String getLidType()
    {
        return BuildConfig.lib_ver;
    }
}
