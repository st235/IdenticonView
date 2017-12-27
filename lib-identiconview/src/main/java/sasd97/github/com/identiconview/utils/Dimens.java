package sasd97.github.com.identiconview.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Alex on 31.01.2016.
 */

public final class Dimens {

    private Dimens() {
    }

    public static float spToPx(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                Resources.getSystem().getDisplayMetrics());
    }

    public static float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

    public static float pxToDp(float px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }
}
