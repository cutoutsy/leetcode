import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<String, String> dict = new HashMap<>();

    public String encode(String longUrl){
        String shortUrl = "http://tinyurl.com/"+ longUrl.hashCode();
        dict.put(shortUrl, longUrl);
        return shortUrl;
    }
    public String decode(String shortUrl){
        return dict.get(shortUrl);
    }
}
