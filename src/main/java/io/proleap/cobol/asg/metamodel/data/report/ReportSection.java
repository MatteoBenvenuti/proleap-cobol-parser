/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.report;

import java.util.List;

import io.proleap.cobol.CobolParser.ReportDescriptionContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface ReportSection extends CobolDivisionElement {

	ReportDescription addReportDescription(ReportDescriptionContext ctx);

	ReportDescription getReportDescription(String name);

	List<ReportDescription> getReportDescriptions();
}
