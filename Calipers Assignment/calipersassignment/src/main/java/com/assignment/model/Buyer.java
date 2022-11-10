package com.assignment.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Buyer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer buyerId;
	private String buyerName;
	private Integer contactNumber;
	private String buyerAddress;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Services> services=new ArrayList<>();
	

}
