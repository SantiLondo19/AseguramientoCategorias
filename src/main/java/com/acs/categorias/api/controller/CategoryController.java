package com.acs.categorias.api.controller;


import com.acs.categorias.api.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

//    Crear lista para almacenar categorias
    private List<Category> categories = new ArrayList<>();


    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        if (users.isAdmin() && category.getName().length() <= 100 && !category.getName().isEmpty()) {
            categories.add(category);
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


//    - La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
//- Solo se podrá editar el texto de la categoría.
    @PutMapping("/category")
    public ResponseEntity<Category> editCategory(@RequestBody Category category) {
        return null;
    }

//    - La api deberá permitir consultar todas las categorías asociadas a un producto.
    @GetMapping("/category{productId}")
    public ResponseEntity<Category> getCategoriesByProduct() {
        return null;
    }

//  - La api deberá permitir eliminar una categoría sí y solo sí esta no ha sido asociada a un producto.
    @DeleteMapping("/category")
    public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
        if(category.getProducts().isEmpty()){
            categories.remove(category);
            return ResponseEntity.ok(category);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }




}
