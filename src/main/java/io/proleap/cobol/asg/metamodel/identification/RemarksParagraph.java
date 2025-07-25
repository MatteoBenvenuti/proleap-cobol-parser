/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.identification;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

/**
 * Describes the function of the program.
 */
public interface RemarksParagraph extends CobolDivisionElement {

	String getRemarks();

	void setRemarks(String remarks);

}
