package src.com.concurrency;

@FunctionalInterface
public interface CalculatorStrategy {

    public double calculate(double salary,double bonus);
}
