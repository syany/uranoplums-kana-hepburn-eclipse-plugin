/**
 *
 */
package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanjiToHepburnCapitalTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * @author syany
 *
 */
public class KanjiToHepburnCapital extends KanjiToHepburn {

	/**
	 *
	 */
	public KanjiToHepburnCapital() {
	}

	/* (非 Javadoc)
	 * @see kanatotranselation.popup.actions.KanaToHepburn#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		UraKanjiToHepburnCapitalTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kanji to Hepburn was executed.");
	}

}
