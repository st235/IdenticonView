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
    private static final String HASH_ALGORITHM = "SHA-256";

    @Override
    @IntRange(from = 1)
    public int getFieldCapacity() {
        return FIELD_CAPACITY;
    }

    @Override
    public void generateFieldFor(@Nullable String text) {
        try {
            final MessageDigest digest = java.security.MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(text == null ? new byte[0] : text.getBytes());
            hash = digest.digest();
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
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
