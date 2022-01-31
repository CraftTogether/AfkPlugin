# Weg
An AFK plugin for 1.18 minecraft, provides an API to allow other plugins to listen for AFK events

# Downloads
To download the plugin go to [releases](https://github.com/CraftTogether/Weg/releases)

# Developers
Gradle:
```
repositories {
    maven {
        url = 'https://jitpack.io'
    }
    maven {
        name = 'papermc-repo'
        url = 'https://papermc.io/repo/repository/maven-public/'
    }
}

dependencies {
    compileOnly 'com.github.CraftTogether:weg:1.0-SNAPSHOT-1'
    compileOnly 'io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT'
}
```

Maven:
```
<repositories>
    <repository>
        <id>papermc-repo</id>
        <url>https://papermc.io/repo/repository/maven-public/</url>
    </repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.CraftTogether</groupId>
        <artifactId>weg</artifactId>
        <version>1.0-SNAPSHOT-1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

# Contributors
Xerition - Lead developer <BR>
PolarianDev - Developer
