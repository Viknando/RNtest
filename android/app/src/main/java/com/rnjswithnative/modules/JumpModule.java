package com.rnjswithnative.modules;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by 00326434 on 2018/3/2.
 */

public class JumpModule extends ReactContextBaseJavaModule {
    public JumpModule(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Native_Module";
    }

    @ReactMethod
    public void startActivityFromJS(String name, String params){
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
                Class toActivity = Class.forName(name);
                Intent intent = new Intent(currentActivity,toActivity);
                intent.putExtra("msg", params);
                currentActivity.startActivity(intent);
            }
        }catch(Exception e){
            throw new JSApplicationIllegalArgumentException(
                    "不能打开Activity : "+e.getMessage());
        }
    }

    @ReactMethod
    public void sendMsgFromJSandCallBack(String msg, Callback callback){
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
                Toast.makeText(currentActivity,msg,Toast.LENGTH_SHORT).show();
                callback.invoke("this msg is from Native!");
            }
        }catch(Exception e){
            throw new JSApplicationIllegalArgumentException(
                    "不能打开Activity : "+e.getMessage());
        }
    }
    @ReactMethod
    public void sendMsgFromJSandPromise(String msg, Promise promise){
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
                Toast.makeText(currentActivity,msg,Toast.LENGTH_SHORT).show();
                promise.resolve("this msg is from Native!");
            }
        }catch(Exception e){
            promise.reject(e);
        }
    }
}
