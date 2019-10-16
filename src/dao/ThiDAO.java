/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.JdbcHelper1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NguoiHoc;
import model.ProductMODEL;
import model.ThiMODEL;

/**
 *
 * @author KA
 */
public class ThiDAO {
    public void insert(ThiMODEL model) {
        String sql = "INSERT INTO SanPham (MaSP, TenSP, NgaySanXuat, SoLuong) VALUES ( ?, ?, ?, ?)";
        JdbcHelper1.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getNgaySanXuat(),
                model.getSoLuong() );
    }
    public void update(ThiMODEL model) {
        String sql = "UPDATE SanPham SET  TenSP =?, NgaySanXuat= ?, SoLuong = ? WHERE MaSP=?";
        JdbcHelper1.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getNgaySanXuat(),
                model.getSoLuong() );
    }

    public void delete(Integer MaSP) {
        String sql = "DELETE FROM SanPham WHERE MaSP=?";
        JdbcHelper1.executeUpdate(sql, MaSP);
    }

    public List<ThiMODEL> select() {
        String sql = "SELECT * FROM SanPham";
        return select(sql);
    }
    
    public ThiMODEL findById(Integer MaSP) {
        String sql = "SELECT * FROM SanPham WHERE MaSP=?";
        List<ThiMODEL> list = select(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
   

//   

//    private List<ThiMODEL> select(String sql) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private List<ThiMODEL> select(String sql, Integer MaSP) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
     private java.util.List<ThiMODEL> select(String sql, Object... args) {
        java.util.List<ThiMODEL> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper1.executeQuery(sql, args);
                while (rs.next()) {
                    ThiMODEL model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private ThiMODEL readFromResultSet(ResultSet rs) throws SQLException {
        ThiMODEL model = new ThiMODEL();
        model.setMaSP(rs.getInt("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setNgaySanXuat(rs.getDate("NgaySanXuat"));
        model.setSoLuong(rs.getInt("SoLuong"));
     
        return model;
    }
    
    
}
