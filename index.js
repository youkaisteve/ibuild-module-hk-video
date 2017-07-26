import React, {
    Component,
} from 'react';

import {
    View,
    NativeModules,
    Platform,
    DeviceEventEmitter,
    requireNativeComponent
} from 'react-native';

var iface = {
    name: 'MapView',
    propTypes: {
        ...View.propTypes,
        style: View.propTypes.style,
        params: React.PropTypes.shape({
            //地图坐标维度：
            url: React.PropTypes.string,
            //地图坐标经度：
            password: React.PropTypes.string,
            //缩放级别
            userName: React.PropTypes.string
        })
    }
};

const RCTVideoView = requireNativeComponent('RNIbuildModuleHkVideoView', iface, {
    nativeOnly: {onChange: true}
});

export class IbuildVideoView extends Component {
    static propTypes = {
        params: React.PropTypes.object
    };

    get viewProps() {
        return {
            style: {flex:1},
            params: this.props.params
        };
    }
    render() {
        return (
            <RCTVideoView {...this.viewProps}></RCTVideoView>
        );
    }
}