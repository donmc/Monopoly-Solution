package mypackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aa.monopoly.MonopolyGame;

public class PlayGameAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlayGameForm playGameForm = (PlayGameForm) form;
		MonopolyGame game = (MonopolyGame) request.getSession().getAttribute("game");
		game.playRound();
		playGameForm.setCurrentRound(game.getRound());
		playGameForm.setPlayers(game.getPlayers());

		return mapping.findForward("play");
	}
}
