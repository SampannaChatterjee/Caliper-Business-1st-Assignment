package com.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Services {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer serviceId;
	private String serviceName;
	private String availability;

}
