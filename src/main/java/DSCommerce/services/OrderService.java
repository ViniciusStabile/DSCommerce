package DSCommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DSCommerce.DTO.OrderDTO;
import DSCommerce.entities.Order;
import DSCommerce.repositories.OrderRepository;
import DSCommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {

		Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
		return new OrderDTO(order);
	}

}
