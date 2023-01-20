import java.util.Scanner;

public class DepositCalculator {
    // привет. В сигнатуре метода лучше будет указывать названия переменных более описательно. 
    // Так код будет более понятным, в плане того, какие данных необходимо передавать.
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return getNumber (pay, 2);
    }
    // между методами лучше добавлять одну строку, чтобы было удобнее читать.
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getNumber(amount + amount * yearRate * depositPeriod, 2);
    }
    // тут тоже :)
    double getNumber(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
        // название переменной scale лучше сделать с маленькой буквы, тогда оно будет соответствовать правилу lowerCamelCase 
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
        // и тут лучше сделать пустую строку
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
    // пустая строка :)
    public static void main(String[] args) {
        new DepositCalculator().makeDeposit();
    }
    
    // а в остальном все отлично! :)
}
