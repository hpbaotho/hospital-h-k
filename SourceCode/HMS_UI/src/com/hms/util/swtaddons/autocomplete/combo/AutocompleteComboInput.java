package com.hms.util.swtaddons.autocomplete.combo;


import org.eclipse.swt.widgets.Combo;

import com.hms.util.swtaddons.autocomplete.AutocompleteContentProposalProvider;
import com.hms.util.swtaddons.autocomplete.AutocompleteInputContentProposalProvider;

public class AutocompleteComboInput extends AutocompleteCombo {
	
	public AutocompleteComboInput(Combo combo) {
		super(combo);
	}

	protected AutocompleteContentProposalProvider getContentProposalProvider(String[] proposals) {
		return new AutocompleteInputContentProposalProvider(proposals);
	}

}
