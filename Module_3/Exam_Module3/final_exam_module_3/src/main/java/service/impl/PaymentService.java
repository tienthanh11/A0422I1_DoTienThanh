package service.impl;

import model.Payment;
import repositories.impl.PaymentRepository;
import service.IPaymentService;

import java.util.List;

public class PaymentService implements IPaymentService {
    PaymentRepository paymentRepository = new PaymentRepository();

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
