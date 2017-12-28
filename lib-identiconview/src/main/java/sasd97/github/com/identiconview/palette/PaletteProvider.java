package sasd97.github.com.identiconview.palette;

import android.support.annotation.ColorInt;

/**
 * Created by alexander on 28/12/2017.
 */

public interface PaletteProvider {
    @ColorInt int getActiveColor();
    @ColorInt int getInactiveColor();
}
