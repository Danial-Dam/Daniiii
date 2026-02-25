import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== ВЫБЕРИТЕ ЗАДАЧУ =====");
        System.out.println("1 - Паттерн Стратегия (Оплата)");
        System.out.println("2 - Паттерн Наблюдатель (Курсы валют)");
        System.out.print("Ваш выбор: ");

        int taskChoice = scanner.nextInt();
        scanner.nextLine();

        switch (taskChoice) {


            case 1:

                PaymentContext context = new PaymentContext();

                System.out.print("Введите сумму оплаты: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Выберите способ оплаты:");
                System.out.println("1 - Банковская карта");
                System.out.println("2 - PayPal");
                System.out.println("3 - Криптовалюта");
                System.out.print("Ваш выбор: ");

                int paymentChoice = scanner.nextInt();
                scanner.nextLine();

                switch (paymentChoice) {
                    case 1:
                        System.out.print("Введите номер карты: ");
                        String card = scanner.nextLine();
                        context.setStrategy(new CreditCardPayment(card));
                        break;

                    case 2:
                        System.out.print("Введите email PayPal: ");
                        String email = scanner.nextLine();
                        context.setStrategy(new PayPalPayment(email));
                        break;

                    case 3:
                        System.out.print("Введите адрес криптокошелька: ");
                        String wallet = scanner.nextLine();
                        context.setStrategy(new CryptoPayment(wallet));
                        break;

                    default:
                        System.out.println("Неверный выбор способа оплаты!");
                        return;
                }

                context.executePayment(amount);
                break;


            case 2:

                CurrencyExchange exchange = new CurrencyExchange();

                IObserver bank = new BankApp();
                IObserver investor = new InvestorApp();
                IObserver news = new NewsAgency();

                exchange.addObserver(bank);
                exchange.addObserver(investor);
                exchange.addObserver(news);

                System.out.print("Введите валюту: ");
                String currency = scanner.nextLine();

                System.out.print("Введите курс: ");
                double rate = scanner.nextDouble();

                exchange.setRate(currency, rate);
                break;

            default:
                System.out.println("Неверный выбор!");
        }
    }
}