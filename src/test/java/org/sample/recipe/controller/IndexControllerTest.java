package org.sample.recipe.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.recipe.domain.Recipe;
import org.sample.recipe.service.RecipeService;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);

    }

    @Test
    public void index() {
        List<Recipe> recipesData = new ArrayList<>();
        recipesData.add(new Recipe());
        recipesData.add(new Recipe());
        recipesData.add(new Recipe());
        when(recipeService.getAllRecipes()).thenReturn(recipesData);

        assertEquals("index", indexController.index(model));
        verify(recipeService, times(1)).getAllRecipes();

        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        List<Recipe> listInController = argumentCaptor.getValue();
        assertEquals(3, listInController.size());
    }
}