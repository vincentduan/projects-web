package com.unisk.zc.core.support;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.builder.CacheRefResolver;
import org.apache.ibatis.builder.ResultMapResolver;
import org.apache.ibatis.builder.xml.XMLStatementBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.decorators.SoftCache;
import org.apache.ibatis.cache.decorators.WeakCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.FastResultSetHandler;
import org.apache.ibatis.executor.resultset.NestedResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.InterceptorChain;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;

public class CustomerConfiguration extends Configuration {

	protected Environment environment;

	protected boolean safeRowBoundsEnabled = false;
	protected boolean safeResultHandlerEnabled = true;
	protected boolean mapUnderscoreToCamelCase = false;
	protected boolean lazyLoadingEnabled = false;
	protected boolean aggressiveLazyLoading = true;
	protected boolean multipleResultSetsEnabled = true;
	protected boolean useGeneratedKeys = false;
	protected boolean useColumnLabel = true;
	protected boolean cacheEnabled = true;
	protected LocalCacheScope localCacheScope = LocalCacheScope.SESSION;
	protected JdbcType jdbcTypeForNull = JdbcType.OTHER;
	protected Set<String> lazyLoadTriggerMethods = new HashSet<String>(Arrays.asList(new String[] { "equals", "clone", "hashCode", "toString" }));
	protected Integer defaultStatementTimeout;
	protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;
	protected AutoMappingBehavior autoMappingBehavior = AutoMappingBehavior.PARTIAL;

	protected Properties variables = new Properties();
	protected ObjectFactory objectFactory = new DefaultObjectFactory();
	protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
	protected CustomerMapperRegistry mapperRegistry = new CustomerMapperRegistry(this);

	protected String databaseId;

	protected final InterceptorChain interceptorChain = new InterceptorChain();
	protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();
	protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
	protected final Map<String, MappedStatement> mappedStatements = new StrictMap<MappedStatement>("Mapped Statements collection");
	protected final Map<String, Cache> caches = new StrictMap<Cache>("Caches collection");
	protected final Map<String, ResultMap> resultMaps = new StrictMap<ResultMap>("Result Maps collection");
	protected final Map<String, ParameterMap> parameterMaps = new StrictMap<ParameterMap>("Parameter Maps collection");
	protected final Map<String, KeyGenerator> keyGenerators = new StrictMap<KeyGenerator>("Key Generators collection");

	protected final Set<String> loadedResources = new HashSet<String>();
	protected final Map<String, XNode> sqlFragments = new StrictMap<XNode>("XML fragments parsed from previous mappers");

	protected final Collection<XMLStatementBuilder> incompleteStatements = new LinkedList<XMLStatementBuilder>();
	protected final Collection<CacheRefResolver> incompleteCacheRefs = new LinkedList<CacheRefResolver>();
	protected final Collection<ResultMapResolver> incompleteResultMaps = new LinkedList<ResultMapResolver>();
	/*
	 * A map holds cache-ref relationship. The key is the namespace that references a cache bound to another namespace and the value is the namespace which the actual cache is bound to.
	 */
	protected final Map<String, String> cacheRefMap = new HashMap<String, String>();

	public CustomerConfiguration(Environment environment) {
		this();
		this.environment = environment;
	}

