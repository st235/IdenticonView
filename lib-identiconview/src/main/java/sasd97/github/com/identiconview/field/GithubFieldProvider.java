package sasd97.github.com.identiconview.field;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alexander on 27/12/2017.
 */

public class GithubFieldProvider extends IdenticonFieldProvider {

    private static final int FIELD_CAPACITY = 5;
    private static final int CENTER_COLUMN_INDEX = 3;

    @Override
    @IntRange(from = 1)
    public int getFieldCapacity() {
        return FIELD_CAPACITY;
    }

    protected int getSymmetricColumnIndex(int row) {
        if (row < CENTER_COLUMN_INDEX) {
            return row;
        }
        else {
            return FIELD_CAPACITY - row - 1;
        }
    }

    @Override
    public boolean isCellActive(int column, int row) {
        return getByte(3 + row * CENTER_COLUMN_INDEX + getSymmetricColumnIndex(column)) >= 0;
    }
}
