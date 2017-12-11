package org.sample.recipe.controller;

import org.sample.recipe.repository.CategoryRepository;
import org.sample.recipe.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model) {
        System.out.println(categoryRepository.findByDescription("Spanish").get().getId());
        unitOfMeasureRepository.findByDescription("Cup").ifPresent(System.out::println);
        unitOfMeasureRepository.findByDescription("Cup").ifPresent(x -> System.out.println(x.getId()));
        return "index";
    }
}
