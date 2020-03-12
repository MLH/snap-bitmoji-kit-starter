package com.snapchat.kit.bitmojisample;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snapchat.kit.sdk.SnapKit;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.bitmoji.OnBitmojiSearchFocusChangeListener;
import com.snapchat.kit.sdk.bitmoji.OnBitmojiSelectedListener;
import com.snapchat.kit.sdk.bitmoji.ui.BitmojiFragment;
import com.snapchat.kit.sdk.bitmoji.ui.BitmojiIconFragment;
import com.snapchat.kit.bitmojisample.chat.ChatAdapter;
import com.snapchat.kit.bitmojisample.chat.model.ChatImageMessage;
import com.snapchat.kit.bitmojisample.chat.model.ChatImageUrlMessage;
import com.snapchat.kit.bitmojisample.chat.model.ChatMessage;
import com.snapchat.kit.bitmojisample.chat.model.ChatTextMessage;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;


public class TestAppActivity extends AppCompatActivity implements

    {





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

    }

    @Override
    public void onGlobalLayout() {

    }

    @Override
    public void onBitmojiSelected(String imageUrl, Drawable previewDrawable) {

    }

    @Override
    public void onBitmojiSearchFocusChange(boolean hasFocus) {

    }

    @Override
    public void onLoginSucceeded() {
        loadExternalId();
    }

    @Override
    public void onLoginFailed() {
        // no-op
    }

    @Override
    public void onLogout() {
        // no-op
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {

    }

    private void loadExternalId() {
        SnapLogin.fetchUserData(this, EXTERNAL_ID_QUERY, null, new FetchUserDataCallback() {
            @Override
            public void onSuccess(@Nullable UserDataResponse userDataResponse) {
                if (userDataResponse == null || userDataResponse.hasError()) {
                    return;
                }
                mMyExternalId = userDataResponse.getData().getMe().getExternalId();
                mFriendmojiToggle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(boolean isNetworkError, int statusCode) {
                // handle error
            }
        });
    }

    private void setBitmojiVisible(boolean isBitmojiVisible) {

    }

    private void defocusInput() {

    }

    private void handleBitmojiSend(String imageUrl, Drawable previewDrawable) {

    }

    private void sendText() {
        String text = mTextField.getText().toString();
        if (TextUtils.isEmpty(text)) {
            return;
        }

        sendMessage(new ChatTextMessage(true /*isFromMe*/, text));
        mTextField.setText("");
    }

    private void sendMessage(ChatMessage message) {

    }

    private void sendDelayedMessage(final ChatMessage message, long delayMs) {
        mContentView.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendMessage(message);
            }
        }, delayMs);
    }

    private static int getRootViewHeightDiff(View view) {
        return view.getRootView().getHeight() - view.getHeight();
    }
}
