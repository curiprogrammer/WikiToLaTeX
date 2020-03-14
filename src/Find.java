
// based on hiropons answer: https://stackoverflow.com/questions/60676694/write-my-own-find-and-replace-for-wikipedia-in-java/60679480#60679480

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {

	String replaceRules(String str) {

		String regex1 = "(<math>)(.*?)(</math>)";
		Pattern p1 = Pattern.compile(regex1);
		String regex2 = "(:<math>)(.*?)(</math>)";
		Pattern p2 = Pattern.compile(regex2);

		String regex3 = "[[.*|";
		Pattern p3 = Pattern.compile(regex3);

		String replaced = str.replaceAll("<!--.*-->", "");
		replaced = str.replaceAll("<ref.*</ref>", "");
		replaced = str.replaceAll("\\{\\{.*\\}\\}", "");

		Matcher m2 = p2.matcher(replaced);
		replaced = m2.replaceAll("\\\\\\begin\\{equation}\n$2\n\\\\\\end\\{equation\\}\n");

		Matcher m1 = p1.matcher(replaced);
		replaced = m1.replaceAll("\\$$2\\$");

		Matcher m3 = p3.matcher(replaced);
		replaced = m3.replaceAll("");

		replaced = replaced.replaceAll("]]", "");
		replaced = replaced.replaceAll("[[", "");

		return replaced;

	}
}