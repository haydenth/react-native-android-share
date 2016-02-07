# react-native-android-share

This fires off the default android share tray:

<img src="http://i.imgur.com/avnu4ir.png" width="150">

### Installl

```
npm i react-native-android-share --save
```

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

* Register Module in your MainActivity.java

```java
import com.blueprintalpha.rnandroidshare.RNAndroidSharePackage;  // <--- import

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

* Now implement into your code

```
var React = require('react-native')
var {
  View,
  Text,
  TouchableHighlight,
  Image,
} = React
var AndroidShare = require('react-native-android-share');

var ShareButton = React.createClass({

  // this will open the share tray
  _showShareActionSheet(story) {
    var object = {subject: 'Story Title', text: 'Message Body'};
    AndroidShare.openChooserWithOptions(object, 'Share Story');
  },

  // render a simple button
  render() {
    return (
        <TouchableHighlight
         underlayColor='rgba(0,0,0,0)'
         resizeMode='cover'
         onPress={()=>this._showShareActionSheet(this.props.story)}>
            <Image source={require("../images/share.png")}
            width={45}
            height={45}
            style={{height:45, width:45}}/>
          </TouchableHighlight>);
    },
});

module.exports = ShareButton;

```

TODO
=====================
* right now, module basically returns an empty view. need to either make this a component OR just a file with classes in it.

CONTACT
====================
thayden@gmail.com with questions or pull requests
