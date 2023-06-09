package src.com.concurrency;

public class TaxCalaculator {

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }



    private final double salary;

    private final double bonus;

    private final CalculatorStrategy calculatorStrategy;

    public TaxCalaculator(double salary, double bonus,CalculatorStrategy calculatorStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculatorStrategy = calculatorStrategy;
    }

    protected double calcTax(){
        return calculatorStrategy.calculate(salary,bonus);
    }
    public double calculate(){
        return this.calcTax();
    }
}
