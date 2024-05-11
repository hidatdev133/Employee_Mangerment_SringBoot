package Springweb.service;

import Springweb.entity.thongtinsd;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public interface thongtinsdService {

    public Optional<thongtinsd> findById(Integer id);

    public Iterable<thongtinsd> findAll();

    public boolean existsById(Integer id);

    public long count();

    public void deleteById(Integer id);

    public void delete(thongtinsd entity);

    public void deleteAll();
    
    public List<thongtinsd> searchTTSD(int keyword);
}
