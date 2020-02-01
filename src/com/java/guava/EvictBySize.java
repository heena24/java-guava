package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
/**
 * @author Heena Hussain
 *
 */
public class EvictBySize
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

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("fourth");

		System.out.println("Size:" + cache.size());
		System.out.println("Get:" + cache.getIfPresent("first"));
		System.out.println("Get:" + cache.getIfPresent("fourth"));
	}
}
