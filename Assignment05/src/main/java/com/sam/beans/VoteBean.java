package com.sam.beans;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.daos.UserDao;
import com.sam.daos.UserDaoImpl;
import com.sam.entities.User;

public class VoteBean {
	private int candId;
	private boolean success;
	private int userId;

	public VoteBean() {
		// TODO Auto-generated constructor stub
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void vote() {
		this.success = false;

		try (CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.incrementVote(this.candId);

			if (count == 1) {
				try (UserDao userDao = new UserDaoImpl()) {
					User user = userDao.findById(this.userId);
					if (user != null) {
						user.setStatus(1);
						count = userDao.update(user);
						if(count == 1)
							this.success = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

}
