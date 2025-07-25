/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.programlibrary.impl;

import io.proleap.cobol.CobolParser.LibraryIsCommonClauseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.programlibrary.CommonClause;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;

public class CommonClauseImpl extends CobolDivisionElementImpl implements CommonClause {

	protected boolean common;

	protected LibraryIsCommonClauseContext ctx;

	public CommonClauseImpl(final ProgramUnit programUnit, final LibraryIsCommonClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public boolean isCommon() {
		return common;
	}

	@Override
	public void setCommon(final boolean common) {
		this.common = common;
	}

}
