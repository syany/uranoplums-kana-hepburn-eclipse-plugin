/**
 *
 */
package kanatotranselation.popup.service;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.uranoplums.eclipse.editor.UraEditorProvider;
import org.uranoplums.typical.lang.UraObject;

/**
 * @author syany
 *
 */
public abstract class AbsUraTranslation extends UraObject implements UraTranslator {
	/* (非 Javadoc)
	 * @see kanatotranselation.popup.service.UraTranslator#translate()
	 */
	@Override
	public boolean translate(IEditorPart targetEditor) {
		// エディタサービスオブジェクトを取得
		UraEditorProvider uraEditorProvider = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection textSelection = uraEditorProvider.getTextSelection();
		if (textSelection == null || textSelection.getLength() == 0) {
			// 未選択の場合は終了
			return false;
		}
		String target = trancslateProcess(textSelection);
		// ヘボン式に変換する
		uraEditorProvider.replaceSelection(textSelection, target);
		return true;
	}
	/**
	 *
	 */
	protected AbsUraTranslation() {
		super();
	}
	/**
	 *
	 * @param textSelection
	 * @return
	 */
	abstract protected String trancslateProcess(ITextSelection textSelection);
}
