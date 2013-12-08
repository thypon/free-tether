# Free Tether

Free Tether is an android 4.1+ app that makes possible using tethering whit carrier plan that doesn’t include it. Needs Root.

Prerequisites
-------------
* sbt 0.13.0 or above
* Android SDK
  - Both SDK Level 16 and the most recent version should be installed.

Build
-----
You can build using sbt:

    $ sbt android:package

This will compile the project and generate an APK.

For more command, refer to [Android SDK plugin for sbt](https://github.com/pfn/android-sdk-plugin).


Using an IDE
------------
You can use sbt to generate project files for Eclipse or IDEA:

    $ sbt eclipse
    $ sbt gen-idea


Troubleshooting
---------------

### Build error `Android SDK build-tools not available`
[The most likely cause of this error is that your SDK build-tools are old.](https://github.com/pfn/android-sdk-plugin/issues/13) Update the Android SDK and retry.

Further Reading
---------------
- [Scaloid](https://github.com/pocorall/scaloid)
- [Scaloid APIdemos](https://github.com/pocorall/scaloid-apidemos)
- [Android SDK plugin for sbt](https://github.com/pfn/android-sdk-plugin)

