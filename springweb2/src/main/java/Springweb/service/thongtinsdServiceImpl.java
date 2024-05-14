package Springweb.service;

import Springweb.entity.thongtinsd;
import Springweb.repository.thongtinsdRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class thongtinsdServiceImpl implements thongtinsdService {

    private final thongtinsdRepository ttsdRepository;

    @Autowired
    public thongtinsdServiceImpl(thongtinsdRepository thongtinsdRepository) {
        this.ttsdRepository = thongtinsdRepository;
    }

    @Override
    public Iterable<thongtinsd> findAll() {
        return ttsdRepository.findAll();
    }

    @Override
    public Optional<thongtinsd> findById(Integer id) {
        return ttsdRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return ttsdRepository.existsById(id);
    }

    @Override
    public long count() {
        return ttsdRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        ttsdRepository.deleteById(id);
    }

    @Override
    public void delete(thongtinsd entity) {
        ttsdRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        ttsdRepository.deleteAll();
    }
    
//    @Override
//    public List<thongtinsd> searchTTSD(int keyword){
//        return ttsdRepository.searchTTSD(keyword);
//    }
    
    public List<thongtinsd> findByMaTB(int maTB){
        return ttsdRepository.findByMaTB(maTB);
    }
    
    public thongtinsd save(thongtinsd thongTinSuDung){
        return ttsdRepository.save(thongTinSuDung);
    }
    
     public Integer findNextId(){
        return (ttsdRepository.findLastId()!= null) ? ttsdRepository.findLastId() + 1 : 1;
    }

     
     
     public List<thongtinsd> findThongTinSDByMaTBAndTGDatchoNotNull(int matb){
        return ttsdRepository.findThongTinSDByMaTBAndTGDatchoNotNull(matb);
    }
     
     public boolean checkValidReserveTime(int matb, Timestamp new_reserveTime){
        Date reserveDate = DateUtils.truncate(new_reserveTime, Calendar.DATE);
        List<thongtinsd> reservedList = findThongTinSDByMaTBAndTGDatchoNotNull(matb);
        if (reservedList != null){
            if (!reservedList.isEmpty()) {
                for (thongtinsd ttsd : reservedList) {
                    Date ttsdReserveDate = DateUtils.truncate(ttsd.getTGDatcho(), Calendar.DATE);
                    System.err.println(ttsdReserveDate);
                    if (reserveDate.equals(ttsdReserveDate)) {
                        return false;
                    }
                }
            }
        }     
        return true;
    }
}
