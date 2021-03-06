package io.datajek.springdata.tennisplayer.springdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerSpringDataRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //insert players
        logger.info("\n\n>> Inserting Player: {}\n", repo.save(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)
        ));

        logger.info("\n\n>> Inserting Player: {}\n", repo.save(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

        logger.info("\n\n>> Inserting Player: {}\n", repo.save(
                new Player("Thiem", "Austria",
                        new Date(System.currentTimeMillis()), 17)));

        //update player
        logger.info("\n\n>> Updating Player with id 3: {}\n", repo.save(
                new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)
        ));

        //get player
        logger.info("\n\n>> Player with id 2:{}\n", repo.findById(2));

        //delete player
//        repo.deleteById(5);

        //get all players
        logger.info("\n\n>> All Players Data: {}", repo.findAll());

        //get French players
        logger.info("\n\n>>French Player Data: {}\n", repo.findByNationality("France"));
    }
}
