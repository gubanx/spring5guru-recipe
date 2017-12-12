package org.sample.recipe.service;

import lombok.extern.slf4j.Slf4j;
import org.sample.recipe.domain.Recipe;
import org.sample.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        log.info("YIEEEEEEEEEEEE");
        return (List<Recipe>) recipeRepository.findAll();
    }

}
