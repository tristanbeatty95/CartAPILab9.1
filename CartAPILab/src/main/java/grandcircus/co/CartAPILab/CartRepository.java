package grandcircus.co.CartAPILab;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String>{

	List<Cart> findByProduct(String product);
}
