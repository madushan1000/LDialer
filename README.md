## LDialer

This is the build script to build LineageOS Dialer app outside the LineageOS source tree using gradle.

To build,

* clone this repo and submodules (`git clone --recurse-submodules https://github.com/madushan1000/LDialer`)
* Comment out `logtags.srcDirs = ['java']` from `framework_ex/common/build.gradle`
* Run `./gradlew :Lineage_Dialer:assembleDebug` or `./gradlew :Lineage_Dialer:assembleRelease`

## Notes

* I'm not sure if this application will actually run without crashes, I don't want to replace my system dialer with this app. Need to fork LineageOS Dialer and change package names etc.. to make it installable as a separate app.
* Other AOSP based Dialer apps might compile with these build scripts too with minimal modifications.
* Bundled lib packages are needed to build the app. `lineage-android.jar` is the `android.jar` for api 28 with hidden apis bundled, it's extracted from a LineageOS build tree. `lineage-sdk.jar` is taken from `https://github.com/LineageOS/android_prebuilts_lineage-sdk`