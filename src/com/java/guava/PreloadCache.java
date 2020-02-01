package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Heena Hussain
 *
 */
public class PreloadCache
{
	public static void main(String[] args)
	{
		CacheLoader<String, String> loader = new CacheLoader<String, String>()
		{
			@Override public String load(String s) throws Exception
			{
				return s.toUpperCase();
			}
		};

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(loader);

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", "FIRST");
		map.put("second", "SECOND");

		cache.putAll(map);
	}

}
