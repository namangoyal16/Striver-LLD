// Facade basically means the front part of a building.
// For a complex system, we create a facade and then the client
// only calls the facade. The facade internally performs all
// the different tasks.
//
// For analogy, think of an automatic car.
// You give a simple command, but many things happen behind
// the scenes. Those internal details are not exposed to us.
//
// Similarly, the client only interacts with the Facade,
// while the complex operations inside the system remain hidden.

package StructuralDesignPattern;

class PaymentService {

    public void makePayment() {
        System.out.println("Payment done");
    }
}

class SeatBookingService {

    public void bookSeat() {
        System.out.println("Seat booked");
    }
}

class GenerateReceiptService {

    public void generateReceipt() {
        System.out.println("Receipt generated");
    }
}

class MovieBookingFacade {

    private PaymentService paymentService;
    private SeatBookingService seatBookingService;
    private GenerateReceiptService generateReceiptService;

    MovieBookingFacade() {
        paymentService = new PaymentService();
        seatBookingService = new SeatBookingService();
        generateReceiptService = new GenerateReceiptService();
    }

    public void bookMovie() {

        paymentService.makePayment();

        seatBookingService.bookSeat();

        generateReceiptService.generateReceipt();
    }
}

public class FacadePattern {

    public static void main(String[] args) {

        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();

        // Client only needs to call this one method.
        movieBookingFacade.bookMovie();
    }
}