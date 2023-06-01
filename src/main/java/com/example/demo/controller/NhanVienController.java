package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.services.NhanVienService;
import com.example.demo.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens", nhanViens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("PhongBans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @GetMapping("/search")
    public String search(@RequestParam("searchText") String searchText, Model model) {
        List<NhanVien> books = nhanVienService.getAllNhanVien();
        List<NhanVien> filteredBooks = new ArrayList<>();

        if (searchText != null && !searchText.isEmpty()) {
            filteredBooks = books.stream()
                    .filter(book -> book.getTen_NV().contains(searchText))
                    .collect(Collectors.toList());
        }
        model.addAttribute("nhanviens", filteredBooks);
        return "nhanvien/list";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("PhongBans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id){
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }
    @GetMapping("edit/{id}")
    public String editNhanVienForm(@PathVariable("Ma_NV")String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienId(id);
        if (editNhanVien != null ){
            model.addAttribute("nhanvien",editNhanVien);
            model.addAttribute("PhongBans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("edit/{id}")
    public String editNhanVien(@PathVariable("Ma_NV")String id, @ModelAttribute("nhanvien") @Valid NhanVien editNhanVien, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            NhanVien existingNhanVien = nhanVienService.getNhanVienId(id);
            if ( existingNhanVien != null){
                existingNhanVien.setTen_NV(editNhanVien.getTen_NV());
                existingNhanVien.setPhai(editNhanVien.getPhai());
                existingNhanVien.setNoi_Sinh(editNhanVien.getNoi_Sinh());
                existingNhanVien.setLuong(editNhanVien.getLuong());
                existingNhanVien.setPhongBan((editNhanVien.getPhongBan()));
                nhanVienService.updateNhanVien(existingNhanVien);
            }
            return "redirect:/nhanviens";
        }
    }

}
