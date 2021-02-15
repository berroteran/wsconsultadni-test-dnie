package pe.gob.reniec.ws.authorization;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * modified from PemUtils.java : com.auth0.jwt.PemUtils (test)
 */
public class PemUtils {

    private static byte[] parsePEM(String pem) throws IOException {
        PemReader reader = new PemReader(new StringReader(pem));
        PemObject pemObject = reader.readPemObject();
        return pemObject.getContent();
    }


    private static PublicKey getPublicKey(byte[] keyBytes, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PublicKey publicKey = null;
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        publicKey = kf.generatePublic(keySpec);
        return publicKey;
    }

    public static PublicKey readPublicKey(String pem, String algorithm) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] bytes = parsePEM(pem);
        return getPublicKey(bytes, algorithm);
    }

}
