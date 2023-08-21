package DSCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import DSCommerce.entities.OrderItem;
import DSCommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
