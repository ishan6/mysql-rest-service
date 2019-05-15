package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<Users, Integer> {

    /*
     * Find User by Telephone and Password
     */
    List<Users> findByTelephoneAndPassword(String telephone, String password);
}
