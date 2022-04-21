package mk.ukim.finki.library.repository;

import mk.ukim.finki.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
