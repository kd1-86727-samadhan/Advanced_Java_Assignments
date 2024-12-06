package com.sam.beans;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

public class DeleteCandidateBean {
	private int id;
	private int count;

	public DeleteCandidateBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void deleteCandidate() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			this.count = candDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
