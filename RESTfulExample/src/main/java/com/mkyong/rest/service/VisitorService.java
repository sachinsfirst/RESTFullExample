package com.mkyong.rest.service;

import java.sql.SQLException;
import java.util.List;

import com.mkyong.rest.Model.Visitor;
import com.mkyong.rest.dao.impl.VisitorDAOImpl;

public class VisitorService {

	public List<Visitor> getVisitorList() {
		List<Visitor> visitors = null;
		try {
			visitors =  new VisitorDAOImpl().getVisitorList();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return visitors;
	}

	/**
	 * @param id
	 * @return
	 */
	public Visitor getVisitorById(int id) {
		Visitor visitor = null;
		try {
			visitor = new VisitorDAOImpl().getVisitorById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitor;
	}

	/**
	 * @param visitor
	 */
	public void addVisitor(Visitor visitor) {
		try {
			new VisitorDAOImpl().addVisitor(visitor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public Visitor deleteVisitorById(int id) {
		Visitor visitor = null;
		try {
			visitor = new VisitorDAOImpl().deleteVisitorById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitor;
	}
}
