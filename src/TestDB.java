
import helper.JdbcHelper1;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DMX
 */
public class TestDB {

    public static void main(String[] args) {
        Connection connec;
        String url = "jdbc:sqlserver://localhost:1433; databaseName=Polypro_laintpd02389";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connec = DriverManager.getConnection(url, "sa", "songlong");
            Statement st = connec.createStatement();

//Thêm mới 5 nhân viên
            String sql = "INSERT INTO NhanVien(MaNV, MatKhau, HoTen, VaiTro) VALUES ('3111','123456','phuongphuong',1)";
//            st.executeUpdate(sql);
            JdbcHelper1.executeUpdate(sql);
        
//            sql = "INSERT INTO NhanVien(MaNV, MatKhau, HoTen, VaiTro) VALUES  ('cuncun','123456',N'cuncun',1)";
//            st.executeUpdate(sql);
//            sql = "INSERT INTO NhanVien(MaNV, MatKhau, HoTen, VaiTro) VALUES  ('ducnv','123456',N'Ninh Văn Đức',1)";
//            st.executeUpdate(sql);
//            sql = "INSERT INTO NhanVien(MaNV, MatKhau, HoTen, VaiTro) VALUES  ('linhnv','123456',N'Nguyễn Việt Linh',1)";
//            st.executeUpdate(sql);
//cập nhật một số nhân viên theo MaNV
//            String sqll = "UPDATE NhanVien SET  HoTen= N'Phạm Nguyễn Hạnh Phương' WHERE MaNV = 'phuongphuong'";
//            st.executeUpdate(sqll);
//            sqll = "UPDATE NhanVien SET  HoTen= N'Nguyễn Thị Lài' WHERE MaNV = 'laixinhdep'";
//            st.executeUpdate(sqll);
//Xóa một nhân viên theo MaNV
//             String sqlll = "DELETE FROM NhanVien WHERE MaNV= 'cuncun'";
//             st.executeUpdate(sqlll);



//truy vấn và xuất ra màn hình tất cả các thông tin
//            String sql = "select* from NhanVien";
//            ResultSet rs = st.executeQuery(sql);
//            System.out.println("Hiển  thị thông tin tất cả nhân viên: ");
//            System.out.println("");
//            while (rs.next()) {
//                String id = rs.getString("MaNV");
//                String MatKhau = rs.getString("MatKhau");
//                String HoTen = rs.getString("HoTen");
//                Boolean VaiTro = rs.getBoolean("VaiTro");
//                String in;
//                if (VaiTro = true) {
//                    in = "Trưởng phòng";
//                } else {
//                    in = "Nhân viên";
//                }
//                System.out.println(id +" | "+ MatKhau +" | " + HoTen+" | "+in );
//                System.out.println("");
//            }

//Gọi thủ tục lưu sp_ThongKeNguoiHoc() và xuất thông tin 

//String exec = "EXEC sp_ThongKeNguoiHoc ";
//ResultSet rs = st.executeQuery(exec);
//            System.out.println("Xuất các thông tin thống kê");
//            System.out.println("Năm | Số lượng | NgayDK đầu | NgayDK cuối");
//            System.out.println("");
//            while (rs.next()) {                
//                String ngaydk = rs.getString("Nam");
//                String sl = rs.getString("SoLuong");
//                String dt = rs.getString("DauTien");
//                String cc= rs.getString("CuoiCung");
//                
//                System.out.println( ngaydk + " | " + sl+ " | " + dt +" | " + cc );
//            }
//            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
