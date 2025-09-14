package org.web1.DTOs;

import org.validator.annotations.Number;

public record RequestDTO(
        @Number(min = -4, max = 4, step = 1) String X,
        @Number(min = 1, max = 3, step = 0.5) String R,
        @Number(min = -3, max = 5) String Y
) {}
