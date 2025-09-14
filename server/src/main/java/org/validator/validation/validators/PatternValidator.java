package org.validator.validation.validators;

import org.validator.annotations.Pattern;

public class PatternValidator implements Validator<Pattern> {
    @Override
    public void validate(Pattern annotation, Object value) {
        if (value instanceof String str) {
            if (!str.matches(annotation.pattern())) {
                throw new RuntimeException(annotation.errorMsg());
            }
        }
    }
}