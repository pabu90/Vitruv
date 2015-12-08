package edu.kit.ipd.sdq.xocl4inv.eval.model.util

import org.eclipse.emf.ecore.EObject
import edu.kit.ipd.sdq.xocl4inv.eval.model.ModelFactory
import edu.kit.ipd.sdq.xocl4inv.eval.model.impl.ModelFactoryImpl

class ModelBuilder<T extends EObject> {
	protected T root
	protected final ModelFactory factory = new ModelFactoryImpl()

	def final T build() {
		root
	}

}
