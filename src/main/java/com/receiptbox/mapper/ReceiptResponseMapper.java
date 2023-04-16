package com.receiptbox.mapper;

import com.receiptbox.controller.response.MultipleReceiptResponse;
import com.receiptbox.controller.response.ReceiptResponse;
import com.receiptbox.domain.Receipt;
import com.receiptbox.repository.ReceiptRepository;
import com.receiptbox.service.base64.Base64EncoderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ReceiptResponseMapper {
    private Base64EncoderService base64EncoderService;

    public ReceiptResponse mapReceiptResponse(Receipt receipt) {
        if (receipt == null) {
            return null;
        }

        return new ReceiptResponse(
                receipt.getId(),
                receipt.getShopName(),
                receipt.getProductFullName(),
                receipt.getProductShortName(),
                receipt.getPurchaseDate(),
                receipt.getPrice(),
                (receipt.getScannedReceipt() != null
                        ? base64EncoderService.encode(receipt.getScannedReceipt()) : null)
        );
    }

    public MultipleReceiptResponse mapMultipleReceiptResponse(List<Receipt> allReceipts) {
        if (allReceipts == null) {
            return null;
        }

        return new MultipleReceiptResponse(
                allReceipts.stream().map(this::mapReceiptResponse).toList()
        );
    }
}
