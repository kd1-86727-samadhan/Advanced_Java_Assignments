package com.sam.beans;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

public class AddNewCandBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;

	public AddNewCandBean() {
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

	public void addNewCandidate() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = new Candidate(id, name, party, votes);
			int cnt = candDao.save(c);

			if (cnt == 1) {
				count = cnt;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
