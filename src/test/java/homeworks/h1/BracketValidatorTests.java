package homeworks.h1;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class BracketValidatorTests {
    BracketValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new BracketValidator();
    }

    @Test
    public void findMatchingClosingBracket() throws Exception {
        String content = "(()())";
        assertEquals(5, validator.sizeOfNextSubPiece(content));

        content = "(()()";
        assertEquals(4, validator.sizeOfNextSubPiece(content));

        content = "(())()";
        assertEquals(3, validator.sizeOfNextSubPiece(content));

        content = "()())()";
        assertEquals(1, validator.sizeOfNextSubPiece(content));

        content = "((()";
        assertEquals(3, validator.sizeOfNextSubPiece(content));
    }

    @Test
    public void noBracketsShouldBeValid() throws Exception {
        String codeWithNoBrackets = "some code here";
        assertTrue(validator.areBracketsValid(codeWithNoBrackets));
    }

    @Test
    public void noBracketsShouldBeMissing() throws Exception {
        String codeWithBrackets = "some code here()()";
        assertTrue(validator.areBracketsValid(codeWithBrackets));

        String codeWithUnevenAmountOfBrackets = "()(";
        assertFalse(validator.areBracketsValid(codeWithUnevenAmountOfBrackets));
    }

    @Test
    public void bracketsShouldAppearInCorrectOrder() throws Exception {
        String correctOrder = "((())())()";
        assertTrue(validator.areBracketsValid(correctOrder));

        String wrongOrder = ")()(";
        assertFalse(validator.areBracketsValid(wrongOrder));
        wrongOrder = "())";
        assertFalse(validator.areBracketsValid(wrongOrder));
    }

    @Test
    public void invalidFinderShouldReturnMinusOneIfValid() throws Exception {
        String correctOrder = "()";
        assertEquals(-1, validator.positionOfInvalidBracket(correctOrder));

        correctOrder = "()()()";
        assertEquals(-1, validator.positionOfInvalidBracket(correctOrder));

        correctOrder = "(())";
        assertEquals(-1, validator.positionOfInvalidBracket(correctOrder));

        correctOrder = "()(())()";
        assertEquals(-1, validator.positionOfInvalidBracket(correctOrder));
    }

    @Test
    public void invalidFinderShouldFindFirstInvalidClosingBracket() throws Exception {
        String invalidBrackets = "()))";
        assertEquals(2, validator.positionOfInvalidBracket(invalidBrackets));
    }

    @Test
    public void invalidFinderShouldFindFirstPairlessOpenBracket() throws Exception {
        String invalidBrackets = "()((";
        assertEquals(2, validator.positionOfInvalidBracket(invalidBrackets));
    }

    @Test
    public void invalidFinderShouldReturnLocationOfInvalidBracket() throws Exception {
        String invalidBrackets = ")";
        assertEquals(0, validator.positionOfInvalidBracket(invalidBrackets));

        invalidBrackets = "(";
        assertEquals(0, validator.positionOfInvalidBracket(invalidBrackets));

        invalidBrackets = "()(()";
        assertEquals(3, validator.positionOfInvalidBracket(invalidBrackets));
    }
}
