package org.validator;

import org.validator.annotations.Number;

public record ExampleDTO (
        @Number(min = 4, step = 3) String textField
) {}
