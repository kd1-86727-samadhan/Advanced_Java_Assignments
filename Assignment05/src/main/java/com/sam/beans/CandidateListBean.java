package com.sam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

public class CandidateListBean {
	private List<Candidate> candList;
	
	public CandidateListBean() {
		candList  = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidates() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			this.candList = candDao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
