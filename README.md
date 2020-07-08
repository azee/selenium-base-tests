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

5. Pull images for intended browsers
E.g. for chrome 60.0
```
docker pull selenoid/vnc:chrome_60.0
```

6. Execute tests and build report

```
mvn clean test allure:report
```

Browser is configured using system properties "browser" and "browser.version"
By default: "firefox", "latest".

```
mvn -Dbrowser=chrome -Dbrowser.version=60.0 clean test allure:report
```

Selenoid endpoint is configured system property "webdriver.endpoint"
Default value is "http://localhost:4444/wd/hub"

```
mvn -Dwebdriver.endpoint=http://localhost:4444/wd/hub clean test allure:report
```

Base URL is configured using system property "base.url"

```
mvn -Dbase.url=https://google.com clean test allure:report
```

7. View report
Allure Report will be placed in  target/site/allure-maven-plugin
