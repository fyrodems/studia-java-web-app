package pl.fyrodems.starwars.controller.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.fyrodems.starwars.entity.hero.Hero;
import pl.fyrodems.starwars.repository.hero.HeroRepository;

@Controller
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/index")
    public String showHeroList(Model model) {
        model.addAttribute("heroes", heroRepository.findAll());
        return "index";
    }

    @GetMapping("/addhero")
    public String addHero(Model model) {
        model.addAttribute("hero", new Hero());
        return "add-hero";
    }

    @PostMapping("/addhero")
    public String addHero(Hero hero, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-hero";
        }

        heroRepository.save(hero);
        return "redirect:/index";
    }

    @GetMapping("edithero/{id}")
    public String editHero(@PathVariable("id") long id, Model model) throws IllegalAccessException {
        Hero hero = heroRepository.findById(id).orElseThrow(() -> new IllegalAccessException("No hero with id: " + id));

        model.addAttribute("hero", hero);
        return "edit-hero";
    }

    @PostMapping("/edithero/{id}")
    public String editHero(@PathVariable("id") long id, Hero hero, BindingResult result, Model model) {
        if (result.hasErrors()) {
            hero.setId(id);
            return "edit-hero";
        }

        heroRepository.save(hero);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteHero(@PathVariable("id") long id, Model model) throws IllegalAccessException {
        Hero hero = heroRepository.findById(id).orElseThrow(() -> new IllegalAccessException("No hero with id: " + id));
        heroRepository.delete(hero);
        return "redirect:/index";
    }
}
