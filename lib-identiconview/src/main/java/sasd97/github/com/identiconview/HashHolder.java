package sasd97.github.com.identiconview;

import android.support.annotation.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alexander on 28/12/2017.
 */

public abstract class HashHolder {

    private static final String HASH_ALGORITHM = "SHA-256";

    protected volatile byte[] hash;

    public void generateHash(@Nullable String text) {
        try {
            final MessageDigest digest = java.security.MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(text == null ? new byte[0] : text.getBytes());
            hash = digest.digest();
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

    protected byte getByte(int index) {
        return hash == null ? -128 : hash[index % hash.length];
    }
}
