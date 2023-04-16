package com.receiptbox.service.base64;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class DefaultBase64Decode implements Base64Decode {
    @Override
    public byte[] decode(String scannedReceipt) {
        var base64 = new Base64();
        return base64.decode(scannedReceipt.trim().getBytes());
    }
}
