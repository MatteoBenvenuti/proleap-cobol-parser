package io.proleap.cobol.preprocessor.copy.cobolword.variable;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.proleap.cobol.asg.params.CobolParserParams;
import io.proleap.cobol.asg.params.impl.CobolParserParamsImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.preprocessor.impl.CobolPreprocessorImpl;

public class CopyCblWrdTest {

	private static final String DIR = "src/test/resources/io/proleap/cobol/preprocessor/copy/cobolword/variable";

	@Test
	public void testCopyBookDirectories() throws Exception {
		final File copyBookDirectory = new File(DIR + "/copybooks");
		final List<File> copyBookDirectories = Arrays.asList(copyBookDirectory);

		final CobolParserParams params = new CobolParserParamsImpl();
		params.setCopyBookDirectories(copyBookDirectories);
		params.setFormat(CobolSourceFormatEnum.VARIABLE);

		final File inputFile = new File(DIR + "/CopyCblWord.cbl");
		final String preProcessedInput = new CobolPreprocessorImpl().process(inputFile, params);

		final File expectedFile = new File(DIR + "/CopyCblWord.cbl.preprocessed");
		final String expected = Files.readString(expectedFile.toPath(), StandardCharsets.UTF_8);

		System.out.println("Expected:");
		System.out.println(visualizeLineEndings(expected));

		System.out.println("Actual:");
		System.out.println(visualizeLineEndings(preProcessedInput));
		assertEquals(expected, preProcessedInput);
	}

	private String visualizeLineEndings(String input) {
		return input
				.replace("\r", "\\r")
				.replace("\n", "\\n\n"); // stampa newline visivamente dopo ogni riga
	}

	@Test
	public void testCopyBookFiles() throws Exception {
		final File copyBookFile = new File(DIR + "/copybooks/abc.cpy");
		final List<File> copyBookFiles = Arrays.asList(copyBookFile);

		final CobolParserParams params = new CobolParserParamsImpl();
		params.setCopyBookFiles(copyBookFiles);
		params.setFormat(CobolSourceFormatEnum.VARIABLE);

		final File inputFile = new File(DIR + "/CopyCblWord.cbl");
		final String preProcessedInput = new CobolPreprocessorImpl().process(inputFile, params);

		final File expectedFile = new File(DIR + "/CopyCblWord.cbl.preprocessed");
		final String expected = Files.readString(expectedFile.toPath(), StandardCharsets.UTF_8);
		assertEquals(expected, preProcessedInput);
	}
}