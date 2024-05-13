package Springweb.repository;

import Springweb.entity.xuly;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface xulyRepository extends CrudRepository<xuly, Integer>{
@Query ("SELECT count(MaXL) from xuly where MaTV=?1 ")
int getTongViPham(int matv);


@Query ("SELECT count(x.MaXL) from xuly x where x.MaTV=?1 AND x.TrangThaiXL=0")
int getDangXuLy(int matv);

@Query("SELECT xl from xuly xl where xl.MaTV=?1")
  List<xuly>Listxl(int matv);

}
