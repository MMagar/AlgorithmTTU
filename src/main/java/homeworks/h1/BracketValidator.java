package homeworks.h1;

public class BracketValidator {
    char openingBracket = '(';
    char closingBracket = ')';

    boolean areBracketsValid(String content) {
        int openBrackets = 0;
        for (char c : content.toCharArray()) {
            if (c == openingBracket)
                openBrackets++;
            else if (c == closingBracket)
                openBrackets--;
            if (openBrackets < 0)
                return false;
        }
        return openBrackets == 0;
    }

    int positionOfInvalidBracket(String content) {
        return positionOfInvalidBracketInSubPiece(0, content);
    }

    int positionOfInvalidBracketInSubPiece(int startIndex, String content) {
        if (content.isEmpty())
            return -1;
        int nextPieceSize = sizeOfNextSubPiece(content);
        if (nextPieceSize == -1)
            return startIndex;
        int resultOfFirstSubContent = positionOfInvalidBracketInSubPiece(startIndex + 1, content.substring(1, nextPieceSize));
        if (resultOfFirstSubContent != -1)
            return resultOfFirstSubContent;
        return positionOfInvalidBracketInSubPiece(startIndex + nextPieceSize + 1, content.substring(nextPieceSize + 1));
    }

    int sizeOfNextSubPiece(String content) {
        if (content.charAt(0) != openingBracket)
            return -1;
        int openBrackets = 0;
        char c;
        char[] chars = content.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            c = chars[i];
            if (c == openingBracket)
                openBrackets++;
            if (c == closingBracket) {
                openBrackets--;
                if (openBrackets == -1)
                    return i;
            }
        }
        return content.lastIndexOf(closingBracket);
    }
}
