package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
/**
 * @author Heena Hussain
 *
 */
public class EvictByTime
{
	public static void main(String[] args) throws InterruptedException
	{
		CacheLoader<String, String> loader = new CacheLoader<String, String>()
		{
			@Override public String load(String s) throws Exception
			{
				return s.toUpperCase();
			}
		};

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.SECONDS).build(loader);

		cache.getUnchecked("hello");
		System.out.println("Size: " + cache.size());

		System.out.println("GET: " + cache.getIfPresent("hello"));

		Thread.sleep(1000);

		System.out.println("GET: " + cache.getIfPresent("hello"));
	}
}
