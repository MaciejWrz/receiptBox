package com.receiptbox.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ReceiptResponse {
    private String id;
    @NonNull
    private String shopName;
    @NonNull
    private String productFullName;
    private String productShortName;
    @NonNull
    private OffsetDateTime purchaseDate;
    @NonNull
    private BigDecimal price;
    private String scannedReceipt;
}
