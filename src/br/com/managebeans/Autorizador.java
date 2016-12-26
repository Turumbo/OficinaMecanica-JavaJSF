package br.com.managebeans;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	public void beforePhase(PhaseEvent event) {
	}

	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();

		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}

		// Obtendo LoginBean da sessão
		LoginMB loginMB = context.getApplication().evaluateExpressionGet(context, "#{loginMB}", LoginMB.class);

		if (!loginMB.isUsuarioLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?facesredirect=true");
			context.renderResponse();
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
