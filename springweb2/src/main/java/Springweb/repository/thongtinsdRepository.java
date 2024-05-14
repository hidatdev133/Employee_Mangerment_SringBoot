package Springweb.repository;

import Springweb.entity.thongtinsd;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface thongtinsdRepository extends CrudRepository<thongtinsd, Integer> {
//    @Query("SELECT t FROM thietbi t WHERE t.TenTB LIKE %:keyword%")
//    List<thongtinsd> searchTTSD(String keyword);

//    @Query("SELECT s FROM thongtinsd s JOIN thietbi t ON s.MaTB = t.MaTB WHERE s.MaTB = :maTB")
//    List<thongtinsd> searchTTSD(int maTB);
    
    @Query("SELECT s FROM thongtinsd s WHERE s.MaTB = :maTB AND (s.TGMuon IS NULL OR s.TGTra IS NULL)")
    List<thongtinsd> findByMaTB(int maTB);
    
    
//    @Query("SELECT s FROM thongtinsd s WHERE s.MaTB = :maTB AND s.TGMuon >= :startTime")
//    List<thongtinsd> findByMaTB(int maTB, Timestamp startTime);
    
    @Query("SELECT MAX(t.MaTT) FROM thongtinsd t")
    Integer findLastId();
    
    @Query("SELECT t FROM thongtinsd t WHERE t.MaTB = :maTB AND t.TGDatcho IS NOT NULL")
    List<thongtinsd> findThongTinSDByMaTBAndTGDatchoNotNull(@Param("maTB") Integer matb);
}
