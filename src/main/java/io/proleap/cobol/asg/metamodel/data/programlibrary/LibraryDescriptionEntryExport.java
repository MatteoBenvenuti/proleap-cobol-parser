/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.programlibrary;

import io.proleap.cobol.CobolParser.LibraryAttributeClauseFormat1Context;
import io.proleap.cobol.CobolParser.LibraryEntryProcedureClauseFormat1Context;

public interface LibraryDescriptionEntryExport extends LibraryDescriptionEntry {

	ExportAttribute addExportAttribute(LibraryAttributeClauseFormat1Context ctx);

	ExportEntryProcedure addExportEntryProcedure(LibraryEntryProcedureClauseFormat1Context ctx);

	ExportAttribute getExportAttribute();

	ExportEntryProcedure getExportEntryProcedure();
}
