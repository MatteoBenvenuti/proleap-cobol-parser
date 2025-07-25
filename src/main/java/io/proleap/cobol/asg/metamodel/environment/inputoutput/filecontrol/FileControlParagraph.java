/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol;

import java.util.List;

import io.proleap.cobol.CobolParser.FileControlEntryContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface FileControlParagraph extends CobolDivisionElement {

	FileControlEntry addFileControlEntry(FileControlEntryContext ctx);

	List<FileControlEntry> getFileControlEntries();

	FileControlEntry getFileControlEntry(String name);
}
