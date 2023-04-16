package com.receiptbox.service;

import com.receiptbox.controller.request.CreateReceiptRequest;
import com.receiptbox.controller.request.UpdateReceiptRequest;
import com.receiptbox.controller.response.MultipleReceiptResponse;
import com.receiptbox.controller.response.ReceiptResponse;

public interface ReceiptService {
    void createReceipt(CreateReceiptRequest createReceiptRequest);

    void updateReceipt(UpdateReceiptRequest updateReceiptRequest);

    ReceiptResponse getReceipt(String id);

    MultipleReceiptResponse getAllReceipts();

    void deleteReceipt(String id);
}
