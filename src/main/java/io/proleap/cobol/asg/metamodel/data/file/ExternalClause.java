/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.file;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface ExternalClause extends CobolDivisionElement {

	boolean isExternal();

	void setExternal(boolean external);
}
