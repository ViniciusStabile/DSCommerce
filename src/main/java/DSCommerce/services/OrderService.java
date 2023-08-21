package DSCommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DSCommerce.DTO.OrderDTO;
import DSCommerce.DTO.OrderItemDTO;
import DSCommerce.entities.Order;
import DSCommerce.entities.OrderItem;
import DSCommerce.entities.OrderStatus;
import DSCommerce.entities.Product;
import DSCommerce.repositories.OrderItemRepository;
import DSCommerce.repositories.OrderRepository;
import DSCommerce.repositories.ProductRepository;
import DSCommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderItemRepository  orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserService service;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {

		Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
		return new OrderDTO(order);
	}

	@Transactional(readOnly = true)
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();

		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		order.setClient(service.authenticated());
		
		for( OrderItemDTO itemDTO : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDTO.getProductId());
			OrderItem item = new OrderItem(order,product,itemDTO.getQuantity(),product.getPrice());
			order.getItems().add(item);
			
		}
		
		repository.save(order);
		orderItemRepository.saveAll(order.getItems());
		
		return new OrderDTO(order);
	}

}
