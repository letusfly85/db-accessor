# dbaccessor


## Description

This is a module to maintenance com.jellyfish85's ERD.


## Running Option

java -Dsbt.log.noformat=true -Xms512M -Xmx512M  -Dhttp.proxyHost=$HTTP_PROXY_HOST -Dhttp.proxyPort=$HTTP_PROXY_PORT -Dapp.env.name=development -jar $SBT_HOME/sbt-launch.jar 


## Test Option

java -Dsbt.log.noformat=true -Xms256m -Xmx256m -XX:MaxPermSize=256m -Xss2M -XX:+CMSClassUnloadingEnabled -Dapp.env.name=development -Dhttp.proxyHost=$HTTP_PROXY_HOST -Dhttp.proxyPort=$HTTP_PROXY_PORT

## properties

app.properties
	HOST -> JDBC URL for Oracle 
	USER -> Oracle Schema Name
	PASS -> Oracle Schema Password

<pre><code>
URL=jdbc:oracle:thin:@IP:SERVICE_NAME
USER=SchemaName
PASS=SchemaPassword
</code></pre>

dev.properties
	Attributes are the same as app.properties.
	It is used for tests.
