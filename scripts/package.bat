@echo off
set workspace=%~dp0..\
cd %workspace%

::call %workspace%/scripts/test.bat
@echo | call %workspace%/scripts/test.bat

echo -------------------------------------------------------------------------------
echo [Fase iniciada] Package - Perfil(Pre-produccion) - con cobertura (sonar)
echo -------------------------------------------------------------------------------

call mvn org.jacoco:jacoco-maven-plugin:prepare-agent package -Denvironment.type=preproduction --settings settings.xml
call mvn sonar:sonar -Dsonar.organization=joaquin-z-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=1dbbc889b09d3685b8a78e42f930ccfa3a613645 --settings settings.xml

echo ----------------
echo [Fase terminada] 
echo ----------------

pause
