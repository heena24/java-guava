package com.java.guava;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Heena Hussain
 *
 */
public class OnRemovalNotification
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

		RemovalListener<String, String> listener = new RemovalListener<String, String>()
		{
			@Override public void onRemoval(RemovalNotification<String, String> removalNotification)
			{
				if(removalNotification.wasEvicted())
				{
					System.out.println("Cause: " + removalNotification.getCause().name());
				}
			}
		};

		LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).removalListener(listener).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("last");
	}
}
