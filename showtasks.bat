start runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo runcrud.bat error occurred
goto fail

:openbrowser
start chrome
timeout /T 10
goto opentab

:opentab
start "" "http://localhost:8080/crud/v1/task/getTasks"
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work finished.