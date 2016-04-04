call setenv.bat
cd src\
dir /s /B *.java >..\files.dat
cd ..
rd  classes\ /s /q
mkdir classes\
javac -classpath lib\* -d classes @files.dat
del files.dat
mkdir classes\sg\edu\nus\iss\souvenirstore\ui\icons\
copy src\sg\edu\nus\iss\souvenirstore\ui\icons\*.png  classes\sg\edu\nus\iss\souvenirstore\ui\icons\
copy src\sg\edu\nus\iss\souvenirstore\ui\icons\*.jpg  classes\sg\edu\nus\iss\souvenirstore\ui\icons\
