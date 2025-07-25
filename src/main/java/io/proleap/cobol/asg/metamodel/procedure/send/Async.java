/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.send;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.call.Call;

public interface Async extends CobolDivisionElement {

	enum AsyncType {
		BOTTOM, TOP
	}

	AsyncType getAsyncType();

	Call getDataDescriptionEntryCall();

	void setAsyncType(AsyncType asyncType);

	void setDataDescriptionEntryCall(Call dataDescriptionEntryCall);
}
