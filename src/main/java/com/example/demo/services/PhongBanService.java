package com.example.demo.services;

import com.example.demo.entity.PhongBan;
import com.example.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    public List<PhongBan> getAllPhongBan(){ return phongBanRepository.findAll();}
    public PhongBan getPhongBanById(String id){return phongBanRepository.findById(id).orElse(null);}
    public PhongBan savePhongBan(PhongBan phongBan) { return phongBanRepository.save(phongBan);}
    public void deletePhongBan(String id){ phongBanRepository.deleteById(id);}
}
