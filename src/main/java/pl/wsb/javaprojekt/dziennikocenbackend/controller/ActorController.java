package pl.wsb.javaprojekt.dziennikocenbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Actor;
import pl.wsb.javaprojekt.dziennikocenbackend.service.ActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listActors", actorService.listAll());
        return "actor/index";
    }

    @RequestMapping("/new")
    public String create(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actor/new";
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("actor") Actor actor) {
        actorService.save(actor);
        return "redirect:/actor/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("actor/edit");
        modelAndView.addObject("actor", actorService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        actorService.delete(id);
        return "redirect:/actor/";
    }

}
