package com.receiptbox.service.base64;

import org.bson.types.Binary;

public interface Base64EncoderService {

    String encode(Binary scannedReceipt);
}
