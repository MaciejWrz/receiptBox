package com.receiptbox.controller;

import com.receiptbox.dto.CreateReceiptRequest;
import com.receiptbox.dto.UpdateReceiptRequest;
import com.receiptbox.dto.MultipleReceiptResponse;
import com.receiptbox.dto.ReceiptResponse;
import com.receiptbox.service.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/receipts")
public class ReceiptController {
    private ReceiptService receiptService;

    @Operation(summary = "Get all receipts")
    @GetMapping("")
    public MultipleReceiptResponse getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @Operation(summary = "Get receipt by id")
    @Parameter(
            name = "id",
            description = "Receipt identifier"
    )
    @GetMapping("/{id}")
    public ReceiptResponse getReceipt(@PathVariable("id") String id) {
        return receiptService.getReceipt(id);
    }

    @Operation(summary = "Create receipt and store receipt")
    @Parameters({
            @Parameter(
                    name = "shopName",
                    description = "Place where the product has been bought"
            ),
            @Parameter(
                    name = "productFullName",
                    description = "Full name of the product"
            ),
            @Parameter(
                    name = "productShortName",
                    description = "Product alias"
            ),
            @Parameter(
                    name = "purchaseDate",
                    description = "Date when the product has been bought"
            ),
            @Parameter(
                    name = "price",
                    description = "Price"
            ),
            @Parameter(
                    name = "scannedReceipt",
                    description = "Receipt identifier"
            )
    })
    @PostMapping("")
    public void createReceipt(CreateReceiptRequest receiptRequest) {
        receiptService.createReceipt(receiptRequest);
    }

    @Operation(summary = "Update receipt")
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Id of the product"
            ),
            @Parameter(
                    name = "shopName",
                    description = "Place where the product has been bought"
            ),
            @Parameter(
                    name = "productFullName",
                    description = "Full name of the product"
            ),
            @Parameter(
                    name = "productShortName",
                    description = "Product alias"
            ),
            @Parameter(
                    name = "purchaseDate",
                    description = "Date when the product has been bought"
            ),
            @Parameter(
                    name = "price",
                    description = "Price"
            ),
            @Parameter(
                    name = "scannedReceipt",
                    description = "Receipt identifier"
            )
    })
    @PutMapping("")
    public void updateReceipt(UpdateReceiptRequest updateReceiptRequest) {
        receiptService.updateReceipt(updateReceiptRequest);
    }

    @Operation(summary = "Remove product permanently")
    @Parameter(
            name = "id",
            description = "Id of the product to be removed"
    )
    @DeleteMapping("/{id}")
    public void removeReceipt(@PathVariable("id") String id) {
        receiptService.deleteReceipt(id);
    }
}
