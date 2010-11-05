package com.hms.util.swtaddons.autocomplete.text;


import org.eclipse.swt.widgets.Text;

import com.hms.util.swtaddons.autocomplete.AutocompleteContentProposalProvider;
import com.hms.util.swtaddons.autocomplete.AutocompleteInputContentProposalProvider;

public class AutocompleteTextInput extends AutocompleteText {
	
	public AutocompleteTextInput(Text text, String[] selectionItems) {
		super(text, selectionItems);
	}

	protected AutocompleteContentProposalProvider getContentProposalProvider(String[] proposals) {
		return new AutocompleteInputContentProposalProvider(proposals);
	}

}
