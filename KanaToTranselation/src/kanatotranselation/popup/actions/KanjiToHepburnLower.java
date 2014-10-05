/**
 *
 */
package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanjiToHepburnLowerTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * @author syany
 *
 */
public class KanjiToHepburnLower extends KanjiToHepburn {
	/*
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		//Translation.getInstance().kanjiToHepburnLower(targetEditor);  //getKanjiToHepburn
		UraKanjiToHepburnLowerTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kanji to Hepburn was executed.");
	}
}
