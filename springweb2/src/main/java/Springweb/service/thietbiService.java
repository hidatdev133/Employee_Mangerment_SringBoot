package Springweb.service;

import Springweb.entity.thietbi;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public interface thietbiService {

    public Optional<thietbi> findById(Integer MaTB);

    public Iterable<thietbi> findAll();

    public boolean existsById(Integer MaTB);

    public long count();

    public void deleteById(Integer MaTB);

    public void delete(thietbi entity);

    public void deleteAll();
    
    public List<thietbi> searchTB(String keyword);
    
 
}
