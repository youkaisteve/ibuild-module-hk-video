
# react-native-ibuild-module-hk-video

## Getting started

`$ npm install react-native-ibuild-module-hk-video --save`

### Mostly automatic installation

`$ react-native link react-native-ibuild-module-hk-video`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-ibuild-module-hk-video` and add `RNIbuildModuleHkVideo.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNIbuildModuleHkVideo.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNIbuildModuleHkVideoPackage;` to the imports at the top of the file
  - Add `new RNIbuildModuleHkVideoPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-ibuild-module-hk-video'
  	project(':react-native-ibuild-module-hk-video').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-ibuild-module-hk-video/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-ibuild-module-hk-video')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNIbuildModuleHkVideo.sln` in `node_modules/react-native-ibuild-module-hk-video/windows/RNIbuildModuleHkVideo.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNIbuildModuleHkVideo;` to the usings at the top of the file
  - Add `new RNIbuildModuleHkVideoPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNIbuildModuleHkVideo from 'react-native-ibuild-module-hk-video';

// TODO: What to do with the module?
RNIbuildModuleHkVideo;
```
  