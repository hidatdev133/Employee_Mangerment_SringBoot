package Springweb.service;

import Springweb.entity.thanhvien;
import java.util.Optional;

public interface thanhvienService {

    public Optional<thanhvien> findById(Integer MaTV);

    public Iterable<thanhvien> findAll();

    public boolean existsById(Integer MaTV);

    public long count();

    public void deleteById(Integer MaTV);

    public void delete(thanhvien entity);

    public void deleteAll();
}
