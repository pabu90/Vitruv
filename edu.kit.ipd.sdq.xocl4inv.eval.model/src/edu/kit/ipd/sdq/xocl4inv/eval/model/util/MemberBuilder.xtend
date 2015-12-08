package edu.kit.ipd.sdq.xocl4inv.eval.model.util

import edu.kit.ipd.sdq.xocl4inv.eval.model.Member

class MemberBuilder extends ModelBuilder<Member> {
	new(String name) {
		this.root = factory.createMember()
		root.setName(name)
	}
}
