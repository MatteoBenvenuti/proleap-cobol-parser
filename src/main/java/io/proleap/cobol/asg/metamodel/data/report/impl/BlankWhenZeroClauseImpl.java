/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.report.impl;

import io.proleap.cobol.CobolParser.ReportGroupBlankWhenZeroClauseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.report.BlankWhenZeroClause;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;

public class BlankWhenZeroClauseImpl extends CobolDivisionElementImpl implements BlankWhenZeroClause {

	protected boolean blankWhenZero;

	protected ReportGroupBlankWhenZeroClauseContext ctx;

	public BlankWhenZeroClauseImpl(final ProgramUnit programUnit, final ReportGroupBlankWhenZeroClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public boolean isBlankWhenZero() {
		return blankWhenZero;
	}

	@Override
	public void setBlankWhenZero(final boolean blankWhenZero) {
		this.blankWhenZero = blankWhenZero;
	}
}
