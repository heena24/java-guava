package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;
/**
 * @author Heena Hussain
 *
 */
public class EvictByWeight
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

		Weigher<String, String> weighByLength = new Weigher<String, String>()
		{
			@Override public int weigh(String s, String s2)
			{
				return s2.length();
			}
		};

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumWeight(16).weigher(weighByLength).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("fourth");
		cache.getUnchecked("last");

		System.out.println("Size: " + cache.size());
		System.out.println("last " + cache.getIfPresent("last"));
		System.out.println("first " + cache.getIfPresent("first"));
		System.out.println("second " + cache.getIfPresent("second"));
	}
}
