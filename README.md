1、开工说明
    first commit is a origin init project//第一个提交点是最原始初始化项目的点
    目标:
        how rn contact with native//rn是如何跟原生交互的
            (1)rn页面->原生页面->rn页面(rn作为起始页面)
            (2)原生页面->rn页面(原生作为起始页面)
            (3)有哪几种通信方法
2、结构说明(初探可能理解有偏差)
    程序的入口:AppRegistry.registerComponent('RNjsWithNative', () => App);
    不同版本里的index文件有差别(注意在0.49版本之前是index.android.js文件)
    __tests__里面的js文件被我删了，暂没发现问题