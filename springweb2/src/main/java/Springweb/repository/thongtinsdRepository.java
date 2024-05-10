package Springweb.repository;

import Springweb.entity.thongtinsd;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface thongtinsdRepository extends CrudRepository<thongtinsd, Integer> {
//    @Query("SELECT t FROM thietbi t WHERE t.TenTB LIKE %:keyword%")
//    List<thongtinsd> searchTTSD(String keyword);

    @Query("SELECT s FROM thongtinsd s WHERE s.MaTB IN (SELECT t.MaTB FROM thietbi t WHERE t.MaTB = :maTB)")
    List<thongtinsd> searchTTSD(String maTB);
}
