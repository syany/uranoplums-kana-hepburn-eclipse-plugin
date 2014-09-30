/**
 *
 */
package kanatotranselation.popup.actions;

import java.io.ObjectStreamException;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.uranoplums.eclipse.editor.UraEditorProvider;
import org.uranoplums.typical.lang.UraObject;
import org.uranoplums.typical.util.ja.UraRomanTranslationUtils;
import org.uranoplums.typical.util.ja.UraStringUtils;

/**
 * @author syany
 *
 */
public class Translation extends UraObject {

	private static final Translation INSTANCE = new Translation();

	private static final Tokenizer TOKENIZER = Tokenizer.builder().build();

	private Translation(){

	}
	/**
	 * デシリアライズ時使用
	 *
	 * @return 唯一のINSTANCE
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}
	public static final Translation getInstance(){
		return INSTANCE;
	}
//
//	private final String getKanaToHepburn(ITextSelection ts) {
//
//		// 選択されている場合は文字列を取得し
//		String ss = ts.getText();
//		return UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(ss));
//	}
//	private final String getKanjiToHepburn(ITextSelection ts) {
//
//		StringBuilder sb = new StringBuilder();
//		for(Token t: TOKENIZER.tokenize(ts.getText())) {
//			String s = UraRomanTranslationUtils.kanaToHepburn((t.getReading() != null)?t.getReading():t.getSurfaceForm(), 0);
//			sb.append(UraStringUtils.capitalize(s.toLowerCase()));
//		}
//		// ヘボン式に変換する
//		return UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(sb.toString()));
//	}
	public final boolean kanaToHepburn(IEditorPart targetEditor) {

		// エディタサービスオブジェクトを取得
		UraEditorProvider e = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection ts = e.getTextSelection();
		if (ts == null || ts.getLength() == 0) {
			// 未選択の場合は終了
			return false;
		}

		// 選択されている場合は文字列を取得し

		// 選択されている場合は文字列を取得し
		String ss = UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(ts.getText()));
		//String ss = getKanaToHepburn(ts);
		// ヘボン式に変換する
		e.replaceSelection(ts, ss);
		return true;
	}

	public final boolean kanjiToHepburn(IEditorPart targetEditor) {
		// エディタサービスオブジェクトを取得
		UraEditorProvider e = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection ts = e.getTextSelection();
		if (ts == null || ts.getLength() == 0) {
			// 未選択の場合は終了
			return false;
		}
		// 選択されている場合は文字列を取得し
		StringBuilder sb = new StringBuilder();
		for(Token t: TOKENIZER.tokenize(ts.getText())) {
			String s = UraRomanTranslationUtils.kanaToHepburn((t.getReading() != null)?t.getReading():t.getSurfaceForm(), 0);
			sb.append(UraStringUtils.capitalize(s.toLowerCase()));
		}
		// ヘボン式に変換する
		String ss = UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(sb.toString()));
		//String ss = getKanjiToHepburn(ts);
		// ヘボン式に変換する
		e.replaceSelection(ts, ss);
		return true;
	}
	public final boolean kanaToHepburnLower(IEditorPart targetEditor) {

		// エディタサービスオブジェクトを取得
		UraEditorProvider e = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection ts = e.getTextSelection();
		if (ts == null || ts.getLength() == 0) {
			// 未選択の場合は終了
			return false;
		}

		// 選択されている場合は文字列を取得し
		String ss = UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(" ".concat(ts.getText())));
		//ss = ss.substring(0, 1).toLowerCase().concat(ss.substring(1));
		// ヘボン式に変換する
		e.replaceSelection(ts, ss.substring(1));
		return true;
	}

	public final boolean kanjiToHepburnLower(IEditorPart targetEditor) {
		// エディタサービスオブジェクトを取得
		UraEditorProvider e = UraEditorProvider.getInstance(targetEditor);
		// 選択文字列を取得し
		ITextSelection ts = e.getTextSelection();
		if (ts == null || ts.getLength() == 0) {
			// 未選択の場合は終了
			return false;
		}
		// 選択されている場合は文字列を取得し
		StringBuilder sb = new StringBuilder();
		for(Token t: TOKENIZER.tokenize(ts.getText())) {
			String s = UraRomanTranslationUtils.kanaToHepburn((t.getReading() != null)?t.getReading():t.getSurfaceForm(), 0);
			sb.append(UraStringUtils.capitalize(s.toLowerCase()));
		}
		// ヘボン式に変換する
		String ss = UraStringUtils.camelize(UraRomanTranslationUtils.kanaToHepburn(" ".concat(sb.toString())));
		//String ss = getKanjiToHepburn(ts);
		//ss = ss.substring(0, 1).toLowerCase().concat(ss.substring(1));
		// ヘボン式に変換する
		e.replaceSelection(ts, ss.substring(1));
		return true;
	}
}
