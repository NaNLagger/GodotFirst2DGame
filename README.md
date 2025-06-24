"Your first 2D game" from godot step-by-step tutorial. Kotlin/JVM.

<br>Some hint for future.
1. Use console commands inside IDEA(because project folder is open by default)
2. If Godot Editor JVM crash when project open, use:
<br>`launchctl setenv JAVA_HOME <path_to_jdk>` <br>example path to jdk: `/Users/stepanlyashenko/Library/Java/JavaVirtualMachines/jbr-17.0.12/Contents/Home`
3. For check JAVA_HOME: `echo $JAVA_HOME` in console inside IDEA
4. If Godot Editor JVM has warnings after project was open, use:
<br>`jlink --add-modules java.base,java.logging,jdk.jdwp.agent --output jvm/jre-arm64-macos`
5. If you have error like this: `ERROR: transport error 202: bind failed: Address already in use`, when debug, try to attach process on debug port(5005 by default) first and then run game
6. JAVA_HOME variable must be in here: `open -a TextEdit ~/.zshrc` 