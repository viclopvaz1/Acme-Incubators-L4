<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="administrator.banner.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.label.targetUrl" path="targetUrl"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-checkbox code="administrator.banner.label.finalMode" path="finalMode"/>
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="administrator.banner.form.button.create" action="create"/>
	<acme:form-submit test="${command == 'show' && finalMode == false}" code="administrator.banner.form.button.update" action="update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.banner.form.button.delete" action="delete"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.banner.form.button.update" action="update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.banner.form.button.delete" action="delete"/>
		
	<acme:form-submit test="${(command == 'show' || command == 'update') && numCreditCard == 1}" code="administrator.banner.form.button.credit-card" action="/administrator/credit-card/show?bannerid=${id}&finalmodel=${finalMode}"  method="get"/>
	<acme:form-submit test="${(command == 'show' || command == 'update') && finalMode == false && numCreditCard == 0}" code="administrator.banner.form.button.create-credit-card" action="/administrator/credit-card/create?bannerid=${id}" method="get"/>
	
	<acme:form-return code="administrator.banner.form.button.return"/>


</acme:form> 