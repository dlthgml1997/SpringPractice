package com.sohee.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sohee.model.dto.Product;
import com.sohee.util.DBUtil;

public class ProductRepoImpl implements ProductRepo{

	// DB와의 connection에 사용됩니다.
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Product> selectAll() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, price, description \n");
			sql.append("from product \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Product select(String id) throws SQLException{
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, price, description \n");
			sql.append("from product \n");
			sql.append("where id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return product;
	}

	@Override
	public int insert(Product product) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder insertProduct = new StringBuilder();
			insertProduct.append("insert into product (id, name, price, description) \n");
			insertProduct.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(insertProduct.toString());
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int update(Product product) throws Exception {
		int result =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("update product \n");
			insertMember.append("set name = ?, price = ?, description = ? \n");
			insertMember.append("where id = ?");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getId());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int delete(String id) throws Exception {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("delete from product \n");
			insertMember.append("where id = ?");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}
}
