package app.ygao.aop.business.impl;

import app.ygao.aop.annotation.Loggable;
import app.ygao.aop.business.Calculable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements Calculable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    @Override
    @Loggable()
    public double add(double num1, double num2) {
        LOGGER.debug("inside of add({}, {}) method", num1, num2);
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        return num1 / num2;
    }
}
