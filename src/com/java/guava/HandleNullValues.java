package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Optional;
/**
 * @author Heena Hussain
 *
 */
public class HandleNullValues
{
	public static void main(String[] args)
	{
		CacheLoader<String, Optional<String>> loader = new CacheLoader<String, Optional<String>>()
		{
			@Override public Optional<String> load(String s) throws Exception
			{
				return Optional.ofNullable(getSuffix(s));
			}
		};

		LoadingCache<String, Optional<String>> cache = CacheBuilder.newBuilder().build(loader);

		cache.getUnchecked("heena.hussain");
		cache.getUnchecked("Nishant");

		System.out.println("Size: " + cache.size());

		System.out.println("first: " + cache.getIfPresent("heena.hussain").get());
		System.out.println("second: " + cache.getIfPresent("Nishant").orElse("not present"));

	}

	private static String getSuffix(String str)
	{
		int suffixIndex = str.lastIndexOf('.');

		return (suffixIndex != -1) ? str.substring(suffixIndex+1) : null;
	}
}
