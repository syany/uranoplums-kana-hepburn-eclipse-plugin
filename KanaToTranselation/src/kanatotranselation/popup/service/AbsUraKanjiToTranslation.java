/**
 *
 */
package kanatotranselation.popup.service;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.eclipse.jface.text.ITextSelection;


/**
 * @author syany
 *
 */
public abstract class AbsUraKanjiToTranslation extends AbsUraTranslation {
	/**  */
	protected static final Tokenizer TOKENIZER = Tokenizer.builder().build();
	/**
	 *
	 */
	protected AbsUraKanjiToTranslation() {
		super();
	}
	/* (非 Javadoc)
	 * @see kanatotranselation.popup.service.AbsUraTranslation#trancslate(org.eclipse.jface.text.ITextSelection)
	 */
	@Override
	protected String trancslateProcess(ITextSelection textSelection) {
		// 選択されている場合は文字列を取得し
		StringBuilder stringBuilder = new StringBuilder();
		for(Token t: TOKENIZER.tokenize(textSelection.getText())) {
			stringBuilder.append((t.getReading() != null)?t.getReading():t.getSurfaceForm());
		}
		return trancslateProcess(textSelection, stringBuilder.toString());
	}
	/**
	 *
	 * @param textSelection
	 * @param kanaTarget
	 * @return
	 */
	abstract String trancslateProcess(ITextSelection textSelection, String kanaTarget);
}
