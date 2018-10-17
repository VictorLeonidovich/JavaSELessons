package teaching;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter {
	//private Pattern pattern;
	private String pattern;
	public DirFilter(String regex){
		//pattern = Pattern.compile(regex);
		pattern = regex;
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.startsWith(pattern);

		//return pattern.matcher(name).matches();
	}
	
	

}
