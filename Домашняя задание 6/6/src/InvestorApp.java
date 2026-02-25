public class InvestorApp implements IObserver {

    @Override
    public void update(String currency, double rate) {
        if (rate > 500) {
            System.out.println("InvestorApp: Внимание! Высокий курс " + currency);
        } else {
            System.out.println("InvestorApp: Курс обновлен: " + currency + " = " + rate);
        }
    }
}