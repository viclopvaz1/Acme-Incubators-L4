
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.features.administrator.creditcard.AdministratorCreditCardRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorBannerShowService implements AbstractShowService<Administrator, Banner> {

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
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "finalMode", "numCreditCard");
		//		int id;
		//		id = request.getModel().getInteger("id");
		//		int num = this.creditCardRepository.findCreditCardByBannerId(id);
		//		model.setAttribute("numCreditCard", num);
	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;

		Banner result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		int num;
		num = this.creditCardRepository.findCreditCardByBannerId(id);
		result.setNumCreditCard(num);

		return result;
	}

}
