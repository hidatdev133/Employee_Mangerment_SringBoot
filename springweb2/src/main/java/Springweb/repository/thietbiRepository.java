package Springweb.repository;

import Springweb.entity.thietbi;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface thietbiRepository extends CrudRepository<thietbi, Integer> {
    @Query("SELECT t FROM thietbi t WHERE t.TenTB LIKE %:keyword%")
    List<thietbi> searchTB(String keyword);
    
}
