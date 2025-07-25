/*
 * Copyright (C) 2017, Ulrich Wolffgang <ulrich.wolffgang@proleap.io>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.file;

import java.util.List;

import io.proleap.cobol.CobolParser.FileDescriptionEntryContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface FileSection extends CobolDivisionElement {

	FileDescriptionEntry addFileDescriptionEntry(FileDescriptionEntryContext ctx);

	List<FileDescriptionEntry> getFileDescriptionEntries();

	FileDescriptionEntry getFileDescriptionEntry(String name);

}
