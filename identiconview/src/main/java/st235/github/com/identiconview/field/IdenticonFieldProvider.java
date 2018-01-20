// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package st235.github.com.identiconview.field;

import android.support.annotation.IntRange;

import st235.github.com.identiconview.HashHolder;

public abstract class IdenticonFieldProvider extends HashHolder {

    @IntRange(from = 1)
    public abstract int getFieldCapacity();
    public abstract boolean isCellActive(int column, int row);
}
