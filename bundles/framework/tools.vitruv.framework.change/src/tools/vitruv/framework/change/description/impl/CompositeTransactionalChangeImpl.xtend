package tools.vitruv.framework.change.description.impl

import tools.vitruv.framework.change.description.CompositeTransactionalChange
import tools.vitruv.framework.change.description.TransactionalChange
import tools.vitruv.framework.change.description.VitruviusChangeFactory

class CompositeTransactionalChangeImpl extends AbstractCompositeChangeImpl<TransactionalChange> implements CompositeTransactionalChange {
	
	override removeChange(TransactionalChange change) {
		if (change != null && this.changes.contains(change)) {
			if (changes.size == 1) {
				val emptyChange = VitruviusChangeFactory.instance.createEmptyChange(change.URI);
				this.changes += emptyChange;	
			}
		}
		super.removeChange(change);
	}
	
}