package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
/**
 * @author Heena Hussain
 *
 */
public class CacheRefresh
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

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES).build(loader);

	}
}
