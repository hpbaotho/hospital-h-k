package com.hms.util.swtaddons.autocomplete.combo;

import java.util.Arrays;
import java.util.List;


import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Combo;

import com.hms.util.swtaddons.autocomplete.AutocompleteContentProposalProvider;
import com.hms.util.swtaddons.autocomplete.AutocompleteSelectorContentProposalProvider;

public class AutocompleteComboSelector extends AutocompleteCombo {
	
	private final class UpdateProposalListFocusListener implements FocusListener {
		public void focusGained(FocusEvent e) {
			// do nothing				
		}

		public void focusLost(FocusEvent e) {
			Combo theCombo = (Combo) e.getSource();
			List items = Arrays.asList(theCombo.getItems());
			if (! items.contains(theCombo.getText())) {
				theCombo.select(0);
			}
			
		}
	}

	public AutocompleteComboSelector(Combo aCombo) {
		super(aCombo);
		aCombo.addFocusListener(new UpdateProposalListFocusListener());
	}
	
	protected AutocompleteContentProposalProvider getContentProposalProvider(String[] proposals) {
		return new AutocompleteSelectorContentProposalProvider(proposals, this.combo);
	}

}
