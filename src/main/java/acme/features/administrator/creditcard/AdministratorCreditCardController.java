
package acme.features.administrator.creditcard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.creditcards.CreditCard;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/credit-card/")
public class AdministratorCreditCardController extends AbstractController<Administrator, CreditCard> {

	@Autowired
	private AdministratorCreditCardShowService		showService;

	@Autowired
	private AdministratorCreditCardCreateService	createService;

	@Autowired
	private AdministratorCreditCardUpdateService	updateService;

	@Autowired
	private AdministratorCreditCardDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
