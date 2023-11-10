package com.arquiteture.domain.service.hash;

import jakarta.enterprise.context.ApplicationScoped;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@ApplicationScoped
public class HashService implements IHashService {

    final String SALT = "#blahhxyz9232";
    final Integer ITERATION_COUNT = 233;
    final Integer KEY_LENGTH =  512;
    final String SECRET_KEY_FACTORY = "PBKDF2WithHmacSHA512";

    @Override
    public String getHashPassword(String password) {
        try {
            byte[] result = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY)
                    .generateSecret(
                            new PBEKeySpec(password.toCharArray(), SALT.getBytes(), ITERATION_COUNT, KEY_LENGTH)
                    )
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
