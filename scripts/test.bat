@echo off
set workspace=%~dp0..\
cd %workspace%

echo -------------------------------------------------------------------------------
echo [Fase iniciada] Clean y Test - Perfil(Develop)
echo -------------------------------------------------------------------------------

call mvn clean test -Denvironment.type=develop --settings settings.xml

echo ----------------
echo [Fase terminada] 
echo ----------------

pause