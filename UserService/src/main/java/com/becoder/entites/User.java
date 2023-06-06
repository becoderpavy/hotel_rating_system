package com.becoder.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

	@Id
	private String userId;

	private String name;

	private String email;

	private String about;

	@Transient
	private List<Rating> ratings=new ArrayList<>();

}
