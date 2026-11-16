package zm.nipa.scasp.validation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Collects field-level validation errors. Safe to expose to views (unmodifiable). */
public final class ValidationResult {
    private final Map<String, String> errors = new LinkedHashMap<>();

    public ValidationResult reject(String field, String message) {
        errors.putIfAbsent(field, message);
        return this;
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public Map<String, String> errors() {
        return Collections.unmodifiableMap(errors);
    }
}
