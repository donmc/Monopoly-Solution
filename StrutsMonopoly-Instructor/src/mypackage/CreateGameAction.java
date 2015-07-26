package mypackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.aa.monopoly.MonopolyGame;

public class CreateGameAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response)	 throws Exception {
		CreateGameForm createGameForm = (CreateGameForm) form;
		String forward = "create";
		
		if (createGameForm.isNew()) {
			createGameForm.setRoundLimit(5);
			createGameForm.setNumberOfPlayers(2);
			createGameForm.setNew(false);
		} else {			
			try {
				MonopolyGame game = new MonopolyGame(createGameForm.getNumberOfPlayers());
				request.getSession().setAttribute("game", game);
				forward = "play";
			} catch (IllegalArgumentException e) {
				ActionMessages errors = new ActionMessages();
	            errors.add("numberOfPlayers", new ActionMessage("error.numberOfPlayers"));
	            saveErrors(request, errors);
			}
		}
		
		
		return mapping.findForward(forward);
	}
}
