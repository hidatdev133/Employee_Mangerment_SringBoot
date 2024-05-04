package Springweb.service;

import Springweb.entity.thanhvien;
import Springweb.repository.thanhvienRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class thanhvienServiceImpl implements thanhvienService {

    @Autowired
    private thanhvienRepository tvRepository;

    @Override
    public Optional<thanhvien> findById(Integer id) {
        return tvRepository.findById(id);
    }

    @Override
    public Iterable<thanhvien> findAll() {
        return tvRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return tvRepository.existsById(id);
    }

    @Override
    public long count() {
        return tvRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        tvRepository.deleteById(id);
    }

    @Override
    public void delete(thanhvien entity) {
        tvRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        tvRepository.deleteAll();
    }

}
