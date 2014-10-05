/**
 *
 */
package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanjiToHepburnUpperTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * @author syany
 *
 */
public class KanjiToHepburn extends KanaToHepburn {
	/*
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		//Translation.getInstance().kanjiToHepburn(targetEditor);  //getKanjiToHepburn
		UraKanjiToHepburnUpperTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kanji to Hepburn was executed.");
	}
}
