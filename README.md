curl -Lo cm https://github.com/aerokube/cm/releases/download/1.2.4/cm_darwin_amd64

chmod +x cm

sudo mv cm /usr/local/bin

cm selenoid start --vnc

cm selenoid-ui start



MAC
brew install allure

Linux
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure-commandline