# Set up Minecraft Hacks

## Install IntelliJ
[IntelliJ Idea Community Edition](https://www.jetbrains.com/idea/download/#section=windows)

## Clone MCP-Reborn repository
- If you are at the IntelliJ home screen, click `Get from VCS`
- If inside a project, click `VCS` in the toolbar at the top, and then `Get from Version Control`
- On macOS, a popup may appear asking you to install Apple developer tools, which you must do
- If there is red error text, click `Download & Install git` next to it
- In the URL field, paste [https://github.com/Hexeption/MCP-Reborn](https://github.com/Hexeption/MCP-Reborn)
- Click `Clone`

## Set up Minecraft sources
- Immediately after cloning, IntelliJ will download JDK 1.8 and start syncing the gradle project
  - Wait for the gradle project to sync
  - Can take 5 min
- If there is a progress bar in the bottom-right of the window, IntelliJ is indexing
  - must wait for indexing to finish before continuing
- Open the `Gradle` tab on the right side of the IntelliJ window
  - `Gradle` is written vertically
  - Alternatively, open `View` -> `Tool Windows` -> `Gradle` from the toolbar at the top
- Open `MCP-Reborn` -> `Tasks` -> `mcp`
- Right click `setup` and choose `Run` (first option)
  - If the `Run` option does not appear, IntelliJ may be indexing still, you need to wait for it to finish
- Wait for setup to finish
  - Can take 5 min
- In the gradle panel, above `setup`, right click `copyAssets` and choose `Run`
  - If the `Run` option does not appear, IntelliJ may be indexing still, you need to wait
  - `copyAssets` often fails the first time, you may need to run it multiple times until it succeeds

## Run the game
- In the gradle panel, next to `setup`, right click `runclient` and run it
  - The first time running the game, it needs to compile all the source code, which can take 5 min
- After compiling, the game window should appear
- If there is a gray background on the Minecraft homescreen instead of the panorama, there is a problem with the assets
  - Try running `copyAssets` again
- To run the game in the future, click the Play button at the top of the IntelliJ window
- Testing server: `<redacted, listed in classroom>`

## Set up hacks
- On the left side of IntelliJ, open the `Project` panel
  - `Project` written vertically
- Open `MCP-Reborn` -> `src` -> `main` -> `java`
  - The java code lives in this folder
- Right click `java` and create a new package named `hacks`
- Right click `hacks` package and create new java class named `Hacks`
  - Fill with source code from [Hacks.java](1-Hacks.java)
- Back in the Project panel, open the class `net.minecraft.client.entity.player.ClientPlayerEntity`
  - This class controls your player in the game
  - Useful starting point for writing hacks
  - Find the `sendChatMessage` method
    - Replace this method with the code from [sendChatMessage.java](2-sendChatMessage.java)
