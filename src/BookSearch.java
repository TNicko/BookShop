import java.io.FileNotFoundException;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;

public class BookSearch extends Panel2{

	BookSearch() throws FileNotFoundException {
		super();
		
	}
	
	static void newFilter() {
	    RowFilter<DefaultTableModel, Object> rf = null;

	    try {
	        rf = RowFilter.regexFilter(searchField.getText(), 0,1,2,3,4,5,6,7,8,9);
	        if (genreFilterBox.getSelectedItem().toString().equals("All Books")) {
	        	rf = RowFilter.regexFilter("", 0,1,2,3,4,5,6,7,8,9);
	        } else {
	        	rf = RowFilter.regexFilter(genreFilterBox.getSelectedItem().toString(), 0,1,2,3,4,5,6,7,8,9);
	        }

	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);

	}
	
	static void newSearch() {
	    RowFilter<DefaultTableModel, Object> rf = null;

	    try {
	        rf = RowFilter.regexFilter(searchField.getText(), 0,1,2,3,4,5,6,7,8,9);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);

	}
}

	