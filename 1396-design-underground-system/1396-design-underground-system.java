class UndergroundSystem {
	Map<Integer, int[]> checkin, route;
	Map<String, Integer> map;
	int stationCode;
	
    public UndergroundSystem() {
    	checkin = new HashMap<>(); // [userId, [fromId, fromTime]]
    	route = new HashMap<>();   // [routeKey, {sum of time, count of users]]; routeKey = (fromId << 15) + toId
    	map = new HashMap<>();     // [stationName, stationId]
    	stationCode = 1;           // unique station id
    }
    
    public void checkIn(int id, String stationName, int t) {
    	checkin.put(id, new int[] {getId(stationName), t});
    }
    
    public void checkOut(int id, String stationName, int t) {
        int[] info = checkin.get(id);
    	int key = (info[0] << 15) + getId(stationName);
        int[] v = route.computeIfAbsent(key, x -> new int[2]);
        v[0] += t - info[1];
        v[1]++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] v = route.get((getId(startStation) << 15) + getId(endStation));
        return (double)v[0] / v[1];
    }
    
    int getId(String name) {
    	int id = map.getOrDefault(name, -1);
    	if (id == -1) {
    		id = stationCode++;
    		map.put(name, id);
    	}
    	return id;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */