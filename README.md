### Given
Max number is smaller than 2000000000, 
Lines are 100000000.

### Execute
After complie java file or rebuild project, 
execute class file with param :

```.sh
# java -Xmx${MB}m ${MAIN_CLASS_NAME}
java -Xmx512m App
```

or fix :
```.sh
# path for IntelliJ, mac os
vi /Applications/IntelliJ\ IDEA\ CE.app/Contents/bin/idea.vmoptions
```

### Check 
check lines of output file

```.sh
$ wc -l
100000000
```
