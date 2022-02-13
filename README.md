[![](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.gg/zSWjKVvfNy)
[![](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/CraftTogether) <BR>
![](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
[![](https://img.shields.io/github/v/release/CraftTogether/Weg?color=brightgreen&label=Plugin%20Version)](https://github.com/CraftTogether/Weg/releases)
[![](https://img.shields.io/github/v/tag/CraftTogether/Weg?color=brightgreen&label=API%20version)](https://repo.polarian.dev/repo/xyz/crafttogether/weg) <BR>
[![](https://img.shields.io/github/downloads/CraftTogether/Weg/total.svg)](https://github.com/CraftTogether/Weg/releases)
![](https://img.shields.io/github/issues/CraftTogether/Weg.svg)
![](https://img.shields.io/github/issues-pr/CraftTogether/Weg.svg)
# Weg
An AFK plugin for 1.18 minecraft, provides an API to allow other plugins to listen for AFK events

# Downloads
To download the plugin go to [releases](https://github.com/CraftTogether/Weg/releases)

# Developers
Replace `VERSION` with the latest version (see badges at the top of the README)

Gradle:
```gradle
repositories {
    maven {
        url = 'https://repo.polarian.dev/repo'
    }
    maven {
        name = 'papermc-repo'
        url = 'https://papermc.io/repo/repository/maven-public/'
    }
}
```

```gradle
dependencies {
    compileOnly 'xyz.crafttogether:weg:VERSION'
    compileOnly 'io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT'
}
```

Maven:
```xml
<repository>
    <repository>
        <id>papermc-repo</id>
        <url>https://papermc.io/repo/repository/maven-public/</url>
    </repository>
    <repository>
        <id>polarian-repo</id>
        <url>https://repo.polarian.dev/repo</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>xyz.crafttogether</groupId>
        <artifactId>weg</artifactId>
        <version>VERSION</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

# Contributors
Xerition - Lead developer <BR>
PolarianDev - Developer
