package dataprocessing.differentprocessing;

import dataprocessing.differentprocessing.interfaces.Filterable;

public class FilterFactory {
	private Filterable currentFilter;

	public Filterable getFilter(String filterName) {
		switch (filterName.toLowerCase()) {
		case "max":
			// currentFilter = new Simple
			System.out.println("max filter not supported now.");
			break;
		case "min":
			// currentFilter = new Simple
			System.out.println("min filter not supported now.");
			break;
		case "distinct":
			// currentFilter = new Simple
			System.out.println("distinct filter not supported now.");
			break;
		default:
			System.out.println("Entered word is mistaked. Try again.");
			//NewStart.main(new String[1]);
			break;
		}
		return currentFilter;
	}

}
