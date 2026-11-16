package zm.nipa.scasp.validation;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * Central input validation. Servlets, the network gateway and the RMI layer
 * should all call these methods so business rules are not duplicated.
 */
public final class Validators {
    public static final Pattern STUDENT_ID = Pattern.compile("^\\d{10}$");
    public static final Pattern COURSE_CODE = Pattern.compile("^[A-Z]{3,4}\\d{3,4}$");
    public static final Pattern NAME = Pattern.compile("^[\\p{L}][\\p{L} .'-]{1,59}$");
    public static final Set<String> REQUEST_CATEGORIES = Set.of("TRANSCRIPT", "CLEARANCE", "APPEAL");
    public static final Set<String> PRIORITIES = Set.of("LOW", "NORMAL", "HIGH", "URGENT");
    public static final int MAX_CAPACITY = 500;
    public static final int MAX_DESCRIPTION = 500;

    private Validators() { }

    public static ValidationResult studentId(String value, ValidationResult r) {
        if (value == null || !STUDENT_ID.matcher(value.trim()).matches()) {
            r.reject("studentId", "Student ID must be exactly 10 digits.");
        }
        return r;
    }

    public static ValidationResult courseCode(String value, ValidationResult r) {
        if (value == null || !COURSE_CODE.matcher(value.trim()).matches()) {
            r.reject("courseCode", "Course code looks like BOCS3100 (letters then digits, upper case).");
        }
        return r;
    }

    public static ValidationResult name(String value, ValidationResult r) {
        if (value == null || !NAME.matcher(value.trim()).matches()) {
            r.reject("name", "Name must be 2-60 characters: letters, spaces, . ' or -.");
        }
        return r;
    }

    public static ValidationResult capacity(String raw, ValidationResult r) {
        try {
            int c = Integer.parseInt(raw == null ? "" : raw.trim());
            if (c < 1 || c > MAX_CAPACITY) {
                r.reject("capacity", "Capacity must be between 1 and " + MAX_CAPACITY + ".");
            }
        } catch (NumberFormatException e) {
            r.reject("capacity", "Capacity must be a whole number.");
        }
        return r;
    }

    public static ValidationResult category(String value, ValidationResult r) {
        if (value == null || !REQUEST_CATEGORIES.contains(value.trim().toUpperCase())) {
            r.reject("category", "Choose a valid request category.");
        }
        return r;
    }

    public static ValidationResult priority(String value, ValidationResult r) {
        if (value == null || !PRIORITIES.contains(value.trim().toUpperCase())) {
            r.reject("priority", "Choose a valid priority.");
        }
        return r;
    }

    public static ValidationResult description(String value, ValidationResult r) {
        if (value == null || value.isBlank()) {
            r.reject("description", "Description is required.");
        } else if (value.length() > MAX_DESCRIPTION) {
            r.reject("description", "Description must be at most " + MAX_DESCRIPTION + " characters.");
        }
        return r;
    }

    /** Convenience: whole registration form. */
    public static ValidationResult registrationForm(String studentId, String courseCode) {
        ValidationResult r = new ValidationResult();
        studentId(studentId, r);
        courseCode(courseCode, r);
        return r;
    }

    /** Convenience: whole service-request form. */
    public static ValidationResult requestForm(String category, String priority, String description) {
        ValidationResult r = new ValidationResult();
        category(category, r);
        priority(priority, r);
        description(description, r);
        return r;
    }

    /** Convenience: whole course form (staff). */
    public static ValidationResult courseForm(String courseCode, String title, String capacity) {
        ValidationResult r = new ValidationResult();
        courseCode(courseCode, r);
        if (title == null || title.isBlank() || title.length() > 100) {
            r.reject("title", "Title is required (max 100 characters).");
        }
        capacity(capacity, r);
        return r;
    }
}
