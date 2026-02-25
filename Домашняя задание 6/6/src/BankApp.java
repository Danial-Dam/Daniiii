public class BankApp implements IObserver {

    @Override
    public void update(String currency, double rate) {
        System.out.println("BankApp: Новый курс " + currency + " = " + rate);
    }
}