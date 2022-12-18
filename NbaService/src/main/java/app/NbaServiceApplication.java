package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import player.Player;
import player.PlayerRepository;

@SpringBootApplication
@EnableJpaRepositories("player")
@EntityScan("player")
@EnableDiscoveryClient
@ComponentScan(basePackages = "player")
public class NbaServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(NbaServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NbaServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PlayerRepository pRepo){
        return (args) -> {
            pRepo.save(new Player(1,"Denis","Dao","Meneur",50));
            pRepo.save(new Player(2,"Stephen","Curry","Meneur",51));
            pRepo.save(new Player(3,"Klay","Thompson","Arriere",37));
            pRepo.save(new Player(4,"Michael","Jordan","Arriere",33));
            pRepo.save(new Player(5,"Russel","Westbrook","Meneur",31));
            pRepo.save(new Player("Dag","Westbrook","Meneur",31));

            for (Player player : pRepo.findByPoste("Meneur")){
                log.info(player.toString());
            }
        };
    }

}
