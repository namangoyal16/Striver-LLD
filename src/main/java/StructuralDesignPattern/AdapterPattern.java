// Adapter Pattern
//
// Adapter Pattern solves the problem of connecting two incompatible
// interfaces/classes.
//
// For example, suppose our application expects a PaymentGateway,
// but a third-party API such as Razorpay has a different interface.
//
// Instead of changing our existing code or changing the third-party API,
// we create an Adapter.
//
// Real-life analogy:
// A US charger and an Indian socket may be incompatible.
// An adapter allows them to work together.
//
// Similarly:
//
// Client
//   ↓
// PaymentGateway
//   ↓
// PaymentAdapter
//   ↓
// RazorpayAPI
//
// The Adapter converts the interface expected by our application
// into the interface provided by the third-party service.


package StructuralDesignPattern;


interface PaymentGateway {

    void pay();
}


class PayUPaymentGateway implements PaymentGateway {

    private final String orderId;
    private final double amount;

    PayUPaymentGateway(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public void pay() {

        System.out.println(
                "Paying through PayU for orderID: "
                        + orderId
                        + " and amount = "
                        + amount
        );
    }
}


// Third-party API.
// We cannot change this class according to our application's interface.
class RazorpayAPI {

    private final String orderId;
    private final String date;
    private final double amount;

    RazorpayAPI(String orderId, double amount, String date) {
        this.orderId = orderId;
        this.amount = amount;
        this.date = date;
    }

    public void payment() {

        System.out.println(
                "Paying through Razorpay for orderID: "
                        + orderId
                        + " and amount = "
                        + amount
                        + " on "
                        + date
        );
    }
}


// Adapter
//
// Our application expects PaymentGateway,
// but RazorpayAPI does not implement PaymentGateway.
//
// Therefore, PaymentAdapter implements PaymentGateway
// and internally uses RazorpayAPI.
class PaymentAdapter implements PaymentGateway {

    private final RazorpayAPI razorpay;

    PaymentAdapter(String orderId, double amount, String date) {

        razorpay = new RazorpayAPI(
                orderId,
                amount,
                date
        );
    }

    @Override
    public void pay() {

        // Convert our application's pay()
//        requirement into Razorpay's payment() method.
        razorpay.payment();
    }
}


public class AdapterPattern {

    public static void main(String[] args) {

        // Our application works with PaymentGateway.
        PaymentGateway paymentGateway =
                new PaymentAdapter(
                        "ABC",
                        324,
                        "16-08-2026"
                );

        paymentGateway.pay();
    }
}