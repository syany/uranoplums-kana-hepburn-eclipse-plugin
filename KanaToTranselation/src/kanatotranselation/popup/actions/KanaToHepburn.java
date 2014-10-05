package kanatotranselation.popup.actions;

import kanatotranselation.popup.service.UraKanaToHepburnUpperTranslation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.uranoplums.typical.lang.UraObject;

public class KanaToHepburn extends UraObject implements IEditorActionDelegate {

	/** ダイアログ */
	protected Shell shell;
	/** 対象カレントエディタ */
	protected IEditorPart targetEditor;

	/*
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
//		Translation.getInstance().kanaToHepburn(targetEditor);  //getKanjiToHepburn
		UraKanaToHepburnUpperTranslation.getInstance().translate(targetEditor);

		MessageDialog.openInformation(
			shell,
			"KanaToTranselation",
			"Kana to Hepburn was executed.");
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.targetEditor = targetEditor;
		shell = targetEditor.getSite().getShell();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
