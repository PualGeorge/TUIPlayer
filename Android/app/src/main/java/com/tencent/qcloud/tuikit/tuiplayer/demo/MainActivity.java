package com.tencent.qcloud.tuikit.tuiplayer.demo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuiplayer.view.TUIPlayerView;
import com.tencent.qcloud.tuikit.tuiplayer.view.listener.TUIPlayerViewListener;

/**
 * TUIPlayerView 拉流测试主页
 * <p>
 * 拉流逻辑主要依赖 tuiplayer 模块中的{@link TUIPlayerView} 实现
 */
public class MainActivity extends AppCompatActivity {
    private static final String DEFAULT_PLAYURL = "webrtc://5664.liveplay.myqcloud.com/live/5664_harchar1";

    private TUIPlayerView mTUIPlayerView;
    private String        mRoomId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        mTUIPlayerView = new TUIPlayerView(this);
        setContentView(mTUIPlayerView);
        mTUIPlayerView.setTUIPlayerViewListener(new TUIPlayerViewListener() {
            @Override
            public void onPlayStarted(TUIPlayerView playView, String url) {
                ToastUtils.showShort("Play Start");
            }

            @Override
            public void onPlayStoped(TUIPlayerView playView, String url) {
                ToastUtils.showShort("Paly End");
            }

            @Override
            public void onPlayEvent(TUIPlayerView playView, TUIPlayerEvent event, String message) {
                ToastUtils.showShort("Paly event-> event:" + event + " ,message:" + message);
            }

            @Override
            public void onRejectJoinAnchorResponse(TUIPlayerView playView, int reason) {
                if (reason == 1) {
                    ToastUtil.toastShortMessage(getString(R.string.app_anchor_reject_request));
                } else if (reason == 2) {
                    ToastUtil.toastShortMessage(getString(R.string.app_anchor_busy));
                } else {
                    ToastUtil.toastShortMessage("error -> reason:" + reason);
                }
            }
        });
        mTUIPlayerView.setGroupID(mRoomId);
        mTUIPlayerView.startPlay(DEFAULT_PLAYURL);
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTUIPlayerView.stopPlay();
    }
}
