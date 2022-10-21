package com.model;

import javax.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String emailId;
	
	

}
