package io.proleap.cobol.asg.procedure.inspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import io.proleap.cobol.CobolTestBase;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Literal;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call.CallType;
import io.proleap.cobol.asg.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.asg.metamodel.procedure.StatementTypeEnum;
import io.proleap.cobol.asg.metamodel.procedure.inspect.AllLeading;
import io.proleap.cobol.asg.metamodel.procedure.inspect.AllLeadingPhrase;
import io.proleap.cobol.asg.metamodel.procedure.inspect.BeforeAfterPhrase;
import io.proleap.cobol.asg.metamodel.procedure.inspect.Characters;
import io.proleap.cobol.asg.metamodel.procedure.inspect.For;
import io.proleap.cobol.asg.metamodel.procedure.inspect.InspectStatement;
import io.proleap.cobol.asg.metamodel.procedure.inspect.Tallying;
import io.proleap.cobol.asg.metamodel.valuestmt.LiteralValueStmt;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class InspectTallyingStatementTest extends CobolTestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/asg/procedure/inspect/InspectTallyingStatement.cbl");
		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("InspectTallyingStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();
		assertEquals(0, procedureDivision.getParagraphs().size());
		assertEquals(1, procedureDivision.getStatements().size());

		{
			final InspectStatement inspectStatement = (InspectStatement) procedureDivision.getStatements().get(0);
			assertNotNull(inspectStatement);
			assertEquals(StatementTypeEnum.INSPECT, inspectStatement.getStatementType());
			assertEquals(InspectStatement.InspectType.TALLYING, inspectStatement.getInspectType());

			final Tallying tallying = inspectStatement.getTallying();
			assertEquals(1, tallying.getFors().size());

			{
				final For for1 = tallying.getFors().get(0);

				assertNotNull(for1.getTallyCountDataItemCall());
				assertEquals(CallType.UNDEFINED_CALL, for1.getTallyCountDataItemCall().getCallType());
				assertEquals(1, for1.getCharacters().size());
				assertEquals(1, for1.getAllLeadingPhrase().size());

				{
					final Characters characters = for1.getCharacters().get(0);
					assertEquals(1, characters.getBeforeAfterPhrases().size());

					{
						final BeforeAfterPhrase beforeAfterPhrase = characters.getBeforeAfterPhrases().get(0);
						assertEquals(BeforeAfterPhrase.BeforeAfterType.AFTER, beforeAfterPhrase.getBeforeAfterType());
					}
				}

				{
					final AllLeadingPhrase allLeadingPhrase = for1.getAllLeadingPhrase().get(0);
					assertEquals(AllLeadingPhrase.AllLeadingsType.ALL, allLeadingPhrase.getAllLeadingsType());
					assertEquals(1, allLeadingPhrase.getAllLeadings().size());

					{
						final AllLeading allLeading = allLeadingPhrase.getAllLeadings().get(0);
						assertNotNull(allLeading.getPatternDataItemValueStmt());

						final LiteralValueStmt patternDataItemValueStmt = (LiteralValueStmt) allLeading
								.getPatternDataItemValueStmt();
						final Literal literal = patternDataItemValueStmt.getLiteral();
						assertEquals("B", literal.getValue());
						assertEquals(1, allLeading.getBeforeAfterPhrases().size());

						{
							final BeforeAfterPhrase beforeAfterPhrase = allLeading.getBeforeAfterPhrases().get(0);
							assertEquals(BeforeAfterPhrase.BeforeAfterType.BEFORE,
									beforeAfterPhrase.getBeforeAfterType());
						}
					}
				}
			}
		}
	}
}
