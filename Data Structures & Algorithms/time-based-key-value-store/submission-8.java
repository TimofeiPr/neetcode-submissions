class TimeMap {
    public HashMap<String, ArrayList<String>> map; 

    public TimeMap() {
        this.map = new HashMap<String, ArrayList<String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.getOrDefault(key, null) == null) {
            map.put(key, new ArrayList<String>());
        }

        int size = map.get(key).size();
        if (size > 0) {
            for (int i = size; i < timestamp; i++) {
                map.get(key).add(map.get(key).getLast());
            }
        } else {
            for (int i = size; i < timestamp; i++) {
                map.get(key).add("");
            }
        }
        map.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key) == null) {
            return "";
        }
        if (timestamp >= map.get(key).size()) {
            return map.get(key).getLast();
        } else {
            return map.get(key).get(timestamp);
        }
    }
}
