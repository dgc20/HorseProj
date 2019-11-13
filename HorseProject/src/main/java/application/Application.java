package application;

import data.HorseDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        HorseDao.getInstance().generateHorses();
        SpringApplication.run(Application.class, args);
    }

}