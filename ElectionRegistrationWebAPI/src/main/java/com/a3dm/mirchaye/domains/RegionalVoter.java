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
@Table(name = "regional_voters",
	uniqueConstraints=@UniqueConstraint(columnNames = { "phone_number" }
	)
)
public class RegionalVoter {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long voterPIN;
	
	@Column(name="kebele_id")
	public String kebeleId;
	public String region;
	public String zone;
	public String woreda;
	public String kebele;
	
	
	@Column(name="phone_number")
	public String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	public static enum Status {
		PENDING,VERIFIED,REJECTED
	}
}

