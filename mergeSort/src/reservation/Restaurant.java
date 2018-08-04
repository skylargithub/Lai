package reservation;

public class Restaurant {

	private Map<String, Table> reservationTable;
	private List<Table> tables;
	
	public void reserve(Request req) {
		for(Table table: tables) {
			if(table.reserve(request)) {
				reservationTable.put(req.getName(), table);
			}
		}
	}
	
	public void cleanUp() {};
}
