package org.validator.validation.validators;

import org.validator.annotations.Size;

public class SizeValidator implements Validator<Size> {
    @Override
    public void validate(Size annotation, Object value) {
        if (value instanceof String str) {
            if (str.length() < annotation.min() || str.length() > annotation.max()) {
                throw new RuntimeException(
                        String.format(
                                annotation.errorMsg(),
                                annotation.min(),
                                annotation.max()
                        )
                );
            }
        }
    }
}