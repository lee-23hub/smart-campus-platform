package zm.nipa.scasp.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorsTest {

    @Test
    void validRegistrationFormPasses() {
        assertTrue(Validators.registrationForm("2022102434", "BOCS3100").isValid());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"123", "12345678901", "abcdefghij", "2022 10243", "2022102434'; DROP TABLE x;--"})
    void badStudentIdsRejected(String id) {
        ValidationResult r = Validators.studentId(id, new ValidationResult());
        assertFalse(r.isValid());
        assertTrue(r.errors().containsKey("studentId"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"bocs3100", "B1", "BOCS", "3100BOCS", "BOCS3100;"})
    void badCourseCodesRejected(String code) {
        assertFalse(Validators.courseCode(code, new ValidationResult()).isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-5", "501", "abc", "", "2.5"})
    void badCapacitiesRejected(String cap) {
        assertFalse(Validators.capacity(cap, new ValidationResult()).isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "30", "500"})
    void goodCapacitiesAccepted(String cap) {
        assertTrue(Validators.capacity(cap, new ValidationResult()).isValid());
    }

    @Test
    void requestFormRejectsUnknownCategoryAndBlankDescription() {
        ValidationResult r = Validators.requestForm("HACKING", "NORMAL", "  ");
        assertFalse(r.isValid());
        assertTrue(r.errors().containsKey("category"));
        assertTrue(r.errors().containsKey("description"));
        assertFalse(r.errors().containsKey("priority"));
    }

    @Test
    void requestFormAcceptsLowerCase() {
        assertTrue(Validators.requestForm("transcript", "high", "Need official copy").isValid());
    }

    @Test
    void descriptionTooLongRejected() {
        assertFalse(Validators.description("x".repeat(501), new ValidationResult()).isValid());
    }

    @Test
    void errorsAreUnmodifiable() {
        ValidationResult r = new ValidationResult().reject("a", "b");
        assertThrows(UnsupportedOperationException.class, () -> r.errors().put("c", "d"));
    }

    @Test
    void firstErrorPerFieldWins() {
        ValidationResult r = new ValidationResult().reject("a", "first").reject("a", "second");
        assertEquals("first", r.errors().get("a"));
    }

    @Test
    void nameRules() {
        assertTrue(Validators.name("Shirley Muchanga", new ValidationResult()).isValid());
        assertFalse(Validators.name("<script>", new ValidationResult()).isValid());
    }

    @Test
    void courseFormValidatesAllFields() {
        ValidationResult r = Validators.courseForm("bad", "", "0");
        assertEquals(3, r.errors().size());
    }
}
