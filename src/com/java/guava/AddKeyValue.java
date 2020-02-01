package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
/**
 * @author Heena Hussain
 *
 */
public class AddKeyValue
{
	public static void main(String[] args) throws ExecutionException
	{
		CacheLoader<String, String> loader = new CacheLoader<String, String>()
		{
			@Override public String load(String s) throws Exception
			{
				return s.toUpperCase();
			}
		};

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(loader);
		System.out.println("Size: " + cache.size());
		System.out.println("Add: " + cache.getUnchecked("hello"));
		System.out.println("Size: " + cache.size());

		if(cache.get("bye") != null)
		{
			cache.put("bye", "bye".toUpperCase());
		}


		System.out.println("Size: " + cache.size());
		System.out.println("Add: " + cache.get("bye"));

	}
}
