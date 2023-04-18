package com.receiptbox.mapper;

import com.receiptbox.dto.CreateReceiptRequest;
import com.receiptbox.dto.UpdateReceiptRequest;
import com.receiptbox.domain.Receipt;
import com.receiptbox.service.base64.Base64Decoder;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceiptMapper {
    private Base64Decoder base64Decoder;

    public Receipt mapReceipt(CreateReceiptRequest createReceiptRequest) {
        return new Receipt(
                null,
                createReceiptRequest.getShopName(),
                createReceiptRequest.getProductFullName(),
                createReceiptRequest.getProductShortName(),
                createReceiptRequest.getPurchaseDate(),
                createReceiptRequest.getPrice(),
                createReceiptRequest.getScannedReceipt() != null
                        ? new Binary(base64Decoder.decode(createReceiptRequest.getScannedReceipt())) : null
        );
    }

    public void mapExistingReceipt(Receipt receipt, UpdateReceiptRequest updateReceiptRequest) {
        receipt.setScannedReceipt(updateReceiptRequest.getScannedReceipt() != null
                ? new Binary(base64Decoder.decode(updateReceiptRequest.getScannedReceipt())) : null);
        receipt.setPrice(updateReceiptRequest.getPrice());
        receipt.setPurchaseDate(updateReceiptRequest.getPurchaseDate());
        receipt.setShopName(updateReceiptRequest.getShopName());
        receipt.setProductFullName(updateReceiptRequest.getProductFullName());
        receipt.setProductShortName(updateReceiptRequest.getProductShortName());
    }
}