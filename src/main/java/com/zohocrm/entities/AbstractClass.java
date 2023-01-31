package com.zohocrm.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractClass {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; // doing this because id field is common , so which ever table i create id is required
					 // so instead of creating repetitively i can use this @Id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
