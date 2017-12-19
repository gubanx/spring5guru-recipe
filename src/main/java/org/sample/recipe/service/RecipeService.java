package org.sample.recipe.service;

import org.sample.recipe.command.RecipeCommand;
import org.sample.recipe.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
