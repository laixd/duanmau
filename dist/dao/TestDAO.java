/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.DateHelper;
import helper.JdbcHelper1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.NguoiHoc;

/**
 *
 * @author DMX
 */
public class TestDAO {
    // ThongKeDao() tk = new ThongKeDao();

    public static void main(String[] args) {
        try {
            // Thêm mới 5 người học
              NguoiHoc model = new NguoiHoc("PD0007","lai",DateHelper.toDate("2/2/1999", "MM/dd/yyyy"),true, "0123456","lai@jffhv","dv","laixinhdep");
              new NguoiHocDAO().insert(model);
              NguoiHoc modell = new NguoiHoc("PD0008","lai",DateHelper.toDate("2/2/1999", "MM/dd/yyyy"),true, "0123456","lai@jffhv","dv","laixinhdep");
              new NguoiHocDAO().insert(modell);
              NguoiHoc modelll = new NguoiHoc("PD0009","lai",DateHelper.toDate("2/2/1999", "MM/dd/yyyy"),true, "0123456","lai@jffhv","dv","laixinhdep");
              new NguoiHocDAO().insert(modelll);
              NguoiHoc modellll = new NguoiHoc("PD0010","lai",DateHelper.toDate("2/2/1999", "MM/dd/yyyy"),true, "0123456","lai@jffhv","dv","laixinhdep");
              new NguoiHocDAO().insert(modellll);

//Cập nhật thông tin người học theo mã
//            NguoiHoc model1 = new NguoiHoc("PD0007", "phuongphuong", DateHelper.toDate("2/2/1999", "MM/dd/yyyy"), false, "0234565", "lai@gmail.com", "tot", "laixinhdep");
//            new NguoiHocDAO().update(model1);
//Xóa người học theo mã
//            System.out.println("Nhập Mã Nhaanvien cần xóa: ");
//            Scanner sc = new Scanner(System.in);
//            String xoa = sc.nextLine();
//            try {
//                new NguoiHocDAO().delete(xoa);
//                System.out.println("Đã xóa nhân viên");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//Truy vấn người học theo mã
//            System.out.println("Nhập MaNV cần truy vấn:");
//            Scanner sc = new Scanner(System.in);
//            String truyvan = sc.nextLine();
//            try {
//                NguoiHoc nh = new NguoiHocDAO().findById(truyvan);
//                Boolean gioitinh = nh.getGioiTinh();
//                String gt;
//                if (gioitinh = true) {
//                    gt = "Nam";
//                } else {
//                    gt = "Nữ";
//                }
//                System.out.println(nh.getMaNH() + " | " + nh.getHoTen() + " | " + nh.getNgaySinh() + " | " + gt + " | " + nh.getDienThoai() + " | " + nh.getEmail() + " | " + nh.getGhiChu() + " | " + nh.getMaNV() + " | " + nh.getNgayDK());
//                System.out.println("");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            //Truy vấn tất cả người học
//            System.out.println("Truy vấn tất cả người học");
//            List<NguoiHoc> list = new NguoiHocDAO().select();
//            for (NguoiHoc nh : list) {
//                Boolean gioitinh = nh.getGioiTinh();
//                String gt;
//                if (gioitinh = true) {
//                    gt = "Nam";
//                } else {
//                    gt = "Nữ";
//                }
//                System.out.println(nh.getMaNH() + " | " + nh.getHoTen() + " | " + nh.getNgaySinh() + " | " + gt + " | " + nh.getDienThoai() + " | " + nh.getEmail() + " | " + nh.getGhiChu() + " | " + nh.getMaNV() + " | " + nh.getNgayDK());
//
//            }

            //Gọi thủ tục luu sp_ThongKeNguoiHoc()
//            System.out.println("Gọi thủ tục");
//            System.out.println("Năm | Số lượng | Đầu tiên | Cuối cùng");
//            List<Object[]> list1 = new ArrayList<>();
//            ThongKeDAO tk = new ThongKeDAO();
//            list1 = tk.getNguoiHoc();
//            int i = 0;
//            for (Object[] objects : list1) {
//                System.out.printf("%-5d %-5d %-5s %s",objects[i + 0], objects[i + 1], objects[i + 2], objects[i + 3]);
//
//            }
//            List<Object[]> list = new ArrayList<>();
//            for (NguoiHoc tk : list) {
//                String ngaydk =tk.getString("Nam");
//                String sl = tk.getString("SoLuong");
//                String dt = tk.getString("DauTien");
//                String cc = tk.getString("CuoiCung");
//
//                System.out.println(ngaydk + " | " + sl + " | " + dt + " | " + cc);
//                
//            }

//List<ThongKe> list1 = new ThongKeDAO().
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
