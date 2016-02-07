'use strict';

var AndroidShareModule = require('NativeModules').RNAndroidShare;
var invariant = require('invariant');
var React = require('react-native');

var AndroidShare = {

   openChooserWithOptions(options: Object, title: string) {
    invariant(
      typeof options === 'object',
      'A valid option object is required'
    );
     invariant(
      typeof title === 'string',
      'Invalid Title: should be a string. Was: ' + title
    );
    console.log('calling android action');
    AndroidShareModule.openChooserWithOptions(options, title);
  },

  render() {
    return (<View></View>);
  }

};
module.exports = AndroidShare;
