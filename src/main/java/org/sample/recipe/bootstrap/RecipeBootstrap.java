package org.sample.recipe.bootstrap;

import org.sample.recipe.domain.Difficulty;
import org.sample.recipe.domain.Ingredient;
import org.sample.recipe.domain.Recipe;
import org.sample.recipe.repository.CategoryRepository;
import org.sample.recipe.repository.RecipeRepository;
import org.sample.recipe.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {
        Recipe guacamole = new Recipe();
        guacamole.setDescription("How to Make Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(15);
        guacamole.setServings(4);
        guacamole.setDifficulty(Difficulty.EASY);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setDescription("Avocados");
        ingredient1.setAmount(BigDecimal.valueOf(2));
        unitOfMeasureRepository.findByDescription("Pinch").ifPresent(ingredient1::setUom);
        ingredient1.setRecipe(guacamole);
        guacamole.getIngredients().add(ingredient1);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setDescription("Cilantro");
        ingredient2.setAmount(BigDecimal.valueOf(1));
        unitOfMeasureRepository.findByDescription("Tablespoon").ifPresent(ingredient2::setUom);
        ingredient2.setRecipe(guacamole);
        guacamole.getIngredients().add(ingredient2);

        categoryRepository.findByDescription("Mexican").ifPresent(guacamole.getCategories()::add);
        categoryRepository.findByDescription("Tex Mex").ifPresent(guacamole.getCategories()::add);
        categoryRepository.findByDescription("Quick and Easy").ifPresent(guacamole.getCategories()::add);

        recipeRepository.save(guacamole);

    }
}
