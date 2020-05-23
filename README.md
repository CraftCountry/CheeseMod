# Cheese Mod
My first minecraft 1.7.10 forge mod led by MrCrayFish! This mod adds in various cheese items, armor, ores, and tools! It is also have information about other functions/methods you might want to apply as what MrCrayFish told. It is also made with custom configuration made by me to handle a lot of important variables.  it was purposely made for learning about minecraft modding in version of 1.7.10.
## Getting started for development
### Development Notes
This was built with latest version of minecraft forge 1.7.10 (1.7.10-10.13.4.1614-src.zip)
### Requirements
You will need to prepare these:
- Have Installed the latest JDK 8 & JRE 8 version
- Have Installed IDE for mod development (Intellij IDEA recommended)
### Setting up the workspace
- Setup a folder project anywhere you like! (Prefer to use non space path location).
- Clone/Download this repository to the folder that you have prepared!
- Open Intellij IDEA, choose "Open/Import project".
- Locate the build grade file `build.gradle` of your project location and open it. It will automatically do the job.
- Wait until the Intellij IDEA has done its job to load. Now go to gradle section and choose `ExperimentMC > Task > forgegradle` and double click "setupDecompWorkspace".
- If it's done, go to `Tasks > other >  genIntellijRuns` for setting up Intellij IDEA Workspace/Project.
- Voila! You are ready to go!
## Configutation, Testing and Building
## Project Configuration
Files that you need to seek out for any configuration
- build.gralde (version, group, archivesBaseName, minecraft, dependencies)
- src > main > resources > mcmod.info (ModID, Name, Version, MCVersion)
- src > main > resources > (FolderName matches ModID)
- src > main > java > (domain) > (yourusername) > (modid) > ModHelper.java (To setup your mod instance at ModInfo Class)
### Setting Up Program Argument
- Go to Run Dialog Option and choose "Edit Configuration"
- Go to `Application > Minecraft Client`
- Set up your local dev username at the program argument by typing `-username [USERNAME]`
### Test Your Local Mod
- Choose the run dialog option to `Minecraft Client`
- Hit the green play icon! it will load the minecraft
### Building Your Local Mod
- Hit the green hammer icon! it will build the mod to .jar file
- The finished mod located at `build > libs`
## Distribution
YOU ARE FREE TO DISTRIBUTE AS LONG AS YOU GIVE CREDIT TO ME AND MRCRAYFISH