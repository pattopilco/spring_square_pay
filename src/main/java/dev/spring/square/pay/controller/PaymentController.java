package dev.spring.square.pay.controller;

import com.squareup.square.models.Money;
import dev.spring.square.pay.model.BodyCreatePayment;
import dev.spring.square.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public void save (@Validated @RequestBody BodyCreatePayment bodyCreatePayment){
        String referenceId = "00001";
        String note = "Note Payment";
        Money amountMoney = new Money(100L,"USD");

        paymentService.createPayment(bodyCreatePayment.getSourceId(),
                bodyCreatePayment.getIdempotencyKey(),
                amountMoney,
                bodyCreatePayment.getLocationId(),referenceId,note);
    }
}
