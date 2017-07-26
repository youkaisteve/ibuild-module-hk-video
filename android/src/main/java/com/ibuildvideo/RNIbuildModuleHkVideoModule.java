
package com.ibuildvideo;

import android.view.SurfaceView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.hik.mcrsdk.MCRSDK;
import com.hik.mcrsdk.rtsp.RtspClient;
import com.ibuildvideo.live.LiveControl;

public class RNIbuildModuleHkVideoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNIbuildModuleHkVideoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNIbuildModuleHkVideo";
  }
}