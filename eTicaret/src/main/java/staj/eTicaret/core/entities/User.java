package staj.eTicaret.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
    
    @Column(name = "email") 
	@Email
	@NotBlank
	@NotNull
	private String email;
    
    @Column(name ="password")
	@NotBlank
	@NotNull
	private String password;
	
	
}
