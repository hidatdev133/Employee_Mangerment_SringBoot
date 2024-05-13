package Springweb.service;

import Springweb.entity.xuly;
import Springweb.repository.xulyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class xulyServiceImpl implements xulyService {

    private final xulyRepository xulyRepository;

    @Autowired
    public xulyServiceImpl(xulyRepository xulyRepository) {
        this.xulyRepository = xulyRepository;
    }

    @Override
    public Iterable<xuly> findAll() {
        return xulyRepository.findAll();
    }

    @Override
    public Optional<xuly> findById(Integer id) {
        return xulyRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return xulyRepository.existsById(id);
    }

    @Override
    public long count() {
        return xulyRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        xulyRepository.deleteById(id);
    }

    @Override
    public void delete(xuly entity) {
        xulyRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        xulyRepository.deleteAll();
    }
     @Override 
    public int getTongViPham(int matv){
       return xulyRepository.getTongViPham(matv);
    }
    @Override 
    public int getDangXuLy(int matv){
        return xulyRepository.getDangXuLy(matv);
    }
    @Override
    public List Listxl(int matv){
        return xulyRepository.Listxl(matv);
    }
    
    
}
