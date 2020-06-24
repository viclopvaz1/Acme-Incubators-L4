
package acme.features.administrator.creditcard;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.creditcards.CreditCard;
import acme.features.administrator.banner.AdministratorBannerRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorCreditCardCreateService implements AbstractCreateService<Administrator, CreditCard> {

	@Autowired
	AdministratorCreditCardRepository	repository;

	@Autowired
	AdministratorBannerRepository		bannerRepository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<CreditCard> request, final CreditCard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "holderName", "number", "brand", "monthExp", "yearExp", "cvv");
		model.setAttribute("bannerid", entity.getBanner().getId());
		model.setAttribute("finalmode", entity.getBanner().isFinalMode());
	}

	@Override
	public CreditCard instantiate(final Request<CreditCard> request) {
		assert request != null;
		CreditCard result = new CreditCard();
		Banner banner;
		int bannerid;

		bannerid = request.getModel().getInteger("bannerid");
		banner = this.bannerRepository.findOneById(bannerid);
		result.setBanner(banner);

		return result;
	}

	@Override
	public void validate(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar = Calendar.getInstance();
		Integer month = calendar.get(Calendar.MONTH) + 1;
		Integer year = calendar.get(Calendar.YEAR);

		if (!errors.hasErrors("monthExp")) {
			errors.state(request, entity.getYearExp() > year || entity.getMonthExp() >= month && entity.getYearExp().equals(year), "monthExp", "administrator.credit-card.form.error.monthExp");
		}

		if (!errors.hasErrors("yearExp")) {
			errors.state(request, entity.getYearExp() >= year, "yearExp", "administrator.credit-card.form.error.yearExp");
		}
	}

	@Override
	public void create(final Request<CreditCard> request, final CreditCard entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
