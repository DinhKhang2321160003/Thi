/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap._thi;
/**
 *
 * Họ tên sinh viên: Vũ Đình Khang
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

     
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi - chisocu;
    }
    
    public double getDinhMuc()
    {
       return sonhankhau *4;
    }
    
    
    public double tinhTienTra()
    {
        double tieuthu = getTieuThu();
        double giaBan = 0;
        if (tieuthu <= getDinhMuc())
        {
            giaBan = tieuthu *6700;
        }else if (tieuthu <= getDinhMuc()+2)
        {
            giaBan = getDinhMuc()*6700 +(tieuthu - getDinhMuc())*12900;
        }else{
        giaBan = getDinhMuc()*6700+2*12900+(tieuthu - getDinhMuc()-2)*14400;
        }
        double thueGTGT = giaBan *0.05;
        double tdvtn = giaBan*0.25;
        double thueTDVTN = tdvtn *0.08;
        return giaBan + thueGTGT + tdvtn + thueTDVTN;
    }         
}