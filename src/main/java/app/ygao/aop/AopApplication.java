package app.ygao.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(AopApplication.class, args);

        var driverApp = context.getBean(DriverApp.class);
        driverApp.run(new double[]{1.2, 3.5});
        context.close();
    }

}
