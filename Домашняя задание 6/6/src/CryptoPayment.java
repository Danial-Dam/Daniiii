public class CryptoPayment implements IPaymentStrategy {

    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " криптовалютой с кошелька: " + walletAddress);
    }
}