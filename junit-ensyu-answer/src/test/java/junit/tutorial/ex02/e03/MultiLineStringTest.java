package junit.tutorial.ex02.e03;

import static junit.tutorial.ex02.e03.MultiLineStringMatcher.text;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class MultiLineStringTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("HelloとWorldを改行で連結")
	void testJoin1() {
		String word1 = "Hello";
		String word2 = "World";
		String expected = word1 + System.lineSeparator() + word2;
//		assertEquals(expected, MultiLineString.join(word1, word2));
		assertThat(MultiLineString.join(word1,word2), is(text(expected)));
	}

	
}

class MultiLineStringMatcher extends BaseMatcher<String> {

	public static Matcher<String> text(String text) {
		return new MultiLineStringMatcher(text, System.lineSeparator());
	}

	private final String expected;
	private Object actual;
	private final List<String> expectedLines = new ArrayList<>();
	private final List<String> actualLines = new ArrayList<>();
	private final Pattern pattern;
	
	// コンストラクタ
	public MultiLineStringMatcher(String expected, String ls) {
		this.expected = expected;
		if (ls.equals("\r")) {
			this.pattern = Pattern.compile(".+(\\r|$)");
		} else if (ls.equals("\n")) {
			this.pattern = Pattern.compile(".+(\\n|$)");
		} else {
			this.pattern = Pattern.compile(".+(\\r\\n|$)");
		}
		if (expected != null) {
			java.util.regex.Matcher m = pattern.matcher(expected);
			while (m.find()) {
				expectedLines.add(expected.substring(m.start(), m.end()));
			}
		}
	}
	
	@Override
	public boolean matches(Object actual) {
		this.actual = actual;
		if(expected == null) {
			return (actual == null);
		}
		if (!(actual instanceof String)) {
			return false;
		}
		if (expected.equals(actual)) {
			return true;
		}
		String actualString = (String) actual;
		java.util.regex.Matcher m = pattern.matcher(actualString);
		while(m.find()) {
			actualLines.add(actualString.substring(m.start(), m.end()));
		}
		return expectedLines.equals(actualLines);
	}
	
	@Override
	public void describeTo(Description desc) {
		if (expected == null || actual == null) {
			desc.appendValue(expected);
		} else {
			int lines = Math.min(expectedLines.size(), actualLines.size());
			for (int idx = 0; idx < lines; idx++) {
				String expectedLine = expectedLines.get(idx);
				String actualLine = actualLines.get(idx);
				if (!expectedLine.equals(actualLine)) {
					desc.appendValue(expectedLine);
					desc.appendText(", but actual is ");
					desc.appendValue(actualLine);
					desc.appendText(", line " + (idx+1) + "\n");
					desc.appendValue(expected);
					return;
				}
			}
		}
		desc.appendText("expeced text is " + expectedLines.size() + "lines, ");
		desc.appendText("but actual text is " + actualLines.size() + " lines\n");
		desc.appendValue(expected);
	}
	
	
}

