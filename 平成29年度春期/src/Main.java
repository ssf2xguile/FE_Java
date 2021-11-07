public class Main {
    public static void main(String[] args) {
        RatePlan planA = new RatePlan("プランA", 1123.30, new TiredRateTable(0, 19.62, 120, 26.10, 300, 30.12));
        RatePlan planB = new RatePlan("プランB", 1040.10, new TiredRateTable(0, 18.17, 120, 24.17, 300, 27.77));

        double amount = 543.0;
        int d = planA.getPrice(amount) - planB.getPrice(amount);
        if (d < 0){
            System.out.println("%sが%d円安い%n", planA.getName(), -d);
        } else if (d > 0){
            System.out.println("%sが%d円安い%n", planB.getName(), d);
        } else {
            System.out.println("両プランで同額");
        }
    }
}
