/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.inspect.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.CobolParser.InspectBeforeAfterContext;
import io.proleap.cobol.CobolParser.InspectByContext;
import io.proleap.cobol.CobolParser.InspectReplacingAllLeadingContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.procedure.inspect.BeforeAfterPhrase;
import io.proleap.cobol.asg.metamodel.procedure.inspect.By;
import io.proleap.cobol.asg.metamodel.procedure.inspect.ReplacingAllLeading;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;

public class ReplacingAllLeadingImpl extends InspectPhraseImpl implements ReplacingAllLeading {

	protected List<BeforeAfterPhrase> beforeAfterPhrases = new ArrayList<BeforeAfterPhrase>();

	protected By by;

	protected final InspectReplacingAllLeadingContext ctx;

	protected ValueStmt patternDataItemValueStmt;

	public ReplacingAllLeadingImpl(final ProgramUnit programUnit, final InspectReplacingAllLeadingContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public BeforeAfterPhrase addBeforeAfterPhrase(final InspectBeforeAfterContext ctx) {
		BeforeAfterPhrase result = (BeforeAfterPhrase) getASGElement(ctx);

		if (result == null) {
			result = createBeforeAfterPhrase(ctx);
			beforeAfterPhrases.add(result);
		}

		return result;
	}

	@Override
	public By addBy(final InspectByContext ctx) {
		By result = (By) getASGElement(ctx);

		if (result == null) {
			result = createBy(ctx);
			by = result;
		}

		return result;
	}

	@Override
	public List<BeforeAfterPhrase> getBeforeAfterPhrases() {
		return beforeAfterPhrases;
	}

	@Override
	public By getBy() {
		return by;
	}

	@Override
	public ValueStmt getPatternDataItemValueStmt() {
		return patternDataItemValueStmt;
	}

	@Override
	public void setPatternDataItemValueStmt(final ValueStmt patternDataItemValueStmt) {
		this.patternDataItemValueStmt = patternDataItemValueStmt;
	}

}
