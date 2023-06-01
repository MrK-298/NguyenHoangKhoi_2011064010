package com.example.demo.entity;

import com.example.demo.validator.annotation.ValidPhongBanId;
import com.example.demo.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name = "manv")
    @NotEmpty(message = "Ma NV must not be empty")
    @Size(max = 3, message = "Ma NV must be less than 3 characters")
    private String Ma_NV;
    @Column(name = "tennv")
    @NotEmpty(message = "Ten NV must not be empty")
    @Size(max = 100,min = 1,message = "Ten NV must be less than 100 characters")
    private String Ten_NV;
    @Column(name = "phai")
    @Size(max = 3,min = 1,message = "Phai must be less than 3 characters")
    private String Phai;
    @Column(name = "noisinh")
    @Size(max = 100,min = 1,message = "Noi sinh must be less than 100 characters")
    private String Noi_Sinh;
    @Column(name = "luong")
    private int Luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    @ValidPhongBanId
    private PhongBan PhongBan;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;
}
