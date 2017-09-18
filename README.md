1. Install Docker CE

https://docs.docker.com/engine/installation/

2. Install CM tool - for easy selenoid start 

MAC/LINUX:

For MAC:

```
curl -Lo cm https://github.com/aerokube/cm/releases/download/1.2.4/cm_darwin_amd64
```

For Linux:
```
curl -Lo cm https://github.com/aerokube/cm/releases/download/1.2.4/cm_linux_amd64
```

```
chmod +x cm
sudo mv cm /usr/local/bin
```

3. Start selemoid and selenium UI

```
cm selenoid start --vnc
cm selenoid-ui start
```

4. Goto http://localhost:8080 to see available browsers 

Windows installation:
https://github.com/aerokube/cm/releases/download/1.2.4/cm_windows_386.exe
https://github.com/aerokube/cm/releases/download/1.2.4/cm_windows_amd64.exe

Rest OS: 
https://github.com/aerokube/cm/releases

5. Execute tests and build report
```
mvn clean test allure:report
```

Allure Report will be placed in  target/site/allure-maven-plugin
