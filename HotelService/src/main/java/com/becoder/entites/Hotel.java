package com.becoder.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
