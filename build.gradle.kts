plugins {
    id("com.utopia-rise.godot-kotlin-jvm") version "0.13.1-4.4.1"
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

godot {
    // ---------Setup-----------------

    // the script registration which you'll attach to nodes are generated into this directory
    registrationFileBaseDir.set(projectDir.resolve("scripts"))

    // Create .gdj files from all JVM scripts
    isRegistrationFileGenerationEnabled.set(true)

    // defines whether the script registration files should be generated hierarchically according to the classes package path or flattened into `registrationFileBaseDir`
    //isRegistrationFileHierarchyEnabled.set(true)

    // defines whether your scripts should be registered with their fqName or their simple name (can help with resolving script name conflicts)
    //isFqNameRegistrationEnabled.set(false)

    // ---------Android----------------

    // NOTE: Make sure you read: https://godot-kotl.in/en/stable/user-guide/exporting/#android as not all jvm libraries are compatible with android!
    // IMPORTANT: Android export should to be considered from the start of development!
    //isAndroidExportEnabled.set(ANDROID_ENABLED)
    //d8ToolPath.set(File("D8_TOOL_PATH"))
    //androidCompileSdkDir.set(File("ANDROID_COMPILE_SDK_DIR"))

    // --------IOS and Graal------------

    // NOTE: this is an advanced feature! Read: https://godot-kotl.in/en/stable/user-guide/advanced/graal-vm-native-image/
    // IMPORTANT: Graal Native Image needs to be considered from the start of development!
    //isGraalNativeImageExportEnabled.set(IS_GRAAL_VM_ENABLED)
    //graalVmDirectory.set(File("GRAAL_VM_DIR"))
    //windowsDeveloperVCVarsPath.set(File("WINDOWS_DEVELOPER_VS_VARS_PATH"))
    //isIOSExportEnabled.set(IS_IOS_ENABLED)

    // --------Library authors------------

    // library setup. See: https://godot-kotl.in/en/stable/develop-libraries/
    //classPrefix.set("MyCustomClassPrefix")
    //projectName.set("LibraryProjectName")
    //projectName.set("LibraryProjectName")
}

tasks.register<Exec>("runGodotGame") {
    // Avoid running the game before rebuilding the project.
    mustRunAfter("build")

    // This can be an arbitrary path.
    setWorkingDir(projectDir.absolutePath)

    commandLine(
        "/Applications/Godot.app/Contents/MacOS/Godot",
        // Attach to Godot editor (requires enabling Debug -> Keep Debug Server Open).
        "--remote-debug", "tcp://127.0.0.1:6007",
        // Start main scene of the project instead of the editor.
        "--path", projectDir.absolutePath,
    )
}