/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.unstring;

import io.proleap.cobol.CobolParser.UnstringCountInContext;
import io.proleap.cobol.CobolParser.UnstringDelimiterInContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.call.Call;

public interface Into extends CobolDivisionElement {

	CountIn addCountIn(UnstringCountInContext ctx);

	DelimiterIn addDelimiterIn(UnstringDelimiterInContext ctx);

	CountIn getCountIn();

	DelimiterIn getDelimiterIn();

	Call getIntoCall();

	void setIntoCall(Call intoCall);
}
