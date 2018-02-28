# FreeSMSAPI [ ![Download](https://api.bintray.com/packages/omaflak/maven/freesmsapi/images/download.svg) ](https://bintray.com/omaflak/maven/freesmsapi/_latestVersion)
Code Android qui permet d'utiliser l'API SMS de https://free.fr 

# Gradle

```
implementation 'me.aflak.libraries:freesmsapi:1.1'
```

# Utilisation

```java
FreeAPI api = new FreeAPI(user, pass);
api.sms("Hello World !");
```
