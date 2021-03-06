package com.chainsys.product.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import com.chainsys.product.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Product> productSet;

	public ProductDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Product> findAll() {
		try {
			pstmt = con.prepareStatement("select * from product_2608");
			rs = pstmt.executeQuery();
			productSet = new HashSet<>();
			while (rs.next()) {
				Product product = new Product(rs.getInt("p_id"), rs.getString("p_name"),
						rs.getDate("expiry_date").toLocalDate());
				productSet.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSet;
	}
	
	@Override
	public List<String> ViewAllProductName() {
		ArrayList<String> nameList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement("select p_name from product_2608");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				nameList.add(rs.getString("p_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	@Override
	public List<Integer> ViewAllProductId(){
		ArrayList<Integer> idList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement("select p_id from product_2608");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idList.add(rs.getInt("p_id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return idList;
	}

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2608 where p_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_id"), rs.getString("p_name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product findByName(String name) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2608 where p_name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_id"), rs.getString("p_name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}	
	
	@Override
	public Product findByDate(LocalDate date) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2608 where expiry_date=?");
			pstmt.setDate(1, Date.valueOf(date));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_id"), rs.getString("p_name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}	
	
	@Override
	public void save(Product product) {
		try {
			pstmt = con.prepareStatement("insert into product_2608 values(?,?,?)");
			pstmt.setInt(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setDate(3, Date.valueOf(product.getExpiryDate()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2608 set p_name=? where p_id=?");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void updateExpire(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2608 set expiry_date=? where p_id=?");
			pstmt.setDate(1, Date.valueOf(product.getExpiryDate()));
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			pstmt = con.prepareStatement("delete product_2608 where p_id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteByName(String name) {
		try {
			pstmt = con.prepareStatement("delete product_2608 where p_name=?");
			pstmt.setString(1,name);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
		
		@Override
		public void deleteByDate(LocalDate date) {
			try {
				pstmt = con.prepareStatement("delete product_2608 where expiry_date=?");
				pstmt.setDate(1,Date.valueOf(date));
				pstmt.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}		
	}

}
