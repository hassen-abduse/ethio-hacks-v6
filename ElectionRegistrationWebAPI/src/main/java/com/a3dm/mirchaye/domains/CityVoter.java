package com.a3dm.mirchaye.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "city_voters",
	uniqueConstraints=@UniqueConstraint(columnNames = { "phone_number" }
	)
)
public class CityVoter {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long voterPIN;
	
	@Column(name="woreda_id")
	public String weredaId;
	public String city;
	public String subcity;
	public String woreda;
	
	@Column(name="phone_number")
	public String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	public static enum Status {
		PENDING,VERIFIED,REJECTED
	}
}
