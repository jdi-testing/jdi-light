for /d /r . %%d in (target) do @if exist "%%d" rd /s/q "%%d"
del *.iml /s
pause