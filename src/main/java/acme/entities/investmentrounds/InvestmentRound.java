
package acme.entities.investmentrounds;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.components.Round;
import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				creationMoment;

	@NotNull
	private Round				round;

	@NotBlank
	private String				title;

	@NotBlank
	@Column(length = 1024)
	private String				description;

	public boolean				status;

	@Valid
	@NotNull
	private Money				amountMoney;

	@URL
	private String				moreInfo;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

}
