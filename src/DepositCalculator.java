import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return getNumber (pay, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getNumber(amount + amount * yearRate * depositPeriod, 2);
    }
    double getNumber(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void makeDeposit( ) {
        Scanner scanner = new Scanner(System.in);
        int period;
        int action;
        int amount;
        double out = 0;

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
    public static void main(String[] args) {
        new DepositCalculator().makeDeposit();
    }
}