package com.receiptbox.service.base64;

import org.bson.types.Binary;

public interface Base64Encoder {

    String encode(Binary scannedReceipt);
}
