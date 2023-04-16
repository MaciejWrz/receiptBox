package com.receiptbox.service.base64;

import org.apache.commons.codec.binary.Base64;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;

@Service
public class DefaultBase64Encoder implements Base64Encoder {
    @Override
    public String encode(Binary scannedReceipt) {
        if (scannedReceipt == null) {
            return null;
        }

        return Base64.encodeBase64String(scannedReceipt.getData());
    }
}
