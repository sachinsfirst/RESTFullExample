package com.mkyong.rest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mkyong.rest.Model.Visitor;
import com.mkyong.rest.dao.VisitorDAO;

public class VisitorDAOImpl implements VisitorDAO {

	/* (non-Javadoc)
	 * @see com.mkyong.rest.dao.VisitorDAO#getVisitorById(int)
	 */
	@Override
	public Visitor getVisitorById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Visitor visitor = null;
		String sql = "select Id, Name, Email, ContactNumber, Address from Visitor"
				+ " where Id = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/visitordb", "root",
					"wr6BReGU@");
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				visitor = new Visitor();
				visitor.setId(rs.getInt("Id"));
				visitor.setName(rs.getString("Name"));
				visitor.setEmail(rs.getString("Email"));
				visitor.setContactNumber(rs.getLong("ContactNumber"));
				visitor.setAddress(rs.getString("Address"));

			} else {
				System.out.println("Customer with ID of %d is not found." + id);
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (rs != null || ps != null) {
				rs.close();
				ps.close();
				conn.close();
			}
		}

		return visitor;
	}

	/* (non-Javadoc)
	 * @see com.mkyong.rest.dao.VisitorDAO#getVisitorList()
	 */
	@Override
	public List<Visitor> getVisitorList() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Visitor visitor = null;
		String sql = "select * from Visitor";
		List<Visitor> visitors = new ArrayList<Visitor>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/visitordb", "root",
					"wr6BReGU@");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				visitor = new Visitor();
				visitor.setId(rs.getInt("Id"));
				visitor.setName(rs.getString("Name"));
				visitor.setEmail(rs.getString("Email"));
				visitor.setContactNumber(rs.getLong("ContactNumber"));
				visitor.setAddress(rs.getString("Address"));
				visitors.add(visitor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (rs != null || stmt != null) {
				rs.close();
				stmt.close();
				conn.close();
			}
		}

		return visitors;
	}

	@Override
	public void addVisitor(Visitor visitor) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO Visitor"
				+ "(Id, Name, Email, ContactNumber, Address) VALUES"
				+ "(?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/visitordb", "root",
					"wr6BReGU@");
			ps = conn.prepareStatement(sql);

			ps.setInt(1, visitor.getId());
			ps.setString(2, visitor.getName());
			ps.setString(3, visitor.getEmail());
			ps.setLong(4, visitor.getContactNumber());
			ps.setString(5, visitor.getAddress());

			// execute insert SQL stetement
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}
		}
	}

	public Visitor deleteVisitorById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		Visitor visitor = null;
		String sql = "Delete from Visitor"
				+ " where Id = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/visitordb", "root",
					"wr6BReGU@");
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
				conn.close();
			}
		}

		return visitor;
	}

}
