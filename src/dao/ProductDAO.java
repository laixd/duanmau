package dao;




import helper.JdbcHelper1;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductMODEL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KA
 */
public class ProductDAO {

   public void insert(ProductMODEL model) {
        String sql = "INSERT INTO product (id, tensp, soluong, gia, ngay) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper1.executeUpdate(sql,
                model.getId(),
                model.getTensp(),
                model.getSoluong(),
                model.getGia(),
                model.getNgay());
    }
    public void update(ProductMODEL model) {
        String sql = "UPDATE product SET id =?, tensp =?, soluong= ?, gia = ?, ngay = ? WHERE id=?";
        JdbcHelper1.executeUpdate(sql,
                model.getId(),
                model.getTensp(),
                model.getSoluong(),
                model.getGia(),
                model.getNgay(),
        model.getId());
    }

    public void delete(Integer ProductID) {
        String sql = "DELETE FROM product WHERE id=?";
        JdbcHelper1.executeUpdate(sql, ProductID);
    }

    public java.util.List<ProductMODEL> select() {
        String sql = "SELECT * FROM product";
      return (java.util.List<ProductMODEL>) select(sql);
    }

    public ProductMODEL findById(Integer ProductID) {
        String sql = "SELECT * FROM product WHERE id=?";
        java.util.List<ProductMODEL> list = (java.util.List<ProductMODEL>) select(sql, ProductID);
        return list.size() > 0 ? list.get(0) : null;
    }

    private java.util.List<ProductMODEL> select(String sql, Object... args) {
        java.util.List<ProductMODEL> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper1.executeQuery(sql, args);
                while (rs.next()) {
                    ProductMODEL model = readFromResultSet(rs);
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

    private ProductMODEL readFromResultSet(ResultSet rs) throws SQLException {
        ProductMODEL model = new ProductMODEL();
        model.setId(rs.getInt("id"));
        model.setTensp(rs.getString("tensp"));
        model.setGia(rs.getFloat("gia"));
        model.setSoluong(rs.getInt("soluong"));
        model.setNgay(rs.getDate("ngay"));
        return model;
    }
 

}
