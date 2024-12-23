package com.ipl.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = "myteam")
@NoArgsConstructor
public class Owner extends BaseEntity {

	@Column(length = 30)
	private String name;

	@Column(length = 50, unique = true)
	private String email;

	@Column(length = 50)
	private String company;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	private Teams myteam;

	public Owner(String name, String email, String company) {
		this.name = name;
		this.email = email;
		this.company = company;
	}

}
