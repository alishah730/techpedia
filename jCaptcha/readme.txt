Please run the below commands to install the jCaptcha custom jars in your system


mvn install:install-file  -Dfile=jcaptcha-2.0.jar -DgroupId=com.octo.captcha -DartifactId=jcaptcha  -Dversion=2.0 -Dpackaging=jar 


mvn install:install-file  -Dfile=jcaptcha-integration-simple-servlet-2.0.jar -DgroupId=com.octo.captcha -DartifactId=jcaptcha-integration-simple-servlet  -Dversion=2.0 -Dpackaging=jar 

