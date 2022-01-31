[![](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.gg/zSWjKVvfNy)
[![](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/CraftTogether) <BR>
[![](https://jitpack.io/v/CraftTogether/weg.svg)](https://jitpack.io/#CraftTogether/weg)
![](https://img.shields.io/badge/Maintained%3F-yes-green.svg) <BR>
[![](https://img.shields.io/github/downloads/CraftTogether/Weg/total.svg)](https://github.com/CraftTogether/Weg/releases)
![](https://img.shields.io/github/issues/CraftTogether/Weg.svg)
![](https://img.shields.io/github/issues-pr/CraftTogether/Weg.svg)
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
    compileOnly 'com.github.CraftTogether:weg:1.0-SNAPSHOT-4'
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
        <version>1.0-SNAPSHOT-4</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

# Contributors
Xerition - Lead developer <BR>
PolarianDev - Developer
