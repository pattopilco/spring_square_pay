package dev.spring.square.pay.service;

import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.PaymentsApi;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.Money;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
        public void createPayment(String sourceId,String idempotencyKey, Money amountMoney, String locationId, String referenceId, String note){
        CreatePaymentRequest body =  new CreatePaymentRequest.Builder(sourceId, idempotencyKey)
                .amountMoney(amountMoney)
                .autocomplete(true)
                .locationId(locationId)
                .referenceId(referenceId)
                .note(note)
                .build();

        SquareClient client = new SquareClient.Builder()
                .environment(Environment.SANDBOX)
                .accessToken("EAAAEGUzhE_DllGeW5aRFlQzUdKeLWXHkxNVQxl2P9SlokPimVXO3GeLFCm7h2rf")
                .build();

        PaymentsApi paymentsApi = client.getPaymentsApi();

        paymentsApi.createPaymentAsync(body)
                .thenAccept(result -> {
                    System.out.println("Success!");
                })
                .exceptionally(exception -> {
                    System.out.println("Failed to make the request");
                    System.out.println(String.format("Exception: %s", exception.getMessage()));
                    return null;
                });
    }
}
