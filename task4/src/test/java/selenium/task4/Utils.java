package selenium.task4;

import java.util.List;

public class Utils {

	public static boolean doAllTitlesContainTheKeywords (List<String> titles, String...keywords) {
		
		for (String k : keywords) {
			String kl = k.toLowerCase();
			for (String t: titles) {
				if (!t.toLowerCase().contains(kl))
					return false;
			}
		}
		return true;
	}
}
