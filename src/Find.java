import java.util.ArrayList;

public class Find {

	ArrayList<String> list = new ArrayList<>();

	void isObject(String str) {

		String word = "";

		for (int i = 0; i < str.length(); i++) {
			char o = str.charAt(i);
			word = "";
			if (o == ':' && str.charAt(i + 1) == '<') {
				while (str.charAt(i) != '>') {
					word += str.charAt(i);
					i++;
				}
			} else if (o == '<') {
				if (str.charAt(i + 1) != 'm' || str.charAt(i + 1) == 'r') {
					while (str.charAt(i) == '>') {
						i++;
					}
				} else if (str.charAt(i) == 'r') {
					int count = 0;
					while (count != 2) {
						if (str.charAt(i) == '>') {
							count++;
						}
						i++;
					}
				} else {
					while (str.charAt(i) != '>') {
						word += str.charAt(i);
						i++;
					}
				}
			} else if (o == '[' && str.charAt(i + 1) == '[') {
				while (str.charAt(i) != '|') {
					i++;
				}
				i++;
				while (str.charAt(i) != ']') {
					word += str.charAt(i);
				}
				i++;
			} else {
				while (str.charAt(i) != ' ') {
					word += str.charAt(i);
					i++;
				}
			}

			list.add(word);
		}
	}

	String replaceRules(String str) {

		this.isObject(str);
		String res = "";

		for (int i = 0; i < this.list.size(); i++) {
			switch (this.list.get(i)) {
			case ":<math>":
				res += "\\begin{equation}" + '\n';
				while (this.list.get(i) != "</math>") {
					i++;
					res += this.list.get(i) + ' ';
				}
				res += '\n' + "\\end{equation}" + '\n';
				break;
			case "<math>":
				res += "$";
				while (this.list.get(i) != "</math>") {
					i++;
					res += this.list.get(i) + ' ';
				}
				res += "$";
				break;
			}
		}

		return res;
	}

}
