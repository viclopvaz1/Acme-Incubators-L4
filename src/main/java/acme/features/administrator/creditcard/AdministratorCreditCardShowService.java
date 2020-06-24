
package acme.features.administrator.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.creditcards.CreditCard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCreditCardShowService implements AbstractShowService<Administrator, CreditCard> {

	@Autowired
	AdministratorCreditCardRepository repository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;

		return true;
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
	public CreditCard findOne(final Request<CreditCard> request) {
		assert request != null;

		CreditCard result;
		int id = request.getModel().getInteger("bannerid");
		result = this.repository.findOneByBannerId(id);

		return result;
	}

}
