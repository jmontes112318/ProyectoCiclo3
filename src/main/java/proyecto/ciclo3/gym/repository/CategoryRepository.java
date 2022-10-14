package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Category;
import proyecto.ciclo3.gym.repository.crud.CategoryRepositoryCrud;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryRepositoryCrud categoryRepositoryCrud;

    public List<Category> listarTodos() {

        return (List<Category>) categoryRepositoryCrud.findAll();

    }

    public Optional<Category> listarId(int id) {
        return categoryRepositoryCrud.findById(id);
    }

    public Category guardar(Category c) {
        return categoryRepositoryCrud.save(c);
    }

    public void borrarCategoria(Category c) {
        categoryRepositoryCrud.delete(c);
    }

}
