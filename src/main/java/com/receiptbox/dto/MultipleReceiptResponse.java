package com.receiptbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MultipleReceiptResponse {
    private List<ReceiptResponse> receipts;
}
