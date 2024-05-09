package Springweb.service;

import Springweb.entity.thietbi;
import Springweb.repository.thietbiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class thietbiServiceImpl implements thietbiService {

    @Autowired
    private thietbiRepository tbRepository;

    @Override
    public Optional<thietbi> findById(Integer id) {
        return tbRepository.findById(id);
    }

    @Override
    public Iterable<thietbi> findAll() {
        return tbRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return tbRepository.existsById(id);
    }

    @Override
    public long count() {
        return tbRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        tbRepository.deleteById(id);
    }

    @Override
    public void delete(thietbi entity) {
        tbRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        tbRepository.deleteAll();
    }

    @Override
    public List<thietbi> searchTB(String keyword) {
        return tbRepository.searchTB(keyword);
    }

}
