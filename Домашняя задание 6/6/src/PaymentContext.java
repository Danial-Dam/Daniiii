public class PaymentContext {

    private IPaymentStrategy strategy;

    public void setStrategy(IPaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            System.out.println("Стратегия оплаты не выбрана!");
        } else {
            strategy.pay(amount);
        }
    }
}