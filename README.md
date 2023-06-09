# Library App
## DETAILS
- Author: **Bikathi Martin**
- Language: Java
- Framework: Spring Framework
- Target Platform: N/A
- License: Apache2.0

## ABOUT
This is a simple Spring application that leverages MySQL and 4 RESTfull endpoints to create a barebones simple library app. Of most importance is the integration with Redis cache, which helps improve the speed of the app. This app was built as a quick demo to help learn the most important things about Redis and how to use annotations like:
```
@EnableCaching
@Cacheable
@CachePut
@CacheEvict
```
Configs for Redis are found in the `application.yml` file but can also be extended to be actual Java code set for the Redis `host` and `port` connection information.
