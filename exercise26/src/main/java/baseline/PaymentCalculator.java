package baseline;

public class PaymentCalculator {
    public int calculateMonthsUntilPaidOff(double b, double p, double i) {
        i /= 3.65;
        double c = Math.pow(1 + i, 30);
        double a = 1 + (b / p) * (1 - c);

        return (int)(-(1.0/30.0) * (Math.log(a) / Math.log(1 + i)));
    }

    public void saySomething() {
        System.out.println("I WORK!!!");
    }
}
