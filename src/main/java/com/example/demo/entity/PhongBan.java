package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(name = "mapb")
    @Size(max = 2, min = 1, message = "Ma PB must be less than 2 characters")
    private String Ma_Phong;
    @Column(name = "tenpb")
    @Size(max = 30, min = 1, message = "Ten PB must be less than 30 characters")
    private String Ten_Phong;
    @OneToMany(mappedBy = "PhongBan",cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
