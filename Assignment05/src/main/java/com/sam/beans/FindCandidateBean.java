package com.sam.beans;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

public class FindCandidateBean {
	private int candId;
	private Candidate cand;
	
	public FindCandidateBean() {
		// TODO Auto-generated constructor stub
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}
	
	public void findCandidate()
	{
		try (CandidateDao candDao = new CandidateDaoImpl()){
			this.cand= candDao.findById(candId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
			
		}
	}
}
