create-jdbc-connection-pool --restype javax.sql.ConnectionPoolDataSource --datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource --property user=postgres:password=123:DatabaseName=postgres:ServerName=127.0.0.1:port=5432 MyPostgres1-Pool

create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname org.postgresql.ds.PGSimpleDataSource --property user=postgres:password=123:DatabaseName=postgres:ServerName=127.0.0.1:port=5432 MyPostgres2-Pool

create-jdbc-resource --connectionpoolid MyPostgres1-Pool jdbc/devcolibri

