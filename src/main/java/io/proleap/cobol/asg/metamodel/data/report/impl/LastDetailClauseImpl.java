/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.report.impl;

import io.proleap.cobol.CobolParser.ReportDescriptionLastDetailClauseContext;
import io.proleap.cobol.asg.metamodel.IntegerLiteral;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.report.LastDetailClause;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;

public class LastDetailClauseImpl extends CobolDivisionElementImpl implements LastDetailClause {

	protected final ReportDescriptionLastDetailClauseContext ctx;

	protected IntegerLiteral lastDetailIntegerLiteral;

	public LastDetailClauseImpl(final ProgramUnit programUnit, final ReportDescriptionLastDetailClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public IntegerLiteral getLastDetailIntegerLiteral() {
		return lastDetailIntegerLiteral;
	}

	@Override
	public void setLastDetailIntegerLiteral(final IntegerLiteral lastDetailIntegerLiteral) {
		this.lastDetailIntegerLiteral = lastDetailIntegerLiteral;
	}

}
