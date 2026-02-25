import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Введите сумму оплаты:");
        double amount = scanner.nextDouble();

        System.out.println("Выберите способ оплаты:");
        System.out.println("1 - Банковская карта");
        System.out.println("2 - PayPal");
        System.out.println("3 - Криптовалюта");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Введите номер карты:");
                String card = scanner.nextLine();
                context.setStrategy(new CreditCardPayment(card));
                break;

            case 2:
                System.out.println("Введите email PayPal:");
                String email = scanner.nextLine();
                context.setStrategy(new PayPalPayment(email));
                break;

            case 3:
                System.out.println("Введите адрес криптокошелька:");
                String wallet = scanner.nextLine();
                context.setStrategy(new CryptoPayment(wallet));
                break;

            default:
                System.out.println("Неверный выбор!");
                return;
        }

        context.executePayment(amount);
    }
}