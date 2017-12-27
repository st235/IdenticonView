package sasd97.github.com.identiconview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by alexander on 27/12/2017.
 */

public class IdenticonView extends View {

    public IdenticonView(Context context) {
        super(context);
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
