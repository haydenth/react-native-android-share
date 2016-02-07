# react-native-android-share

### Add it to your android project

* In `android/setting.gradle`

```gradle
...
include ':RNAndroidShare', ':app'
project(':RNAndroidShare').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-share')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
  ...
  compile project(':RNAndroidShare')
}
```

* Register Module - RN <= 0.17 (in MainActivity.java)

```java
import com.blueprintalpha.androidshare.RNAndroidSharePackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new RNAndroidSharePackage()) // <------ add this line to your MainActivity class
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "AndroidRNSample", null);

    setContentView(mReactRootView);
  }

  ......

}
```
