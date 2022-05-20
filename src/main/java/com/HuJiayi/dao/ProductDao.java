package com.HuJiayi.dao;

import com.HuJiayi.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "DELETE FROM product WHERE ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        int i = pt.executeUpdate();
        if(i > 0) return i;
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "UPDATE product SET ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? WHERE productID=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,instance.getProductName());
        pt.setString(2,instance.getProductDescription());
        if(instance.getPicture()!=null){
            pt.setBinaryStream(3,instance.getPicture());
        }
        pt.setDouble(4,instance.getPrice());
        pt.setInt(5,instance.getCategoryId());
        pt.setInt(6,instance.getProductId());

        int i = pt.executeUpdate();
        if(i > 0) return i;

        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM Product WHERE productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        Product product = new Product();
        while(rs.next()){
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try{
            String  queryString = "SELECT * FROM Product";
            PreparedStatement pt = con.prepareStatement(queryString);
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategoryId(rs.getInt("CategoryID"));
                list.add(product);
            }
            System.out.println("successful");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }

    public byte[] getPicture(Integer productId, Connection con) throws SQLException{
        byte[] imgByte=null;
        String sql="SELECT picture FROM product WHERE productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        while(rs.next()){
            Blob blob = rs.getBlob("picture");
            imgByte = blob.getBytes(1,(int)blob.length());
        }

        return imgByte;
    }

    public int save(Product product, InputStream inputStream, Connection con) {
    }
}
