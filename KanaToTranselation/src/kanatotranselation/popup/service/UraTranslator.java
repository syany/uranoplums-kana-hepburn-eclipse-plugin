/**
 *
 */
package kanatotranselation.popup.service;

import org.eclipse.ui.IEditorPart;


/**
 * @author syany
 *
 */
public interface UraTranslator {
	/**
	 * 変換IFメソッド
	 * @return 変換正常完了の場合はtrue
	 */
	public boolean translate(IEditorPart targetEditor);
}
