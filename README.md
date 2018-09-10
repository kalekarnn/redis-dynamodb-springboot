# redis-dynamodb-springboot

Why ?

Spring cache at its core, applies caching to methods, thus reducing the number of executions based on the information available in the cache. But in cases like getAll this may lead to return incorrect data if some new entry gets added between two consecutive getAll calls. In that case the second call will not contain the newly added entry. Again this whole call gets cached against the single key, which i believe defeat the purpose, as this cached data won't be useful during getById method call.


A. Annotations Used :

	1. @EnableCaching - Most IMP :)
	2. @Cacheable - triggers cache population
	3. @CacheEvict - triggers cache eviction
	4. @CachePut - updates the cache without interfering with the method execution
	5. @Caching - regroups multiple cache operations to be applied on a method
	6. @CacheConfig - shares some common cache-related settings at class-level

B. Classes :

	1. LettuceConnectionFactory
	2. RedisTemplate
	3. StringRedisSerializer

C. RedisTemplate Methods :

	1. keys(pattern)
	2. opsForValue()
	3. multiGet(keyList)
