package com.mkyong.rest.dao;

import java.sql.SQLException;
import java.util.List;

import com.mkyong.rest.Model.Visitor;

public interface VisitorDAO {

	public Visitor getVisitorById(int id) throws SQLException;

	public List<Visitor> getVisitorList() throws SQLException;

	public void addVisitor(Visitor visitor) throws SQLException;

}
