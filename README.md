# HIBERNATE : Second level cache with EHCache
Example on how to connfigure EHCache as second level cache

**To activate second level cache**

    set hibernate.cache.use_query_cache to true
    set a second level cache provider for example hibernate.cache.region.factory_class org.hibernate.cache.ehcache.EhCacheRegionFactory
    see persistence.xml
    for ehcache add the ehcache.xml configuration file to the classpath 
   
**To activate query cache**

    set hibernate.cache.use_query_cache to true in the persistence.xml
    

**Remarks, ideas or tips are welcome @ koen at corstjens.eu**
