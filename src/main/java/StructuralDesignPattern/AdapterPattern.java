

// Adapter Pattern ----> it solves the basic problem of joining 2 incompatible class.
//for example if I have an interface and I am using a 3rd party api service and it is incompatible with my main interface
//then I can generate an adapter which can connect to my incompatible interface
// always remember real life case of using an adapter to join with incompatible sockets. Like US charger and socket example.


package StructuralDesignPattern;

interface PaymentGateway{
    void pay();
}

class PayUPaymentGateway implements PaymentGateway{
    String orderId;
    double amount;
    PayUPaymentGateway(String orderId , double amount){
        this.orderId = orderId;
        this.amount = amount;
    }
    @Override
    public void pay() {
        System.out.println("Paying through payu for orderID: " +orderId+ " and amount= " + amount);
    }
}

class RazorpayAPI{
    String orderId;
    String Date;
    double amount;
    public void payment(){
        System.out.println("Paying through Razorpay for orderID: " +orderId+ " and amount= " + amount+" on "+Date);
    }
}

class PaymentAdapter implements PaymentGateway{
     RazorpayAPI razorpay;
     public PaymentAdapter(String orderId , double amount , String Date){
         razorpay = new RazorpayAPI();
         razorpay.orderId = orderId;
         razorpay.amount = amount;
         razorpay.Date=  Date;
     }

     @Override
    public void pay(){
         razorpay.payment();
     }
}


public class AdapterPattern {
    public static  void main(String [] args){
//        PaymentGateway paymentGateway = new PayUPaymentGateway("ABC" , 324);
//        paymentGateway.pay();

        PaymentAdapter paymentAdapter = new PaymentAdapter("abc",123,"456");
        paymentAdapter.pay();
    }
}




