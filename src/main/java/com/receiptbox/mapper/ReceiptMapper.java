package com.receiptbox.mapper;

import com.receiptbox.controller.request.CreateReceiptRequest;
import com.receiptbox.controller.request.UpdateReceiptRequest;
import com.receiptbox.domain.Receipt;
import com.receiptbox.service.base64.Base64DecoderService;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ReceiptMapper {
    private Base64DecoderService base64DecoderService;

    public Receipt mapReceipt(CreateReceiptRequest createReceiptRequest) {
        return new Receipt(
                null,
                createReceiptRequest.getShopName(),
                createReceiptRequest.getProductFullName(),
                createReceiptRequest.getProductShortName(),
                createReceiptRequest.getPurchaseDate(),
                createReceiptRequest.getPrice(),
                createReceiptRequest.getScannedReceipt() != null
                        ? new Binary(base64DecoderService.decode(createReceiptRequest.getScannedReceipt())) : null
        );
    }

    public void mapExistingReceipt(Receipt receipt, UpdateReceiptRequest updateReceiptRequest) {
        receipt.setScannedReceipt(updateReceiptRequest.getScannedReceipt() != null
                ? new Binary(base64DecoderService.decode(updateReceiptRequest.getScannedReceipt())) : null);
        receipt.setPrice(updateReceiptRequest.getPrice());
        receipt.setPurchaseDate(updateReceiptRequest.getPurchaseDate());
        receipt.setShopName(updateReceiptRequest.getShopName());
        receipt.setProductFullName(updateReceiptRequest.getProductFullName());
        receipt.setProductShortName(updateReceiptRequest.getProductShortName());
    }
}