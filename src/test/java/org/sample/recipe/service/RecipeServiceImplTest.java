package org.sample.recipe.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.recipe.domain.Recipe;
import org.sample.recipe.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getAllRecipes() {
        Recipe recipe = new Recipe();
        List<Recipe> recipesData = new ArrayList<>();
        recipesData.add(recipe);

        when(recipeService.getAllRecipes()).thenReturn(recipesData);

        List<Recipe> recipes = recipeService.getAllRecipes();
        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }
}