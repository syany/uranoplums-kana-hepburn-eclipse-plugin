package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanaToHepburnUpperTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

public class KanaToHepburnLower extends KanaToHepburn {

	/*
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		//Translation.getInstance().kanaToHepburnLower(targetEditor);  //getKanjiToHepburn
		UraKanaToHepburnUpperTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kana to Hepburn was executed.");
	}
}
