
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.creditcards.CreditCard;
import acme.features.administrator.creditcard.AdministratorCreditCardRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorBannerDeleteService implements AbstractDeleteService<Administrator, Banner> {

	@Autowired
	AdministratorBannerRepository		repository;

	@Autowired
	AdministratorCreditCardRepository	creditCardRepository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "finalMode", "numCreditCard");

	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;

		Banner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Banner> request, final Banner entity) {
		assert request != null;
		assert entity != null;

		if (this.creditCardRepository.findCreditCardByBannerId(entity.getId()) == 1) {
			CreditCard cc = this.creditCardRepository.findOneByBannerId(entity.getId());
			this.creditCardRepository.delete(cc);
		}
		this.repository.delete(entity);

	}

}
