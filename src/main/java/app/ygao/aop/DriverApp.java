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
    public DriverApp(Calculable calculable) {
        this.calculable = calculable;
    }

    void run(double[] twoNumbers) {
        if (twoNumbers.length != 2) {
            throw new IllegalArgumentException("Array can only contains two numbers");
        }

        var num1 = twoNumbers[0];
        var num2 = twoNumbers[1];
        var sum = calculable.add(num1, num2);
        var difference = calculable.subtract(num1, num2);
        var product = calculable.multiply(num1, num2);
        var quotient = calculable.divide(num1, num2);

        var template = """
        
        * sum is:           {}
        * difference is:    {}
        * product is:       {}
        * quotient is       {}""";
        LOGGER.debug(template, sum, difference, product, quotient);
    }
}
