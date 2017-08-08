package com.ibuildvideo;

import android.support.annotation.Nullable;
import android.view.SurfaceView;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.hik.mcrsdk.MCRSDK;
import com.hik.mcrsdk.rtsp.RtspClient;
import com.hikvision.vmsnetsdk.LineInfo;
import com.hikvision.vmsnetsdk.RealPlayURL;
import com.hikvision.vmsnetsdk.ServInfo;
import com.hikvision.vmsnetsdk.VMSNetSDK;
import com.ibuildvideo.live.ConstantLive;
import com.ibuildvideo.live.LiveCallBack;
import com.ibuildvideo.live.LiveControl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youkai on 2017/7/26.
 */
public class RNIbuildModuleHkVideoViewManager extends SimpleViewManager<SurfaceView> implements LiveCallBack {
    String url;
    String userName;
    String password;
    String macAddress;
    String cameraId;
    LineInfo lineInfo;
    ServInfo servInfo;
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
            userName = params.getString("userName");
        }
        if (params.hasKey("password")) {
            password = params.getString("password");
        }
        if (params.hasKey("cameraId")) {
            cameraId = params.getString("cameraId");
        }

        lineInfo = getLineInfo();

        if (lineInfo == null) {
            return;
        }

        login();

        RealPlayURL realPlayUrl = new RealPlayURL();
        VMSNetSDK.getInstance().getRealPlayURL(url, servInfo.sessionID, cameraId, ConstantLive.MAIN_STREAM, realPlayUrl);

        mLiveControl.setLiveParams(realPlayUrl.url1, userName, password);
        if (mLiveControl.LIVE_PLAY == mLiveControl.getLiveState()) {
            mLiveControl.stop();
        }

        if (mLiveControl.LIVE_INIT == mLiveControl.getLiveState()) {
            mLiveControl.startLive(view);
        }
    }

    private LineInfo getLineInfo() {
        ArrayList<LineInfo> infoList = new ArrayList<LineInfo>();
        if (VMSNetSDK.getInstance().getLineList(url, infoList)) {
            return infoList.get(0);
        }
        return null;
    }

    private void login() {
        VMSNetSDK.getInstance().login(url, userName, password, lineInfo.lineID, macAddress, servInfo);
    }

    @Override
    public void onMessageCallback(int message) {

    }
}
