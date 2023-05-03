package com.receiptbox.domain;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor()
@Document
public class Receipt {
    @Id
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
    private Binary scannedReceipt;
}
