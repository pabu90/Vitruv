/*******************************************************************************
 * Copyright (c) 2015 Sebastian Fiss.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Sebastian Fiss - initial API and implementation and/or initial documentation
 *******************************************************************************/
package edu.kit.ipd.sdq.xocl4inv.transformation.model

/**
 * Binary node that represents all binary operations except AND and OR.
 * 
 * @author sfiss
 */
class BinaryNode extends AbstractBinaryNode {
	override def Object clone() {
		super.clone() as BinaryNode
	}
}