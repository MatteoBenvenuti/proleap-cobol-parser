package io.proleap.cobol.asg.data.localstorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Test;

import io.proleap.cobol.CobolTestBase;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.DataDivision;
import io.proleap.cobol.asg.metamodel.data.datadescription.DataDescriptionEntry;
import io.proleap.cobol.asg.metamodel.data.datadescription.DataDescriptionEntry.DataDescriptionEntryType;
import io.proleap.cobol.asg.metamodel.data.datadescription.DataDescriptionEntryContainer.DataDescriptionEntryContainerType;
import io.proleap.cobol.asg.metamodel.data.localstorage.LocalStorageSection;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class DataDescription01Test extends CobolTestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/asg/data/localstorage/DataDescription01.cbl");
		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("DataDescription01");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final DataDivision dataDivision = programUnit.getDataDivision();
		final LocalStorageSection localStorageSection = dataDivision.getLocalStorageSection();

		assertEquals("SOMELD", localStorageSection.getName());
		assertEquals(DataDescriptionEntryContainerType.LOCAL_STORAGE_SECTION, localStorageSection.getContainerType());

		assertEquals(3, localStorageSection.getDataDescriptionEntries().size());
		assertEquals(1, localStorageSection.getRootDataDescriptionEntries().size());

		{
			final DataDescriptionEntry dataDescriptionEntryItems = localStorageSection.getDataDescriptionEntry("ITEMS");
			assertNotNull(dataDescriptionEntryItems);
			assertEquals("ITEMS", dataDescriptionEntryItems.getName());
			assertEquals(DataDescriptionEntryType.GROUP, dataDescriptionEntryItems.getDataDescriptionEntryType());
			assertEquals(Integer.valueOf(1), dataDescriptionEntryItems.getLevelNumber());
			assertNull(dataDescriptionEntryItems.getParentDataDescriptionEntryGroup());

			{
				final DataDescriptionEntry dataDescriptionEntryItem1 = localStorageSection
						.getDataDescriptionEntry("ITEM1");
				assertNotNull(dataDescriptionEntryItem1);
				assertEquals("ITEM1", dataDescriptionEntryItem1.getName());
				assertEquals(DataDescriptionEntryType.GROUP, dataDescriptionEntryItem1.getDataDescriptionEntryType());
				assertEquals(Integer.valueOf(2), dataDescriptionEntryItem1.getLevelNumber());
				assertEquals(dataDescriptionEntryItems, dataDescriptionEntryItem1.getParentDataDescriptionEntryGroup());
			}

			{
				final DataDescriptionEntry dataDescriptionEntryItem2 = localStorageSection
						.getDataDescriptionEntry("ITEM2");
				assertNotNull(dataDescriptionEntryItem2);
				assertEquals("ITEM2", dataDescriptionEntryItem2.getName());
				assertEquals(DataDescriptionEntryType.GROUP, dataDescriptionEntryItem2.getDataDescriptionEntryType());
				assertEquals(Integer.valueOf(2), dataDescriptionEntryItem2.getLevelNumber());
				assertEquals(dataDescriptionEntryItems, dataDescriptionEntryItem2.getParentDataDescriptionEntryGroup());
			}
		}
	}
}
