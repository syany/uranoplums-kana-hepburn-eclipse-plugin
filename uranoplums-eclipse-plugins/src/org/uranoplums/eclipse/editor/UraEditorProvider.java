/**
 *
 */
package org.uranoplums.eclipse.editor;

import java.io.ObjectStreamException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.uranoplums.typical.lang.UraObject;

/**
 * @author syany
 *
 */
public class UraEditorProvider extends UraObject {

	private static final UraEditorProvider INSTANCE = new UraEditorProvider();

	private static final ThreadLocal<IEditorPart> EDITOR_PART = new ThreadLocal<IEditorPart>() {
		/* (非 Javadoc)
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected IEditorPart initialValue() {
			return null;
		}
	};

	private UraEditorProvider() {
	}

	/**
	 * デシリアライズ時使用
	 *
	 * @return 唯一のINSTANCE
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

	public static final UraEditorProvider getInstance(IEditorPart editorPart) {
		if (EDITOR_PART.get() == null) {
			EDITOR_PART.set(editorPart);
		}
		return INSTANCE;
	}

	/**
	 *
	 * @return
	 */
	public String getDocument() {
		IDocument document = getDocumentProvider().getDocument(
				EDITOR_PART.get().getEditorInput());
		return document.get();
	}

	/**
	 *
	 * @return
	 */
	public IDocumentProvider getDocumentProvider() {
		ITextEditor textEditor = (ITextEditor) EDITOR_PART.get();
		return textEditor.getDocumentProvider();
	}

	/**
	 *
	 * @param selection
	 * @param target
	 */
	public void replaceSelection(ISelection selection, String target) {
		if (target == null) {
			return;
		}
		ITextSelection textSelection = (ITextSelection) selection;
		if (textSelection == null || textSelection.getLength() == 0) {
			return;
		}
		IDocument document = getDocumentProvider().getDocument(
				EDITOR_PART.get().getEditorInput());
		try {
			document.replace(textSelection.getOffset(),
					textSelection.getLength(), target);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param target
	 */
	public void replaceSelection(String target) {
		replaceSelection(getTextSelection(), target);
	}
	/**
	 *
	 * @return
	 */
	public ITextSelection getTextSelection() {
		ITextEditor textEditor = (ITextEditor) EDITOR_PART.get();
		ISelectionProvider selectionProvider = textEditor
				.getSelectionProvider();
		return (ITextSelection) selectionProvider.getSelection();
	}
}
