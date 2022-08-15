package grandcircus.co.CartAPILab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Autowired
	private CartRepository cart_repo;

	@GetMapping("/reset")
	public String reset() {

		cart_repo.deleteAll();

		Cart cart = new Cart("Granola", 7.25, 15);
		cart_repo.insert(cart);
		cart = new Cart("Cashews", 12.25, 30);
		cart_repo.insert(cart);
		cart = new Cart("Garlic Bread", 3.99, 10);
		cart_repo.insert(cart);
		cart = new Cart("Mexicali Dip", 5.99, 7);
		cart_repo.insert(cart);
		return "Data reset";
	}
	
	@GetMapping("/cart-items")
	public List<Cart> readAll() {
		return cart_repo.findAll();
	}
	
	@GetMapping("/cart-items/{id}")
	public Cart readOne(@PathVariable String id) {
		return cart_repo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PostMapping("/cartItem")
	public Cart create(@RequestBody Cart cartItem) {
		cart_repo.insert(cartItem);
		return cartItem;
	}
}
