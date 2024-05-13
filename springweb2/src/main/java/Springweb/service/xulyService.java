package Springweb.service;

import Springweb.entity.xuly;
import java.util.List;
import java.util.Optional;

public interface xulyService {
public Optional<xuly> findById(Integer MaXL);

    public Iterable<xuly> findAll();

    public boolean existsById(Integer MaXL);

    public long count();

    public void deleteById(Integer MaXL);

    public void delete(xuly entity);

    public void deleteAll();
    
    public int getTongViPham(int matv);
    
    public int getDangXuLy(int matv);
    
    public List <xuly> Listxl(int matv);
}
