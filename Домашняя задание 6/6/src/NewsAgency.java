public class NewsAgency implements IObserver {

    @Override
    public void update(String currency, double rate) {
        System.out.println("NewsAgency: Срочная новость! " + currency + " теперь стоит " + rate);
    }
}