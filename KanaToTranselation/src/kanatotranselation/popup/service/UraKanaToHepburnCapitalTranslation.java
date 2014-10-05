/**
 *
 */
package kanatotranselation.popup.service;

import java.io.ObjectStreamException;

import org.eclipse.jface.text.ITextSelection;
import org.uranoplums.typical.util.ja.UraRomanTranslationUtils;
import org.uranoplums.typical.util.ja.UraStringUtils;

/**
 * @author syany
 *
 */
public class UraKanaToHepburnCapitalTranslation extends AbsUraTranslation {

	private static final UraKanaToHepburnCapitalTranslation INSTANCE = new UraKanaToHepburnCapitalTranslation();

	/**
	 *
	 */
	private UraKanaToHepburnCapitalTranslation() {
	}

	/**
	 * デシリアライズ時使用
	 *
	 * @return 唯一のINSTANCE
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

	public static final UraKanaToHepburnCapitalTranslation getInstance() {
		return INSTANCE;
	}
	/* (非 Javadoc)
	 * @see kanatotranselation.popup.service.AbsUraTranslation#trancslateProcess(org.eclipse.jface.text.ITextSelection)
	 */
	@Override
	protected String trancslateProcess(ITextSelection textSelection) {
		// 選択されている場合は文字列を取得し
		return UraStringUtils.capitalize(UraRomanTranslationUtils.kanaToHepburn(textSelection.getText()));
	}

}
