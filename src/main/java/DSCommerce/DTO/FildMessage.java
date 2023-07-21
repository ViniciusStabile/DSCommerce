package DSCommerce.DTO;

public class FildMessage {

	private String fildName;
	private String message;

	public FildMessage(String fildName, String message) {
		this.fildName = fildName;
		this.message = message;
	}

	public String getFildName() {
		return fildName;
	}

	public String getMessage() {
		return message;
	}

}
