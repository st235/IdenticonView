package sasd97.github.com.identiconview.palette;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;

/**
 * Created by alexander on 28/12/2017.
 */

public class GithubPaletteProvider extends PaletteProvider {

    private static final int inactiveColor = Color.parseColor("#f0f0f0");

    @Override
    public int getActiveColor() {
        float hue = (float) getHashSum() % 255.0f + 125.0f;
        return ColorUtils.HSLToColor(new float[]{hue, 0.35f, 0.65f});
    }

    @Override
    public int getInactiveColor() {
        return inactiveColor;
    }
}
