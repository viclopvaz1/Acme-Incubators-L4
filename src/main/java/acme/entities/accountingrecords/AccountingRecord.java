
package acme.entities.accountingrecords;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Investor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountingRecord extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	private boolean				status;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				creationMoment;

	@NotBlank
	@Column(length = 1024)
	private String				moneyOffer;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Investor			investor;

}
