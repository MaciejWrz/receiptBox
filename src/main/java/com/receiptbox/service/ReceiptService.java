package com.receiptbox.service;

import com.receiptbox.dto.CreateReceiptRequest;
import com.receiptbox.dto.UpdateReceiptRequest;
import com.receiptbox.dto.MultipleReceiptResponse;
import com.receiptbox.dto.ReceiptResponse;

public interface ReceiptService {
    void createReceipt(CreateReceiptRequest createReceiptRequest);

    void updateReceipt(UpdateReceiptRequest updateReceiptRequest);

    ReceiptResponse getReceipt(String id);

    MultipleReceiptResponse getAllReceipts();

    void deleteReceipt(String id);
}
