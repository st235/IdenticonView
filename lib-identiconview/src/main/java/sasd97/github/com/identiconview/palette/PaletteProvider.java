package sasd97.github.com.identiconview.palette;

import android.support.annotation.ColorInt;

import sasd97.github.com.identiconview.HashHolder;

/**
 * Created by alexander on 28/12/2017.
 */

public abstract class PaletteProvider extends HashHolder {

    @ColorInt
    public abstract int getActiveColor();
    @ColorInt
    public abstract int getInactiveColor();

    public int getHashSum() {
        if (hash == null) return 0;

        int result = 0;
        for (byte value: hash) {
            result += value;
        }

        return result;
    }
}