	public CustomerConfiguration() {
		typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class.getName());
		typeAliasRegistry.registerAlias("MANAGED", ManagedTransactionFactory.class.getName());
		typeAliasRegistry.registerAlias("JNDI", JndiDataSourceFactory.class.getName());
		typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class.getName());
		typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class.getName());

		typeAliasRegistry.registerAlias("PERPETUAL", PerpetualCache.class.getName());
		typeAliasRegistry.registerAlias("FIFO", FifoCache.class.getName());
		typeAliasRegistry.registerAlias("LRU", LruCache.class.getName());
		typeAliasRegistry.registerAlias("SOFT", SoftCache.class.getName());
		typeAliasRegistry.registerAlias("WEAK", WeakCache.class.getName());

		typeAliasRegistry.registerAlias("VENDOR", VendorDatabaseIdProvider.class.getName());
	}

	@Override
	public String getDatabaseId() {
		return databaseId;
	}

	@Override
	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}

	@Override
	public boolean isSafeResultHandlerEnabled() {
		return safeResultHandlerEnabled;
	}

	@Override
	public void setSafeResultHandlerEnabled(boolean safeResultHandlerEnabled) {
		this.safeResultHandlerEnabled = safeResultHandlerEnabled;
	}

	@Override
	public boolean isSafeRowBoundsEnabled() {
		return safeRowBoundsEnabled;
	}

	@Override
	public void setSafeRowBoundsEnabled(boolean safeRowBoundsEnabled) {
		this.safeRowBoundsEnabled = safeRowBoundsEnabled;
	}

	@Override
	public boolean isMapUnderscoreToCamelCase() {
		return mapUnderscoreToCamelCase;
	}

	@Override
	public void setMapUnderscoreToCamelCase(boolean mapUnderscoreToCamelCase) {
		this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
	}

	@Override
	public void addLoadedResource(String resource) {
		loadedResources.add(resource);
	}

	@Override
	public boolean isResourceLoaded(String resource) {
		return loadedResources.contains(resource);
	}

	@Override
	public Environment getEnvironment() {
		return environment;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public AutoMappingBehavior getAutoMappingBehavior() {
		return autoMappingBehavior;
	}

	@Override
	public void setAutoMappingBehavior(AutoMappingBehavior autoMappingBehavior) {
		this.autoMappingBehavior = autoMappingBehavior;
	}

	@Override
	public boolean isLazyLoadingEnabled() {
		return lazyLoadingEnabled;
	}

	@Override
	public void setLazyLoadingEnabled(boolean lazyLoadingEnabled) {
		if (lazyLoadingEnabled) {
			try {
				Resources.classForName("net.sf.cglib.proxy.Enhancer");
			} catch (Throwable e) {
				throw new IllegalStateException("Cannot enable lazy loading because CGLIB is not available. Add CGLIB to your classpath.", e);
			}
		}
		this.lazyLoadingEnabled = lazyLoadingEnabled;
	}

	@Override
	public boolean isAggressiveLazyLoading() {
		return aggressiveLazyLoading;
	}

	@Override
	public void setAggressiveLazyLoading(boolean aggressiveLazyLoading) {
		this.aggressiveLazyLoading = aggressiveLazyLoading;
	}

	@Override
	public boolean isMultipleResultSetsEnabled() {
		return multipleResultSetsEnabled;
	}

	@Override
	public void setMultipleResultSetsEnabled(boolean multipleResultSetsEnabled) {
		this.multipleResultSetsEnabled = multipleResultSetsEnabled;
	}

	@Override
	public Set<String> getLazyLoadTriggerMethods() {
		return lazyLoadTriggerMethods;
	}

	@Override
	public void setLazyLoadTriggerMethods(Set<String> lazyLoadTriggerMethods) {
		this.lazyLoadTriggerMethods = lazyLoadTriggerMethods;
	}

	@Override
	public boolean isUseGeneratedKeys() {
		return useGeneratedKeys;
	}

	@Override
	public void setUseGeneratedKeys(boolean useGeneratedKeys) {
		this.useGeneratedKeys = useGeneratedKeys;
	}

	@Override
	public ExecutorType getDefaultExecutorType() {
		return defaultExecutorType;
	}

	@Override
	public void setDefaultExecutorType(ExecutorType defaultExecutorType) {
		this.defaultExecutorType = defaultExecutorType;
	}

	@Override
	public boolean isCacheEnabled() {
		return cacheEnabled;
	}

	@Override
	public void setCacheEnabled(boolean cacheEnabled) {
		this.cacheEnabled = cacheEnabled;
	}

	@Override
	public Integer getDefaultStatementTimeout() {
		return defaultStatementTimeout;
	}

	@Override
	public void setDefaultStatementTimeout(Integer defaultStatementTimeout) {
		this.defaultStatementTimeout = defaultStatementTimeout;
	}

	@Override
	public boolean isUseColumnLabel() {
		return useColumnLabel;
	}

	@Override
	public void setUseColumnLabel(boolean useColumnLabel) {
		this.useColumnLabel = useColumnLabel;
	}

	@Override
	public LocalCacheScope getLocalCacheScope() {
		return localCacheScope;
	}

	@Override
	public void setLocalCacheScope(LocalCacheScope localCacheScope) {
		this.localCacheScope = localCacheScope;
	}

	@Override
	public JdbcType getJdbcTypeForNull() {
		return jdbcTypeForNull;
	}

	@Override
	public void setJdbcTypeForNull(JdbcType jdbcTypeForNull) {
		this.jdbcTypeForNull = jdbcTypeForNull;
	}

	@Override
	public Properties getVariables() {
		return variables;
	}

	@Override
	public void setVariables(Properties variables) {
		this.variables = variables;
	}

	@Override
	public TypeHandlerRegistry getTypeHandlerRegistry() {
		return typeHandlerRegistry;
	}

	@Override
	public TypeAliasRegistry getTypeAliasRegistry() {
		return typeAliasRegistry;
	}

	@Override
	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	@Override
	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	@Override
	public ObjectWrapperFactory getObjectWrapperFactory() {
		return objectWrapperFactory;
	}

	@Override
	public void setObjectWrapperFactory(ObjectWrapperFactory objectWrapperFactory) {
		this.objectWrapperFactory = objectWrapperFactory;
	}

	@Override
	public MetaObject newMetaObject(Object object) {
		return MetaObject.forObject(object, objectFactory, objectWrapperFactory);
	}

	@Override
	public ParameterHandler newParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
		parameterHandler = (ParameterHandler) interceptorChain.pluginAll(parameterHandler);
		return parameterHandler;
	}

	@Override
	public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, RowBounds rowBounds, ParameterHandler parameterHandler, ResultHandler resultHandler,
			BoundSql boundSql) {
		ResultSetHandler resultSetHandler = mappedStatement.hasNestedResultMaps() ? new NestedResultSetHandler(executor, mappedStatement, parameterHandler, resultHandler, boundSql,
				rowBounds) : new FastResultSetHandler(executor, mappedStatement, parameterHandler, resultHandler, boundSql, rowBounds);
		resultSetHandler = (ResultSetHandler) interceptorChain.pluginAll(resultSetHandler);
		return resultSetHandler;
	}

	@Override
	public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler,
			BoundSql boundSql) {
		StatementHandler statementHandler = new RoutingStatementHandler(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
		statementHandler = (StatementHandler) interceptorChain.pluginAll(statementHandler);
		return statementHandler;
	}

	@Override
	public Executor newExecutor(Transaction transaction) {
		return newExecutor(transaction, defaultExecutorType);
	}

	@Override
	public Executor newExecutor(Transaction transaction, ExecutorType executorType) {
		return newExecutor(transaction, defaultExecutorType, false);
	}

	@Override
	public Executor newExecutor(Transaction transaction, ExecutorType executorType, boolean autoCommit) {
		executorType = executorType == null ? defaultExecutorType : executorType;
		executorType = executorType == null ? ExecutorType.SIMPLE : executorType;
		Executor executor;
		if (ExecutorType.BATCH == executorType) {
			executor = new BatchExecutor(this, transaction);
		} else if (ExecutorType.REUSE == executorType) {
			executor = new ReuseExecutor(this, transaction);
		} else {
			executor = new SimpleExecutor(this, transaction);
		}
		if (cacheEnabled) {
			executor = new CachingExecutor(executor, autoCommit);
		}
		executor = (Executor) interceptorChain.pluginAll(executor);
		return executor;
	}

	@Override
	public void addKeyGenerator(String id, KeyGenerator keyGenerator) {
		keyGenerators.put(id, keyGenerator);
	}

	@Override
	public Collection<String> getKeyGeneratorNames() {
		return keyGenerators.keySet();
	}

	@Override
	public Collection<KeyGenerator> getKeyGenerators() {
		return keyGenerators.values();
	}

	@Override
	public KeyGenerator getKeyGenerator(String id) {
		return keyGenerators.get(id);
	}

	@Override
	public boolean hasKeyGenerator(String id) {
		return keyGenerators.containsKey(id);
	}

	@Override
	public void addCache(Cache cache) {
		caches.put(cache.getId(), cache);
	}

	@Override
	public Collection<String> getCacheNames() {
		return caches.keySet();
	}

	@Override
	public Collection<Cache> getCaches() {
		return caches.values();
	}

	@Override
	public Cache getCache(String id) {
		return caches.get(id);
	}

	@Override
	public boolean hasCache(String id) {
		return caches.containsKey(id);
	}

	@Override
	public void addResultMap(ResultMap rm) {
		resultMaps.put(rm.getId(), rm);
		checkLocallyForDiscriminatedNestedResultMaps(rm);
		checkGloballyForDiscriminatedNestedResultMaps(rm);
	}

	@Override
	public Collection<String> getResultMapNames() {
		return resultMaps.keySet();
	}

	@Override
	public Collection<ResultMap> getResultMaps() {
		return resultMaps.values();
	}

	@Override
	public ResultMap getResultMap(String id) {
		return resultMaps.get(id);
	}

	@Override
	public boolean hasResultMap(String id) {
		return resultMaps.containsKey(id);
	}

	@Override
	public void addParameterMap(ParameterMap pm) {
		parameterMaps.put(pm.getId(), pm);
	}

	@Override
	public Collection<String> getParameterMapNames() {
		return parameterMaps.keySet();
	}

	@Override
	public Collection<ParameterMap> getParameterMaps() {
		return parameterMaps.values();
	}

	@Override
	public ParameterMap getParameterMap(String id) {
		return parameterMaps.get(id);
	}

	@Override
	public boolean hasParameterMap(String id) {
		return parameterMaps.containsKey(id);
	}

	@Override
	public void addMappedStatement(MappedStatement ms) {
		mappedStatements.put(ms.getId(), ms);
	}

	@Override
	public Collection<String> getMappedStatementNames() {
		buildAllStatements();
		return mappedStatements.keySet();
	}

	@Override
	public Collection<MappedStatement> getMappedStatements() {
		buildAllStatements();
		return mappedStatements.values();
	}

	@Override
	public Collection<XMLStatementBuilder> getIncompleteStatements() {
		return incompleteStatements;
	}

	@Override
	public void addIncompleteStatement(XMLStatementBuilder incompleteStatement) {
		incompleteStatements.add(incompleteStatement);
	}

	@Override
	public Collection<CacheRefResolver> getIncompleteCacheRefs() {
		return incompleteCacheRefs;
	}

	@Override
	public void addIncompleteCacheRef(CacheRefResolver incompleteCacheRef) {
		incompleteCacheRefs.add(incompleteCacheRef);
	}

	@Override
	public Collection<ResultMapResolver> getIncompleteResultMaps() {
		return incompleteResultMaps;
	}

	@Override
	public void addIncompleteResultMap(ResultMapResolver resultMapResolver) {
		incompleteResultMaps.add(resultMapResolver);
	}

	@Override
	public MappedStatement getMappedStatement(String id) {
		return this.getMappedStatement(id, true);
	}

	@Override
	public MappedStatement getMappedStatement(String id, boolean validateIncompleteStatements) {
		if (validateIncompleteStatements) {
			buildAllStatements();
		}
		return mappedStatements.get(id);
	}

	@Override
	public Map<String, XNode> getSqlFragments() {
		return sqlFragments;
	}

	@Override
	public void addInterceptor(Interceptor interceptor) {
		interceptorChain.addInterceptor(interceptor);
	}

	@Override
	public void addMappers(String packageName, Class<?> superType) {
		ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
		resolverUtil.find(new ResolverUtil.IsA(superType), packageName);
		Set<Class<? extends Class<?>>> mapperSet = resolverUtil.getClasses();
		for (Class<?> mapperClass : mapperSet) {
			addMapper(mapperClass);
		}
	}

	@Override
	public void addMappers(String packageName) {
		addMappers(packageName, Object.class);
	}

	@Override
	public <T> void addMapper(Class<T> type) {
		mapperRegistry.addMapper(type);
	}

	@Override
	public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
		return mapperRegistry.getMapper(type, sqlSession);
	}

	@Override
	public boolean hasMapper(Class<?> type) {
		return mapperRegistry.hasMapper(type);
	}

	@Override
	public boolean hasStatement(String statementName) {
		return hasStatement(statementName, true);
	}

	@Override
	public boolean hasStatement(String statementName, boolean validateIncompleteStatements) {
		if (validateIncompleteStatements) {
			buildAllStatements();
		}
		return mappedStatements.containsKey(statementName);
	}

	@Override
	public void addCacheRef(String namespace, String referencedNamespace) {
		cacheRefMap.put(namespace, referencedNamespace);
	}

	/*
	 * Parses all the unprocessed statement nodes in the cache. It is recommended to call this method once all the mappers are added as it provides fail-fast statement validation.
	 */
	@Override
	protected void buildAllStatements() {
		if (!incompleteResultMaps.isEmpty()) {
			synchronized (incompleteResultMaps) {
				// This always throws a BuilderException.
				incompleteResultMaps.iterator().next().resolve();
			}
		}
		if (!incompleteCacheRefs.isEmpty()) {
			synchronized (incompleteCacheRefs) {
				// This always throws a BuilderException.
				incompleteCacheRefs.iterator().next().resolveCacheRef();
			}
		}
		if (!incompleteStatements.isEmpty()) {
			synchronized (incompleteStatements) {
				// This always throws a BuilderException.
				incompleteStatements.iterator().next().parseStatementNode();
			}
		}
	}

	/*
	 * Extracts namespace from fully qualified statement id.
	 * 
	 * @param statementId
	 * 
	 * @return namespace or null when id does not contain period.
	 */
	@Override
	protected String extractNamespace(String statementId) {
		int lastPeriod = statementId.lastIndexOf('.');
		return lastPeriod > 0 ? statementId.substring(0, lastPeriod) : null;
	}

	// Slow but a one time cost. A better solution is welcome.
	@Override
	protected void checkGloballyForDiscriminatedNestedResultMaps(ResultMap rm) {
		if (rm.hasNestedResultMaps()) {
			for (Map.Entry<String, ResultMap> entry : resultMaps.entrySet()) {
				Object value = entry.getValue();
				if (value instanceof ResultMap) {
					ResultMap entryResultMap = (ResultMap) value;
					if (!entryResultMap.hasNestedResultMaps() && entryResultMap.getDiscriminator() != null) {
						Collection<String> discriminatedResultMapNames = entryResultMap.getDiscriminator().getDiscriminatorMap().values();
						if (discriminatedResultMapNames.contains(rm.getId())) {
							entryResultMap.forceNestedResultMaps();
						}
					}
				}
			}
		}
	}

	// Slow but a one time cost. A better solution is welcome.
	@Override
	protected void checkLocallyForDiscriminatedNestedResultMaps(ResultMap rm) {
		if (!rm.hasNestedResultMaps() && rm.getDiscriminator() != null) {
			for (Map.Entry<String, String> entry : rm.getDiscriminator().getDiscriminatorMap().entrySet()) {
				String discriminatedResultMapName = entry.getValue();
				if (hasResultMap(discriminatedResultMapName)) {
					ResultMap discriminatedResultMap = resultMaps.get(discriminatedResultMapName);
					if (discriminatedResultMap.hasNestedResultMaps()) {
						rm.forceNestedResultMaps();
						break;
					}
				}
			}
		}
	}

	protected static class StrictMap<V> extends HashMap<String, V> {

		private static final long serialVersionUID = -4950446264854982944L;
		private final String name;

		public StrictMap(String name, int initialCapacity, float loadFactor) {
			super(initialCapacity, loadFactor);
			this.name = name;
		}

		public StrictMap(String name, int initialCapacity) {
			super(initialCapacity);
			this.name = name;
		}

		public StrictMap(String name) {
			super();
			this.name = name;
		}

		public StrictMap(String name, Map<String, ? extends V> m) {
			super(m);
			this.name = name;
		}

		@Override
		@SuppressWarnings("unchecked")
		public V put(String key, V value) {
			if (containsKey(key))
				throw new IllegalArgumentException(name + " already contains value for " + key);
			if (key.contains(".")) {
				final String shortKey = getShortName(key);
				if (super.get(shortKey) == null) {
					super.put(shortKey, value);
				} else {
					super.put(shortKey, (V) new Ambiguity(shortKey));
				}
			}
			return super.put(key, value);
		}

		@Override
		public V get(Object key) {
			V value = super.get(key);
			if (value == null) {
				throw new IllegalArgumentException(name + " does not contain value for " + key);
			}
			if (value instanceof Ambiguity) {
				throw new IllegalArgumentException(((Ambiguity) value).getSubject() + " is ambiguous in " + name
						+ " (try using the full name including the namespace, or rename one of the entries)");
			}
			return value;
		}

		private String getShortName(String key) {
			final String[] keyparts = key.split("\\.");
			final String shortKey = keyparts[keyparts.length - 1];
			return shortKey;
		}

		protected static class Ambiguity {
			private final String subject;

			public Ambiguity(String subject) {
				this.subject = subject;
			}

			public String getSubject() {
				return subject;
			}
		}
	}
}
