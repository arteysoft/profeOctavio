set varPath=%CD%
mv target\ROOT \opt\apache-tomcat-9.0.70\webapps\
cd \opt\apache-tomcat-9.0.70\bin\
java -cp tomcat-juli.jar;bootstrap.jar org.apache.catalina.startup.Bootstrap
cd %varPath%
