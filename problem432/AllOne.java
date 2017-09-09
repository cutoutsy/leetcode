import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class AllOne {
    /** Initialize your data structure here. */
    HashMap<String, Integer> keyValue;
    TreeMap<Integer, HashSet<String>> reverse;
    public AllOne() {
        this.keyValue = new HashMap<>();
        this.reverse = new TreeMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (this.keyValue.containsKey(key)) {
            int value = this.keyValue.get(key);
            this.reverse.get(value).remove(key);
            if (this.reverse.get(value).size() == 0){
                this.reverse.remove(value);
            }
            if (!this.reverse.containsKey(value + 1)) {
                this.reverse.put(value + 1, new HashSet<>());
            }
            this.keyValue.put(key, value + 1);
            this.reverse.get(value + 1).add(key);
        } else {
            this.keyValue.put(key, 1);
            if (!this.reverse.containsKey(1)) {
                this.reverse.put(1, new HashSet<>());
            }
            this.reverse.get(1).add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (this.keyValue.containsKey(key)) {
            int value = this.keyValue.get(key);
            this.reverse.get(value).remove(key);
            if (this.reverse.get(value).size() == 0) {
                this.reverse.remove(value);
            }
            if (value == 1) {
                this.keyValue.remove(key);
            } else {
                if (!this.reverse.containsKey(value - 1)) {
                    this.reverse.put(value - 1, new HashSet<>());
                }
                this.reverse.get(value - 1).add(key);
                this.keyValue.put(key, value - 1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (this.keyValue.size() == 0) return "";
        return this.reverse.get(this.reverse.lastKey()).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (this.keyValue.size() == 0) return "";
        return this.reverse.get(this.reverse.firstKey()).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
