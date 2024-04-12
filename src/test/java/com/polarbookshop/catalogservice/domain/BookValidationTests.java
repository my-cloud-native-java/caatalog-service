package com.polarbookshop.catalogservice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.*;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BookValidationTests {
  private static Validator validator;

  @BeforeAll
  static void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void whenAllFieldsAreCorrectThenValidationSucceeds() {
    var book = Book.of("1234567890", "Title", "Author", 9.90, "polarsophia");
    Set<ConstraintViolation<Book>> violations = validator.validate(book);

    assertThat(violations).isEmpty();
  }

  @Test
  void whenIncorrectIsbnIsDefinedValidationFailes() {
    var book = Book.of("a234234", "Title", "Author", 8.80, "polarsophia");
    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertThat(violations).hasSize(1);
    assertThat(violations.iterator().next().getMessage())
        .isEqualTo("The ISBN format must be a valid 10 or 13 digit number.");
  }
}
