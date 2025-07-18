/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel;

import java.math.BigDecimal;

import io.proleap.cobol.CobolParser.NumericLiteralContext;

public interface NumericLiteral extends CobolDivisionElement {

	enum NumericLiteralType {
		FLOAT, INTEGER
	}

	@Override
	NumericLiteralContext getCtx();

	NumericLiteralType getNumericLiteralType();

	BigDecimal getValue();

	void setNumericLiteralType(NumericLiteralType numericLiteralType);

	void setValue(BigDecimal value);
}
