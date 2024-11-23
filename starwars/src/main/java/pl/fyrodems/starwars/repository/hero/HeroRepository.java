package pl.fyrodems.starwars.repository.hero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fyrodems.starwars.entity.hero.Hero;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
}
