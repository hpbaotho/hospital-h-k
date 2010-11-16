package com.hms.util.swtaddons.autocomplete.text;

import org.eclipse.swt.widgets.Text;

import com.hms.util.swtaddons.autocomplete.AutocompleteContentProposalProvider;
import com.hms.util.swtaddons.autocomplete.AutocompleteSelectorContentProposalProvider;


public class AutocompleteTextSelector extends AutocompleteText {

	public AutocompleteTextSelector(Text text, String[] selectionItems) {
		super(text, selectionItems);
	}

	protected AutocompleteContentProposalProvider getContentProposalProvider(String[] proposals) {
		return new AutocompleteSelectorContentProposalProvider(proposals, this.text);
	}

}
