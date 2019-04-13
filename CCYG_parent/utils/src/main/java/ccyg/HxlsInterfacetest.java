package ccyg;

import java.util.List;

public class HxlsInterfacetest implements HxlsOptRowsInterface {

	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
		System.out.println(rowlist);
		return "";
	}

}
