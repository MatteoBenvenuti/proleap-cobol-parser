/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.subtract;

import io.proleap.cobol.CobolParser.SubtractMinuendCorrespondingContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.call.Call;

public interface SubtractCorrespondingStatement extends CobolDivisionElement {

	MinuendCorresponding addMinuend(SubtractMinuendCorrespondingContext ctx);

	MinuendCorresponding getMinuend();

	Call getSubtrahendCall();

	void setSubtrahendCall(Call subtrahendCall);
}
