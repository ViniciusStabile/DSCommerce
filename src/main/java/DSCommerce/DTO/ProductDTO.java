package DSCommerce.DTO;

import java.util.ArrayList;
import java.util.List;

import DSCommerce.entities.Category;
import DSCommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private Long id;
	
	@Size(min = 3, max = 80, message = "Minimum 3 characters and maximum 80 characters")
	@NotBlank(message = "Invalid")
	private String name;
	@Size(min = 10, message = "Minimum 10 characters")
	@NotBlank(message = "Invalid")
	private String description;
	@NotNull(message = "Campo requerido")
	@Positive(message = "The price has to be positive")
	private Double price;
	private String imgUrl;

	@NotEmpty(message = "Deve conter pelo menos 1 categoria")
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		for(Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	

}
