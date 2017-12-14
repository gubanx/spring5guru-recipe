package org.sample.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void init() {
        category = new Category();
    }

    @Test
    public void getId() {
        category.setId(45L);
        assertEquals(45L, (long) category.getId());
    }

}