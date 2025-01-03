package com.sam.beans;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;

	public UpdateCandidateBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void updateCandidate() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = new Candidate(id, name, party, votes);
			this.count = candDao.update(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
