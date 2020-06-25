
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.entities.creditcards.CreditCard;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patron extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				organisationName;

	@Valid
	private CreditCard			creditCard;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
