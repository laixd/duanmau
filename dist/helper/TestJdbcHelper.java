/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.ResultSet;



/**
 *
 * @author DMX
 */
public class TestJdbcHelper {
    public static void main(String[] args) {
        try {
            //Thêm mới 5 người học
//            String sql = "INSERT INTO NguoiHoc(MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK)   VALUES('PD0004', N'lài', '4-24-1999', 1, '0123456789', 'lai@fpt.edu.vn',N'Tốt', 'laixinhdep', '2-25-2010') ";
//            JdbcHelper1.executeUpdate(sql, args);
//            sql = "INSERT INTO NguoiHoc(MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK)   VALUES('PD0005', N'phương', '4-24-1999', 1, '0123456789', 'lai@fpt.edu.vn',N'Tốt', 'laixinhdep', '2-25-2010') ";
//            JdbcHelper1.executeUpdate(sql, args);
//            sql = "INSERT INTO NguoiHoc(MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK)   VALUES('PD0006', N'Đức', '4-24-1999', 0, '0123456789', 'lai@fpt.edu.vn',N'Tốt', 'laixinhdep', '2-25-2010') ";
//            JdbcHelper1.executeUpdate(sql, args);
//            sql = "INSERT INTO NguoiHoc(MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK)   VALUES('PD0007', N'Linh', '4-24-1999', 0, '0123456789', 'lai@fpt.edu.vn',N'Tốt', 'laixinhdep', '2-25-2010') ";
//            JdbcHelper1.executeUpdate(sql, args);
//            sql = "INSERT INTO NguoiHoc(MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK)   VALUES('PD0008', N'Tuấn', '4-24-1999', 0, '0123456789', 'lai@fpt.edu.vn',N'Tốt', 'laixinhdep', '2-25-2010') ";
//            JdbcHelper1.executeUpdate(sql, args);
            
            //Cập nhật thông tin người học theo mã
//            String sqll = "UPDATE NguoiHoc SET HoTen = N'Nguyễn Thị Lài' WHERE MaNH = 'PD0004'";
//            JdbcHelper1.executeUpdate(sqll, args);
            //Xóa người học theo mã
//            String sqlll = "DELETE FROM NguoiHoc WHERE MaNH = 'PD0008'";
//            JdbcHelper1.executeUpdate(sqlll, args);
// 

//Truy vấn người học theo mã
//    String sqls = "select* from NguoiHoc WHERE MaNH = 'PD0001'";
//            ResultSet rs= JdbcHelper1.executeQuery(sqls, args);
//            System.out.println("Hiển  thị thông tin nguoidung theo mã: ");
//            System.out.println("");
//            while (rs.next()) {
//                String manh = rs.getString("MaNH");
//                String hoten = rs.getString("HoTen");
//                String ngaysinh = rs.getString("NgaySinh");
//                Boolean gioitinh = rs.getBoolean("GioiTinh");
//                String in;
//                if (gioitinh = true) {
//                    in = "Nam";
//                } else {
//                    in = "Nữ";
//                }
//                String dienthoai = rs.getString("DienThoai");
//                String email = rs.getString("Email");
//                String ghichu = rs.getString("GhiChu");
//                String manv = rs.getString("MaNV");
//                String ngaydk = rs.getString("NgayDK");
//                System.out.println( manh + " | "+ hoten +" | " + ngaysinh+ " | "+ in + " | "+ dienthoai + " | " + email+" | " + ghichu+" | " + manv +" | "+ ngaydk );
//                System.out.println("");
//            }



//Truy vấn tất cả người học
String sqlq = "select* from NguoiHoc ";
            ResultSet rs= JdbcHelper1.executeQuery(sqlq, args);
            System.out.println("Hiển  thị thông tin NguoiDung: ");
            System.out.println("");
            while (rs.next()) {
                String manh = rs.getString("MaNH");
                String hoten = rs.getString("HoTen");
                String ngaysinh = rs.getString("NgaySinh");
                Boolean gioitinh = rs.getBoolean("GioiTinh");
                String in;
                if (gioitinh = true) {
                    in = "Nam";
                } else {
                    in = "Nữ";
                }
                String dienthoai = rs.getString("DienThoai");
                String email = rs.getString("Email");
                String ghichu = rs.getString("GhiChu");
                String manv = rs.getString("MaNV");
                String ngaydk = rs.getString("NgayDK");
                System.out.println( manh + " | "+ hoten +" | " + ngaysinh+ " | "+ in + " | "+ dienthoai + " | " + email+" | " + ghichu+" | " + manv +" | "+ ngaydk );
                System.out.println("");
            }
            
            //Gọi thủ tục luu sp_ThongKeNguoiHoc()
            String exec = "EXEC sp_ThongKeNguoiHoc ";
            JdbcHelper1.executeQuery(sqlq, args);
            System.out.println("Xuất các thông tin thống kê");
            System.out.println("Năm | Số lượng | NgayDK đầu | NgayDK cuối");
            System.out.println("");
            while (rs.next()) {
                String ngaydk = rs.getString("Nam");
                String sl = rs.getString("SoLuong");
                String dt = rs.getString("DauTien");
                String cc = rs.getString("CuoiCung");

                System.out.println(ngaydk + " | " + sl + " | " + dt + " | " + cc);
            }


        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
            e.printStackTrace();
        }
    }
    
}
