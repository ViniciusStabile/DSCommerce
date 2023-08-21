package DSCommerce.DTO;

import DSCommerce.entities.User;

public class ClientDTO {

	private Long id;
	private String name;

	public ClientDTO() {
		super();
	}

	public ClientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClientDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
