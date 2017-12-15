package org.sample.recipe.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.recipe.domain.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    //@DirtiesContext
    public void findByDescription() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomOptional.orElseGet(UnitOfMeasure::new).getDescription());
    }

    @Test
    public void findByDescriptionOunce() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        assertEquals("Ounce", uomOptional.orElseGet(UnitOfMeasure::new).getDescription());
    }
}