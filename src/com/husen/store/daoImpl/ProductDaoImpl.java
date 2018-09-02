package com.husen.store.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.husen.store.dao.ProductDao;
import com.husen.store.entity.Product;
import com.husen.store.mysql.DBHelper;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product findById(String productId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		String sql = "select * from product where productid = ?";
		// 1.加载驱动程序
		try {
			// 2.创建数据库链接
			con = DBHelper.getConnection();
			// 3.得到预处理语句对象
			pstmt = con.prepareStatement(sql);
			// 4.绑定参数
			pstmt.setString(1, productId);
			// 5.执行查询
			rs = pstmt.executeQuery();
			// 6.遍历结果集
			// 结果为一个，所以是if
			if (rs.next()) {
				Product p = new Product();
				p.setProductId(productId);
				p.setProductName(rs.getString("productName"));
				p.setUnitPrice(rs.getDouble("unitPrice"));
				p.setSurplusNumber(rs.getInt("surplusNumber"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		try (Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setSurplusNumber(rs.getInt("surplusNumber"));
				product.setProductId(rs.getString("productId"));
				product.setUnitPrice(rs.getDouble("unitPrice"));
				list.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Product product) {
		String sql = "update product set surplusNumber="+product.getSurplusNumber()+" where productId=" + product.getProductId();
		try (Connection con = DBHelper.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
