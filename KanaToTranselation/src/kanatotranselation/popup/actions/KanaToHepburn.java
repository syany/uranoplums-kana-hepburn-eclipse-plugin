package kanatotranselation.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.uranoplums.eclipse.editor.UraEditorProvider;
import org.uranoplums.typical.util.ja.UraRomanTranslationUtils;
import org.uranoplums.typical.util.ja.UraStringUtils;

public class KanaToHepburn implements IEditorActionDelegate {

	/** ダイアログ */
	private Shell shell;
	/** 対象カレントエディタ */
	private IEditorPart targetEditor;

	/*
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		// エディタサービスオブジェクトを取得
		UraEditorProvider e = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection ts = e.getTextSelection();
		if (ts == null || ts.getLength() == 0) {
			// 未選択の場合は終了
			return;
		}

		// 選択されている場合は文字列を取得し
		String ss = ts.getText();
		// ヘボン式に変換する
		e.replaceSelection(ts, UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(ss)));

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
