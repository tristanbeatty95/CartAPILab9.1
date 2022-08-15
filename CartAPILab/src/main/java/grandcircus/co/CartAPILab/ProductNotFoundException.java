package grandcircus.co.CartAPILab;

public class ProductNotFoundException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String id) {
		super("Could not find product with ID" + id);
	}
}
