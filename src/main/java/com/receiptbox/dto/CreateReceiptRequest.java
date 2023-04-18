package com.receiptbox.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class CreateReceiptRequest {
    private String shopName;
    private String productFullName;
    private String productShortName;
    private OffsetDateTime purchaseDate;
    private BigDecimal price;
    private String scannedReceipt;
}
