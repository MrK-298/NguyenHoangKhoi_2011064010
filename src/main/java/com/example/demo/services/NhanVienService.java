package com.example.demo.services;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienId(String Ma_NV){
        return nhanVienRepository.findById(Ma_NV).orElse(null);
    }
    public void addNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }
    public void deleteNhanVien(String Ma_NV){
        nhanVienRepository.deleteById(Ma_NV);
    }
    public void updateNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

}
