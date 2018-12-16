package com.entity;

import java.util.List;

public class GridData {

	private int total;
	
	private List<Register> rows ;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Register> getRows() {
		return rows;
	}

	public void setRows(List<Register> rows) {
		this.rows = rows;
	}

	public GridData() {
		
	}

	public GridData(int total, List<Register> rows) {
		this.total = total;
		this.rows = rows;
	}
	
}
