package com.receiptbox.service.validator;

import com.receiptbox.exception.ReceiptValidationException;
import org.springframework.stereotype.Service;

@Service
public class DefaultReceiptRequestValidator implements ReceiptRequestValidator {

    public void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new ReceiptValidationException("Id can't be empty!");
        }
    }
}
