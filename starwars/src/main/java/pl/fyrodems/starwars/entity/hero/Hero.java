package pl.fyrodems.starwars.entity.hero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Hero {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int alignment;

    @Getter
    @Setter
    private int role;

    @Getter
    @Setter
    private boolean cool;

    public Hero() {
    }
}
