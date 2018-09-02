package com.husen.store.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.husen.store.dao.OrderDao;
import com.husen.store.entity.Order;
import com.husen.store.mysql.DBHelper;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int insert(Order order) {
		// 有条件插入
		String sql = "insert into orders (orderId,orderNumber,staffName,productId,unitPrice) values (?,?,?,?,?)";
		// 1.加载数据库，稍后实现
		// 自动资源管理
		try (
				// 2.创建数据库连接
				Connection con = DBHelper.getConnection();
				// 3.创建预处理语句对象
				PreparedStatement pstmt = con.prepareStatement(sql);

		) {
			// 4.绑定参数
			pstmt.setInt(1, order.getOrderId());
			pstmt.setInt(2, order.getOrderNumber());
			pstmt.setString(3, order.getStaffName());
			pstmt.setString(4, order.getProductId());
			pstmt.setDouble(5, order.getUnitPrice());
			java.util.Date now = new java.util.Date();
			// 5.执行
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Order> findAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from orders";
		try(
				Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
		while(rs.next()){
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setOrderNumber(rs.getInt("orderNumber"));
			order.setStaffName(rs.getString("staffName"));
			order.setProductId(rs.getString("productId"));
			order.setUnitPrice(rs.getDouble("unitPrice"));
			list.add(order);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> findByProductId(String productId) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from orders where productId="+productId;
		try(
				Connection con = DBHelper.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
		while(rs.next()){
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setOrderNumber(rs.getInt("orderNumber"));
			order.setStaffName(rs.getString("staffName"));
			order.setProductId(rs.getString("productId"));
			order.setUnitPrice(rs.getDouble("unitPrice"));
			list.add(order);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
