package DSCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import DSCommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
