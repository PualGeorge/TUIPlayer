# TUIPlayer Android 示例工程快速跑通

## 目录结构

```
Android
├─ app          // app模块，主要提供TUIPlayer的拉流测试页面
└─ tuiplayer    // TUIPlayer组件的拉流逻辑封装
```

## 环境准备
- 最低兼容 Android 4.1（SDK API Level 16），建议使用 Android 5.0 （SDK API Level 21）及以上版本
- Android Studio 3.5及以上版本
- App 要求 Android 4.1及以上设备

## 运行示例

### 前提条件
您已 [注册腾讯云](https://cloud.tencent.com/document/product/378/17985) 账号，并完成 [实名认证](https://cloud.tencent.com/document/product/378/3629)。

### 第一步：创建TRTC的应用
1. 一键进入腾讯云实时音视频控制台的[应用管理](https://console.cloud.tencent.com/trtc/app)界面，选择创建应用，输入应用名称，例如 `TUIKitDemo` ，单击 **创建**；
2. 点击对应应用条目后**应用信息**，具体位置如下下图所示：
    <img src="https://qcloudimg.tencent-cloud.cn/raw/62f58d310dde3de2d765e9a460b8676a.png" width="900">
3. 进入应用信息后，按下图操作，记录SDKAppID和密钥：
    <img src="https://qcloudimg.tencent-cloud.cn/raw/bea06852e22a33c77cb41d287cac25db.png" width="900">
4. 进入腾讯云直播[LICENSE管理](https://console.cloud.tencent.com/live/license)节面，创建应用并绑定LICENSE
![](https://qcloudimg.tencent-cloud.cn/raw/886dbc5cf9cea301a69a7c06c80390d4.png)
创建成功后请记录 ` License Key `和 `License URL`，便于在运行时使用。
![](https://qcloudimg.tencent-cloud.cn/raw/5bca99c4b00f23eaa763310dc475ec1e.png)
>? **Package Name** 为 Android 的包名

### 第二步：下载源码，配置工程
1. 克隆或者直接下载此仓库源码，使用 Android Studio（3.5及以上的版本）打开源码工程`TUIPlayer/Android`。
2. 找到并打开`Android/app/src/main/java/com/tencent/qcloud/tuikit/tuiplayer/demo/debug/GenerateTestUserSig.java`文件。
3. 设置文件中的相关参数：
  - `SDKAPPID`：默认为 PLACEHOLDER ，请设置为实际的 SDKAppID；
  - `SECRETKEY`：默认为空字符串，请设置为实际的密钥信息；
  - `LICENSEURL`：默认为 PLACEHOLDER ，请设置为实际的License Url信息；
  - `LICENSEURLKEY`：默认为 PLACEHOLDER ，请设置为实际的License Key信息；
  - `PUSH_DOMAIN`：可选：RTMP协议推流域名，有使用RTMP协议推流时配置即可
  - `PLAY_DOMAIN`：可选：配置的拉流域名
  - `LIVE_URL_KEY`：可选：如果开通鉴权配置的鉴权Key
4. 修改 app模块下的 `build.gradle` 文件中 `applicationId` 字段 为License 信息所对应的包名


### 第三步：编译运行
用 Android Studio 打开该项目，连上Android设备，编译并运行。

## 第四步：示例体验

在欢迎页，输入用户名(请确保用户名唯一性，不能与其他用户重复)，比如111，进行登录，即可观看我们为您提供的默认地址的直播流。

我们在自己的[小直播](https://github.com/tencentyun/XiaoZhiBo)工程中也使用了该TUIPlayer组件，可以参考。

## 常见问题
- [TUI 场景化解决方案常见问题](https://cloud.tencent.com/developer/article/1952880)
- 欢迎加入 QQ 群：592465424，进行技术交流和反馈~
