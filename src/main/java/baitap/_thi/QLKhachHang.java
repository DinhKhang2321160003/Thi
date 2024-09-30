/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap._thi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * Họ tên sinh viên: Vũ Đình Khang
 */

public class QLKhachHang {
    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void DocKhachHang(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String maso = data[0];
                String hoten = data[1];
                int sonhankhau = Integer.parseInt(data[2]);
                double chisocu = Double.parseDouble(data[3]);
                double chisomoi = Double.parseDouble(data[4]);

                KhachHang kh = new KhachHang(maso, hoten, sonhankhau, chisocu, chisomoi);
                dsKhachHang.add(kh);
            }
        } catch (IOException e) {
        }
    }

    public boolean GhiHoaDon(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (KhachHang kh : dsKhachHang) {
                bw.write(kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu() + ";" + kh.tinhTienTra());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void sapXepTheoMucTieuThu() {
        Collections.sort(dsKhachHang, Comparator.comparingDouble(KhachHang::getTieuThu).reversed());
    }
    
    public double getTieuThuCaoNhat() {
        return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .max()
                .orElse(0);
    }

    public double getTieuThuThapNhat() {
        return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .min()
                .orElse(0);
    }

    public double getTieuThuTrungBinh() {
        return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .average()
                .orElse(0);
    }
}
