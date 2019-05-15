package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer> {

    /*
     * Find UserId by Id
     */
    List<Cart> findByUserid(Integer user_id);


    /*
     * Find Cart by Id
     */
    List<Cart> deleteAllById(Integer id);


    /*
     * Find Cart by Id
     */
    List<Cart> findByid(Integer id);
}
