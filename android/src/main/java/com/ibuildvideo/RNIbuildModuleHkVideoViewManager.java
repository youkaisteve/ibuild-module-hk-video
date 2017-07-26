package com.ibuildvideo;

import android.support.annotation.Nullable;
import android.view.SurfaceView;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.hik.mcrsdk.MCRSDK;
import com.hik.mcrsdk.rtsp.RtspClient;
import com.ibuildvideo.live.LiveControl;

/**
 * Created by youkai on 2017/7/26.
 */
public class RNIbuildModuleHkVideoViewManager extends SimpleViewManager<SurfaceView> {
    String url;
    String userName;
    String password;
    LiveControl mLiveControl;

    @Override
    public String getName() {
        return "RNIbuildModuleHkVideoView";
    }

    @Override
    protected SurfaceView createViewInstance(ThemedReactContext reactContext) {
        System.loadLibrary("SystemTransform");
        MCRSDK.init();
        RtspClient.initLib();
        MCRSDK.setPrint(1, null);
        mLiveControl = new LiveControl();
        SurfaceView surfaceView = new SurfaceView(reactContext);
        return surfaceView;
    }

    @ReactProp(name = "params")
    public void setParams(SurfaceView view, @Nullable ReadableMap params) {
        if (params.hasKey("url")) {
            url = params.getString("url");
        }
        if (params.hasKey("userName")) {
            url = params.getString("userName");
        }
        if (params.hasKey("password")) {
            url = params.getString("password");
        }

        mLiveControl.setLiveParams(url, userName, password);
        if (mLiveControl.LIVE_PLAY == mLiveControl.getLiveState()) {
            mLiveControl.stop();
        }

        if (mLiveControl.LIVE_INIT == mLiveControl.getLiveState()) {
            mLiveControl.startLive(view);
        }
    }
}
