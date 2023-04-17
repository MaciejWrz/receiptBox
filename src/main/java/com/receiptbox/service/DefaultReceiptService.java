package com.receiptbox.service;

import com.receiptbox.controller.request.CreateReceiptRequest;
import com.receiptbox.controller.request.UpdateReceiptRequest;
import com.receiptbox.controller.response.MultipleReceiptResponse;
import com.receiptbox.controller.response.ReceiptResponse;
import com.receiptbox.exception.ReceiptNotFoundException;
import com.receiptbox.repository.ReceiptRepository;
import com.receiptbox.mapper.ReceiptMapper;
import com.receiptbox.mapper.ReceiptResponseMapper;
import com.receiptbox.service.validator.ReceiptRequestValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DefaultReceiptService implements ReceiptService {
    private ReceiptRepository receiptRepository;
    private ReceiptMapper receiptMapper;
    private ReceiptResponseMapper receiptResponseMapper;
    private ReceiptRequestValidator receiptValidator;

    @Override
    public void createReceipt(CreateReceiptRequest createReceiptRequest) {
        receiptRepository.save(receiptMapper.mapReceipt(createReceiptRequest));
    }

    @Override
    public void updateReceipt(UpdateReceiptRequest updateReceiptRequest) {
        receiptValidator.validateId(updateReceiptRequest.getId());
        var receipt = receiptRepository.findById(updateReceiptRequest.getId()).orElse(null);

        if (receipt != null) {
            receiptMapper.mapExistingReceipt(receipt, updateReceiptRequest);
            receiptRepository.save(receipt);
        } else {
            throw new ReceiptNotFoundException("Receipt hasn't been found for id: " + updateReceiptRequest.getId());
        }
    }

    @Override
    public ReceiptResponse getReceipt(String id) {
        receiptValidator.validateId(id);
        var receipt = receiptRepository.findById(id).orElse(null);
        return receiptResponseMapper.mapReceiptResponse(receipt);
    }

    @Override
    public MultipleReceiptResponse getAllReceipts() {
        return receiptResponseMapper.mapMultipleReceiptResponse(receiptRepository.findAll());
    }

    @Override
    public void deleteReceipt(String id) {
        receiptRepository.deleteById(id);
    }
}
