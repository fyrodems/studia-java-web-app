package pl.fyrodems.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.fyrodems.starwars.entity.hero.Hero;
import pl.fyrodems.starwars.repository.hero.HeroRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

	@Bean
	public CommandLineRunner setUpApp(@Autowired HeroRepository heroRepository) {
		return args -> {
			heroRepository.saveAll(fillOnStart());
		};
	}

	private List<Hero> fillOnStart() {
		List<Hero> heroes = new ArrayList<>();

		Hero hero1 = new Hero();
		hero1.setName("Łukasz Niebołaz");
		hero1.setAlignment(1);
		hero1.setRole(1);
		hero1.setCool(false);

		Hero hero2 = new Hero();
		hero2.setName("Antoniusz Niebołaz");
		hero2.setAlignment(2);
		hero2.setRole(1);
		hero2.setCool(true);

		Hero hero3 = new Hero();
		hero3.setName("Henryk Samotny");
		hero3.setAlignment(1);
		hero3.setRole(1);
		hero3.setCool(true);

		heroes.add(hero1);
		heroes.add(hero2);
		heroes.add(hero3);

		return heroes;
	}
}
