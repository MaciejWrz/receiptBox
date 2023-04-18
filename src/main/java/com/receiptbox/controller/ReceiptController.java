package com.receiptbox.controller;

import com.receiptbox.dto.CreateReceiptRequest;
import com.receiptbox.dto.UpdateReceiptRequest;
import com.receiptbox.dto.MultipleReceiptResponse;
import com.receiptbox.dto.ReceiptResponse;
import com.receiptbox.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {
    private ReceiptService receiptService;

    @GetMapping("/")
    public MultipleReceiptResponse getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{id}")
    public ReceiptResponse getReceipt(@PathVariable("id") String id) {
        return receiptService.getReceipt(id);
    }

    @PostMapping("/")
    public void createReceipt(CreateReceiptRequest receiptRequest) {
        receiptService.createReceipt(receiptRequest);
    }

    @PutMapping("/update")
    public void updateReceipt(UpdateReceiptRequest updateReceiptRequest) {
        receiptService.updateReceipt(updateReceiptRequest);
    }

    @DeleteMapping("/remove/{id}")
    public void removeReceipt(@PathVariable("id") String id) {
        receiptService.deleteReceipt(id);
    }
}
