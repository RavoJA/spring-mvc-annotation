package jean.aime.controllers;

import jean.aime.entities.Person;
import jean.aime.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Main {

    private final PersonService personService;

    public Main(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/home")
    @Transactional
    public String home(Model model) {
        personService.createPerson(new Person(1L, "Jean "));
        List<Person> personList = personService.fetchAll();
        model.addAttribute("listPerson", personList);
        model.addAttribute("nom", "Jean Aimé");

        return "List";
    }

}
