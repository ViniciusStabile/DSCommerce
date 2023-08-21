package DSCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import DSCommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
