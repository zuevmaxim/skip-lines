# skip-lines

## Gradle plugin
* Build gradleplugin module
* Add dependency to classpath:
```
buildscript {
    dependencies {
        classpath(files("PATH-TO-PROJECT/skip-lines/gradleplugin/build/libs/gradleplugin.jar"))
    }
}
```
* Apply plugin:
```
apply(plugin = "ru.gradleplugin.skiplines.skip")
```

## IDEA plugin
* Apply gradle plugin to a project
* Run `buildPlugin` task in ideaplugin module
* Add plugin at File > Settings > Plugins > Install Plugin from Disk...
* Choose PATH-TO-PROJECT/skip-lines/ideaplugin/build/distributions/ideaplugin-1.0-SNAPSHOT.zip 
* After IDE reload: Tools > Skip Lines in File
