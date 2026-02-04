package org.sebsy.levenshtein;

/**
 * Exception applicative (unchecked) pour signaler des entrées invalides.
 */
public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}
