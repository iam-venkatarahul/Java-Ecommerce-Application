package com.ecommerce.project.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	
	@ToString.Exclude
	@Enumerated(EnumType.STRING)
	@Column(length = 20 , name ="role_name" )
	private AppRole roleName;

	public Role(AppRole roleName) {
		super();
		this.roleName = roleName;
	}
}
