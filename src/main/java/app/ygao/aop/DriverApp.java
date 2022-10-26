package app.ygao.aop;

import app.ygao.aop.business.Calculable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApp.class);
    private final Calculable calculable;

    @Autowired
    protected DriverApp(Calculable calculable) {
        this.calculable = calculable;
    }

    protected void run(double[] twoNumbers) {
        if (twoNumbers.length != 2) {
            throw new IllegalArgumentException("Array can only contains two numbers");
        }

        var num1 = twoNumbers[0];
        var num2 = twoNumbers[1];
        var sum = calculable.add(num1, num2);
        var difference = calculable.subtract(num1, num2);
        var product = calculable.multiply(num1, num2);
        var quotient = calculable.divide(num1, num2);
        printResult(sum, difference, product, quotient);

    }

    private void printResult(double sum, double difference, double product, double quotient) {
        LOGGER.debug("*            Sum is: {}", sum);
        LOGGER.debug("*     Difference is: {}", difference);
        LOGGER.debug("*        Product is: {}", product);
        LOGGER.debug("*       Quotient is: {}", quotient);
    }
}
