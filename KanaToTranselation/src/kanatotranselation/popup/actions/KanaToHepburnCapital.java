/**
 *
 */
package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanaToHepburnCapitalTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * @author syany
 *
 */
public class KanaToHepburnCapital extends KanaToHepburn {

	/**
	 *
	 */
	public KanaToHepburnCapital() {
	}

	/* (非 Javadoc)
	 * @see kanatotranselation.popup.actions.KanaToHepburn#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		UraKanaToHepburnCapitalTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kana to Hepburn was executed.");
	}

}
