package com.example.inventoryapp;

import com.example.inventoryapp.category.Category;
import com.example.inventoryapp.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {

    // Tells the application context to inject an instance of CategoryRepository(dependency of CategoryRepositoryTest) at runtime
    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory() {
        // The CategoryRepository is already injected and you can use it
        Category savedCategory = repo.save(new Category("Electrics"));
        assertThat(savedCategory.getId()).isGreaterThan(0);



    }
}
