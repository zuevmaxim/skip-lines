# skip-lines

## Gradle plugin
* Build gradleplugin module: `gradle :gradleplugin:build`
  * Or use one that already built at skip-lines/gradleplugin/build/libs/gradleplugin.jar
* Add dependency to classpath of YOUR PROJECT:
```
buildscript {
    dependencies {
        classpath(files("PATH-TO-PROJECT/skip-lines/gradleplugin/build/libs/gradleplugin.jar"))
    }
}
```
* Apply plugin to YOUR PROJECT:
```
apply(plugin = "ru.gradleplugin.skiplines.skip")
```

## IDEA plugin
* Apply gradle plugin to YOUR PROJECT
* Run `buildPlugin` task in ideaplugin module: `gradle :ideaplugin:buildPlugin`
  * Or use one already built at skip-lines/ideaplugin/build/distributions/ideaplugin-1.0-SNAPSHOT.zip
* Add plugin at File > Settings > Plugins > Install Plugin from Disk...
* Choose PATH-TO-PROJECT/skip-lines/ideaplugin/build/distributions/ideaplugin-1.0-SNAPSHOT.zip 
* After IDE reload: Tools > Skip Lines in File
