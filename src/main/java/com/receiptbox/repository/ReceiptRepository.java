package com.receiptbox.repository;

import com.receiptbox.domain.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {

}
