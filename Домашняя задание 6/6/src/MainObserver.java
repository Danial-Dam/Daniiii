import java.util.Scanner;

public class MainObserver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyExchange exchange = new CurrencyExchange();


        IObserver bankApp = new BankApp();
        IObserver investorApp = new InvestorApp();
        IObserver newsAgency = new NewsAgency();


        exchange.addObserver(bankApp);
        exchange.addObserver(investorApp);
        exchange.addObserver(newsAgency);

        System.out.println("===== СИСТЕМА КУРСОВ ВАЛЮТ =====");

        while (true) {
            System.out.println("\n1 - Обновить курс");
            System.out.println("2 - Удалить NewsAgency");
            System.out.println("3 - Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название валюты: ");
                    String currency = scanner.nextLine();

                    System.out.print("Введите новый курс: ");
                    double rate = scanner.nextDouble();
                    scanner.nextLine();

                    exchange.setRate(currency, rate);
                    break;

                case 2:
                    exchange.removeObserver(newsAgency);
                    System.out.println("NewsAgency удален из подписчиков.");
                    break;

                case 3:
                    System.out.println("Программа завершена.");
                    return;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}