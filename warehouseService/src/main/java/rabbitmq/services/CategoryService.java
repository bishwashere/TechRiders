package rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Category;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface CategoryService {

    @PreAuthorize("hasPermission(#id,'product-category-management')")
    Category save(Category category);

    @PreAuthorize("hasPermission(#id,'product-category-management')")
    List<Category> findAll();

    @PreAuthorize("hasPermission(#id,'product-category-management')")
    void delete(Integer id);
    Category findById(Integer id);
}
