package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Category;
import proyecto.ciclo3.gym.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listCategories() {

        return categoryRepository.listarTodos();

    }

    public Optional<Category> listCategory(int id) {

        return categoryRepository.listarId(id);

    }

    public Category guardarCategory(Category c) {

        if (c.getId() == null) {

            return categoryRepository.guardar(c);

        } else {
            Optional<Category> cat = categoryRepository.listarId(c.getId());
            if (cat.isEmpty()) {

                return categoryRepository.guardar(c);

            } else {

                return c;

            }

        }

    }

}
