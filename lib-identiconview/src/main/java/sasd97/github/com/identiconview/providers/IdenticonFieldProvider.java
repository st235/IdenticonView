// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package sasd97.github.com.identiconview.providers;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 27/12/2017.
 */

public abstract class IdenticonFieldProvider {

    protected volatile byte[] hash;

    @IntRange(from = 1)
    public abstract int getFieldCapacity();
    public abstract void generateFieldFor(@NonNull String text);
    public abstract boolean isCellActive(int column, int row);

    protected byte getByte(int index) {
        return hash == null ? -128 : hash[index % hash.length];
    }
}
