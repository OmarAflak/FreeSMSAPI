# FreeSMSAPI
Code Android qui permet d'utiliser l'API SMS de https://free.fr 

# Gradle

```
implementation 'me.aflak.libraries:freesmsapi:1.0'
```

# Utilisation

```java
FreeAPI api = new FreeAPI(user, pass);
api.sms("Hello World !");
```
