package rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Product;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    @PreAuthorize("hasPermission(#id,'product-management')")
    public Product save(Product product);

    @PreAuthorize("hasPermission(#id,'product-management')")
    public List<Product> findAll();
    public List<Product> findAllByAddedBy(Long id);

    @PreAuthorize("hasPermission(#id,'product-management')")
    public Optional<Product> deleteById(Long id);

    Optional<Product> findById(long id);
    @PreAuthorize("hasPermission(#id,'product-management')")
    public List<Product> updateSoldStatusByIds(List<Long> ids);
}
