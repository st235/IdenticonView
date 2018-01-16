// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package sasd97.github.com.identiconview.field;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import sasd97.github.com.identiconview.HashHolder;

/**
 * Created by alexander on 27/12/2017.
 */

public abstract class IdenticonFieldProvider extends HashHolder {

    @IntRange(from = 1)
    public abstract int getFieldCapacity();
    public abstract boolean isCellActive(int column, int row);
}
