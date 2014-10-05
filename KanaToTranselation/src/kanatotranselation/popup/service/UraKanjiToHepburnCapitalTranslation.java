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
public class UraKanjiToHepburnCapitalTranslation extends
		AbsUraKanjiToTranslation {

	private static final UraKanjiToHepburnCapitalTranslation INSTANCE = new UraKanjiToHepburnCapitalTranslation();
	/**
	 *
	 */
	private UraKanjiToHepburnCapitalTranslation() {
	}

	/**
	 * デシリアライズ時使用
	 *
	 * @return 唯一のINSTANCE
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

	public static final UraKanjiToHepburnCapitalTranslation getInstance() {
		return INSTANCE;
	}
	/* (非 Javadoc)
	 * @see kanatotranselation.popup.service.AbsUraKanjiToTranslation#trancslateProcess(org.eclipse.jface.text.ITextSelection, java.lang.String)
	 */
	@Override
	String trancslateProcess(ITextSelection textSelection, String kanaTarget) {
		// 選択されている場合は文字列を取得し
		return UraStringUtils.capitalize(UraRomanTranslationUtils.kanaToHepburn(kanaTarget));
	}

}
