package com.molveno.molveno.chillflix.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/get-category", method = RequestMethod.GET)
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.DELETE)
    public void deleteCategory(@RequestBody Category category) {
        categoryRepository.deleteById(category.getId());
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST, consumes = "application/json")
    public void addCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST,consumes = "application/json")
    public void editCategory(@RequestBody Category category) {
        Category c = categoryRepository.findById(category.getId());

        c.setName(category.getName());
        c.setMovies(category.getMovies());

        categoryRepository.save(c);
    }

}
