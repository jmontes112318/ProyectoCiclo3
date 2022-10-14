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

    public Category ActualizarCategory(Category c) {

        if (c.getId() != null) {

            Optional<Category> ctr = categoryRepository.listarId(c.getId());

            if (!ctr.isEmpty()) {

                if (c.getName() != null) {
                    ctr.get().setName(c.getName());
                }

                if (c.getDescription() != null) {
                    ctr.get().setDescription(c.getDescription());
                }
                return categoryRepository.guardar(ctr.get());

            }

        }

        return c;

    }

    // public boolean eliminarCategory(int id) {
    // Boolean ctg = listCategory(id).map(category -> {
    // categoryRepository.borrarCategoria(category);
    // return true;
    // }).orElse(false);
    // return ctg;

    // }

    public boolean eliminarCategory(int id) {

        Optional<Category> ctg = listCategory(id);
        if (!ctg.isEmpty()) {
            categoryRepository.borrarCategoria(ctg.get());
            return true;

        }
        return false;

    }

}
