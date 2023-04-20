package src.com.concurrency;

public class TaxCalaculatorMain {

    public static void main(String[] args) {
//        TaxCalaculator calaculator = new TaxCalaculator(10000d,2000d){
//            @Override
//            public double calcTax(){
//                return getSalary() * 0.1+getBonus() * 0.15;
//            }
//        };
//
//        double tax = calaculator.calculate();
//
//        System.out.println(tax);
        //lambda表达式方式
        TaxCalaculator calaculator = new TaxCalaculator(10000d,2000d,(s,b) ->s * 0.1+ b * 0.15);

        CalculatorStrategy strategy = new SimpleCalculatorStrategy();
        //calaculator.setCalculatorStrategy(strategy);
        //calaculator.setCalculatorStrategy();
        System.out.println(calaculator.calculate());

    }
}
